package org.jonathany23.javatests.util;

import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void testRepeat() {

        Assert.assertEquals(StringUtil.repeat("hola", 3), "holaholahola");
        Assert.assertEquals(StringUtil.repeat("hola", 1), "hola");
    }
}