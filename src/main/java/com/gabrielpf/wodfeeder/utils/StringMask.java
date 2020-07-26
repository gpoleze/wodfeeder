package com.gabrielpf.wodfeeder.utils;

import java.util.stream.IntStream;

public class StringMask {

    private static String replace(String text, int adjustedStart, int adjustedEnd, char maskChar) {
        final var stringBuilder = new StringBuilder(text.length());

        IntStream
                .range(0, text.length())
                .mapToObj(index -> adjustedStart <= index && index < adjustedEnd ? maskChar : text.charAt(index))
                .forEach(stringBuilder::append);

        return stringBuilder.toString();
    }

    /**
     * Replace masks the text with the chars. [start,end)
     * Start is included
     * End is excluded
     *
     * @param text     the string will be masked
     * @param start    index where the masking will begin
     * @param end      index where the masking will end
     * @param maskChar the character that will be replace the original ones
     * @return the text masked from start to end
     */
    public static String mask(final String text, final int start, final int end, final char maskChar) {
        if (text == null || text.isEmpty()) return "";

        var adjustedStart = Math.max(start, 0);
        var adjustedEnd = Math.min(end, text.length());

        if (adjustedStart > adjustedEnd) throw new IllegalArgumentException("Start index cannot be bigger than end");
        if (adjustedStart == adjustedEnd) return text;

        return replace(text, adjustedStart, adjustedEnd, maskChar);
    }

    public static String mask(String text, int start, char maskChar) {
        if (text == null || text.isEmpty()) return "";
        var adjustedStart = Math.max(start, 0);
        var end = text.length();

        if (adjustedStart > end)
            throw new IllegalArgumentException("Start index cannot be bigger than the text's length");

        return replace(text, adjustedStart, end, maskChar);
    }
}
