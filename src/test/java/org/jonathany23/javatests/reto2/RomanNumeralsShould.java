package org.jonathany23.javatests.reto2;

import org.junit.Test;

import static org.junit.Assert.*;

public class RomanNumeralsShould {

    @Test
    public void when_roman_is_1() {
        assertEquals("I", RomanNumerals.arabicToRoman(1));
    }

    @Test
    public void when_roman_is_2() {
        assertEquals("II", RomanNumerals.arabicToRoman(2));
    }

    @Test
    public void when_roman_is_3() {
        assertEquals("III", RomanNumerals.arabicToRoman(3));
    }

    @Test
    public void when_roman_is_5() {
        assertEquals("V", RomanNumerals.arabicToRoman(5));
    }

    @Test
    public void when_roman_is_6() {
        assertEquals("VI", RomanNumerals.arabicToRoman(6));
    }

    @Test
    public void when_roman_is_7() {
        assertEquals("VII", RomanNumerals.arabicToRoman(7));
    }

    @Test
    public void when_roman_is_10() {
        assertEquals("X", RomanNumerals.arabicToRoman(10));
    }

    @Test
    public void when_roman_is_11() {
        assertEquals("XI", RomanNumerals.arabicToRoman(11));
    }

    @Test
    public void when_roman_is_16() {
        assertEquals("XVI", RomanNumerals.arabicToRoman(16));
    }

    @Test
    public void when_roman_is_50() {
        assertEquals("L", RomanNumerals.arabicToRoman(50));
    }

    @Test
    public void when_roman_is_51() {
        assertEquals("LI", RomanNumerals.arabicToRoman(51));
    }

    @Test
    public void when_roman_is_55() {
        assertEquals("LV", RomanNumerals.arabicToRoman(55));
    }

    @Test
    public void when_roman_is_56() {
        assertEquals("LVI", RomanNumerals.arabicToRoman(56));
    }

    @Test
    public void when_roman_is_60() {
        assertEquals("LX", RomanNumerals.arabicToRoman(60));
    }

    @Test
    public void when_roman_is_70() {
        assertEquals("LXX", RomanNumerals.arabicToRoman(70));
    }

    @Test
    public void when_roman_is_80() {
        assertEquals("LXXX", RomanNumerals.arabicToRoman(80));
    }

    @Test
    public void when_roman_is_81() {
        assertEquals("LXXXI", RomanNumerals.arabicToRoman(81));
    }

    @Test
    public void when_roman_is_85() {
        assertEquals("LXXXV", RomanNumerals.arabicToRoman(85));
    }

    @Test
    public void when_roman_is_86() {
        assertEquals("LXXXVI", RomanNumerals.arabicToRoman(86));
    }

    @Test
    public void when_roman_is_100() {
        assertEquals("C", RomanNumerals.arabicToRoman(100));
    }

    @Test
    public void when_roman_is_126x() {
        assertEquals("CXXVI", RomanNumerals.arabicToRoman(126));
    }
}