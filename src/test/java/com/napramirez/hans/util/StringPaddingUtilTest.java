package com.napramirez.hans.util;

import junit.framework.TestCase;

/**
 * StringPaddingUtilTest
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class StringPaddingUtilTest extends TestCase
{
    public void testPaddingNullInput_shouldFail() throws Exception
    {
        try
        {
            StringPaddingUtil.INSTANCE.padLeft(null, '0', 2);
            fail("Input string cannot be null!");
        }
        catch (IllegalArgumentException e)
        {
        }
    }

    public void testPaddingEmptyInput_shouldPass() throws Exception
    {
        assertEquals("xxxx", StringPaddingUtil.INSTANCE.padLeft("", 'x', 4));
    }

    public void testPaddingNullPadding_shouldFail() throws Exception
    {
        try
        {
            StringPaddingUtil.INSTANCE.padLeft("", null, 4);
            fail("Padding string cannot be empty!");
        }
        catch (IllegalArgumentException e)
        {
        }
    }

    public void testPaddingEmptyPadding_shouldFail() throws Exception
    {
        try
        {
            StringPaddingUtil.INSTANCE.padLeft("", "", 4);
            fail("Padding string cannot be empty!");
        }
        catch (IllegalArgumentException e)
        {
        }
    }

    public void testPaddingNegativeLength_shouldFail() throws Exception
    {
        try
        {
            StringPaddingUtil.INSTANCE.padLeft("", '0', -1);
            fail("Input string length cannot be greater than padded string length!");
        }
        catch (IllegalArgumentException e)
        {
        }
    }

    public void testPaddingZeroLength_shouldFail() throws Exception
    {
        try
        {
            StringPaddingUtil.INSTANCE.padLeft("1234", '0', 3);
            fail("Input string length cannot be greater than padded string length!");
        }
        catch (IllegalArgumentException e)
        {
        }
    }

    public void testPaddingLengthLessThanInput_shouldFail() throws Exception
    {
        try
        {
            StringPaddingUtil.INSTANCE.padLeft("1234", '0', 3);
            fail("Input string length cannot be greater than padded string length!");
        }
        catch (IllegalArgumentException e)
        {
        }
    }

    public void testPaddingUsingStringSameAsCharPadding_shouldPass() throws Exception
    {
        String input = "asdf";
        int length = 8;

        assertEquals(StringPaddingUtil.INSTANCE.padLeft(input, 'x', length), StringPaddingUtil.INSTANCE.padLeft(input, "x", length));
        assertEquals(StringPaddingUtil.INSTANCE.padRight(input, 'x', length), StringPaddingUtil.INSTANCE.padRight(input, "x", length));
    }

    public void testLeftPaddingString_shouldCyclePaddingToTheLeft() throws Exception
    {
        String paddingString = "abcdefghij";

        assertEquals("1234", StringPaddingUtil.INSTANCE.padLeft("1234", paddingString, 4));
        assertEquals("ghij1234", StringPaddingUtil.INSTANCE.padLeft("1234", paddingString, 8));
        assertEquals("ijabcdefghij1234", StringPaddingUtil.INSTANCE.padLeft("1234", paddingString, 16));
    }

    public void testRightPaddingString_shouldCyclePaddingToTheRight() throws Exception
    {
        String paddingString = "abcdefghij";

        assertEquals("1234", StringPaddingUtil.INSTANCE.padRight("1234", paddingString, 4));
        assertEquals("1234abcd", StringPaddingUtil.INSTANCE.padRight("1234", paddingString, 8));
        assertEquals("1234abcdefghijab", StringPaddingUtil.INSTANCE.padRight("1234", paddingString, 16));
    }

}
