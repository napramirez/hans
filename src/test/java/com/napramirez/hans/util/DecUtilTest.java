package com.napramirez.hans.util;

import junit.framework.TestCase;

/**
 * DecUtilTest
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class DecUtilTest extends TestCase
{
    public void testDecimalizeFromHex() throws Exception
    {
        assertEquals("0123456789012345", DecUtil.INSTANCE.decimalizeFromHex("0123456789ABCDEF"));
        assertEquals("0123456789012345", DecUtil.INSTANCE.decimalizeFromHex("0123456789abcdef"));
    }
}
