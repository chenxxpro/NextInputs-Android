package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * 中国身份证号码15位和18位校验器
 * @author Yoojia Chen (yoojia.chen@gmail.com)
 * @since 1.0
 */
public class IDCardVerifier extends EmptyableVerifier {

    static final int[] WEIGHT = {7,9,10,5,8,4,2,1,6,3,7,9,10,5,8,4,2};

    static final char[] VALID = {'1','0','X','9','8','7','6','5','4','3','2'};

    static final SimpleDateFormat YYMMdd = new SimpleDateFormat("yyMMdd", Locale.getDefault());

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) {
        final int length = notEmptyInput.length();
        if (15 == length){
            try{
                return isOldCNIDCard(notEmptyInput);
            }catch (Exception e){
                return false;
            }
        }else if (18 == length){
            return isNewCNIDCard(notEmptyInput.toUpperCase());
        }else {
            return false;
        }
    }

    public static boolean isNewCNIDCard(String numbers){
        int sum = 0;
        for (int i = 0; i < WEIGHT.length; i++){
            final int cell = Character.getNumericValue(numbers.charAt(i));
            sum += WEIGHT[i] * cell;
        }
        int index = sum % 11;
        return VALID[index] == numbers.charAt(17);
    }

    public static boolean isOldCNIDCard(String numbers){
        final String abcdef = numbers.substring(0,5);
        final String yymmdd = numbers.substring(6,11);
        final String xxx = numbers.substring(12,14);
        final boolean aPass = abcdef.equals(String.valueOf(Integer.parseInt(abcdef)));
        boolean yPass = true;
        try {
            YYMMdd.parse(yymmdd);
        } catch (ParseException e) {
            e.printStackTrace();
            yPass = false;
        }
        boolean xPass = Pattern.compile("\\d{2}[\\dxX]").matcher(xxx).matches();
        return aPass && yPass && xPass;
    }
}
