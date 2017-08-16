package com.github.yoojia.inputs.verifiers;

import com.github.yoojia.inputs.EmptyableVerifier;

import java.util.Locale;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class MACAddressVerifier extends EmptyableVerifier {

    @Override
    public boolean performTestNotEmpty(String notEmptyInput) throws Exception {
        final String address = notEmptyInput.toUpperCase(Locale.ENGLISH);
        if(address.length() != "11:22:33:44:55:66".length()) {
            return false;
        }
        final String[] parts = address.contains(":") ? address.split(":") : address.split("-");
        if(parts.length != 6) {
            return false;
        }
        try{
            for (String part: parts){
                if(part.length() == 0) return false;
                final int value = Integer.parseInt(part, 16);
                if(0x00 > value || value > 0xFF) return false;
            }
        }catch (Exception e){
            return false;
        }
        return true;
    }

}
