package org.jonathany23.javatests.reto1;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringUtilTest {

    @Test
    public void whenStringIsNotEmty() {
        assertEquals(false, StringUtil.isEmpty("hola"));
    }

    @Test
    public void whenStringIsEmty() {
        assertEquals(true, StringUtil.isEmpty(""));
    }

    @Test
    public void whenStringisNull() {
        assertEquals(true, StringUtil.isEmpty(null));
    }

    @Test
    public void whenStringHasSpaces() {
        assertEquals(true, StringUtil.isEmpty(" "));
    }
}