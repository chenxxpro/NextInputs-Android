package com.github.yoojia.inputs;

/**
 * @author Yoojia Chen (yoojiachen@gmail.com)
 * @since 1.7
 */
public class InputProviders {

    public static Input fixedString(final String fixedValue) {
        return new Input() {
            @Override public String getValue() {
                return fixedValue;
            }
        };
    }

    public static Input fixedInt(int fixedValue) {
        return fixedString(String.valueOf(fixedValue));
    }

    public static Input fixedLong(long fixedValue) {
        return fixedString(String.valueOf(fixedValue));
    }

    public static Input fixedFloat(float fixedValue) {
        return fixedString(String.valueOf(fixedValue));
    }

    public static Input fixedDouble(double fixedValue) {
        return fixedString(String.valueOf(fixedValue));
    }

    public static Input fixedBool(boolean fixedValue) {
        return fixedString(String.valueOf(fixedValue));
    }
}
