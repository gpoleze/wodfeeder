package com.gabrielpf.wodfeeder.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringMaskTest {
    private final char maskChar = '*';
    private String text;

    @BeforeEach
    void setUp() {
        this.text = "text";
    }

    @ParameterizedTest
    @NullAndEmptySource
    void returnEmptyStringIfTextIsNull(String text) {
        final var actual = StringMask.mask(text, 0, 1, maskChar);
        assertEquals("", actual);
    }

    @Test
    void textWillHaveNoReplacementIfStartAndEndAreTheSame() {
        final var actual = StringMask.mask(text, 1, 1, maskChar);
    }

    @ParameterizedTest
    @CsvSource({"1,0", "-10,-10", "10,10"})
    void exceptionIsThrownWhenEndIsBiggerThanTheStar(int start, int end) {
        assertThrows(IllegalArgumentException.class, () -> StringMask.mask(text, start, end, maskChar));
    }

    @Test
    void startWillBeAdjustedToZeroIfArgumentIsLesserThanZero() {
        final var actual = StringMask.mask(text, -1, 1, maskChar);
        assertEquals("*ext", actual);
    }

    @Test
    void endWillBeAdjustedToTextLengthIfArgumentIsGreaterThanTheTextLength() {
        final var actual = StringMask.mask(text, 3, text.length() + 1, maskChar);
        assertEquals("tex*", actual);
    }

    @ParameterizedTest
    @CsvSource({"0,4", "-10,10"})
    void masksTheWholeText(int start, int end) {
        final var actual = StringMask.mask(text, start, end, maskChar);
        assertEquals("****", actual);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void returnEmptyStringIfTextIsNullWhitouthEndParameter(String text) {
        final var actual = StringMask.mask(text, 0, maskChar);
        assertEquals("", actual);
    }

    @Test
    void willRaiseExceptionIfStartGraterThanTextLength() {
        assertThrows(IllegalArgumentException.class, () -> StringMask.mask(text, text.length() + 1, maskChar));
    }

    @ParameterizedTest
    @CsvSource({"-1,****", "0,****", "1,t***", "02,te**", "3,tex*", "4,text"})
    void willReturnTextMasked(int start, String expected) {
        final var actual = StringMask.mask(text, start, maskChar);
        assertEquals(expected, actual);
    }
}