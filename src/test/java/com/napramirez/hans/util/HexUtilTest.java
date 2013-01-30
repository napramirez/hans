package com.napramirez.hans.util;

import junit.framework.TestCase;

/**
 * HexUtilTest
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class HexUtilTest extends TestCase
{
    public void testToIntInvalidHexDigit_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toInt('G');
            fail("Invalid hex digit!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToHexDigitNegativeNumber_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toHexDigit(-1);
            fail("Invalid hex digit!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToHexDigitMaxNumberOverflow_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toHexDigit(16);
            fail("Invalid hex digit!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToIntValidHexDigit_shouldPass() throws Exception
    {
        assertEquals(0, HexUtil.INSTANCE.toInt('0'));
        assertEquals(1, HexUtil.INSTANCE.toInt('1'));
        assertEquals(2, HexUtil.INSTANCE.toInt('2'));
        assertEquals(3, HexUtil.INSTANCE.toInt('3'));
        assertEquals(4, HexUtil.INSTANCE.toInt('4'));
        assertEquals(5, HexUtil.INSTANCE.toInt('5'));
        assertEquals(6, HexUtil.INSTANCE.toInt('6'));
        assertEquals(7, HexUtil.INSTANCE.toInt('7'));
        assertEquals(8, HexUtil.INSTANCE.toInt('8'));
        assertEquals(9, HexUtil.INSTANCE.toInt('9'));
        assertEquals(10, HexUtil.INSTANCE.toInt('A'));
        assertEquals(11, HexUtil.INSTANCE.toInt('B'));
        assertEquals(12, HexUtil.INSTANCE.toInt('C'));
        assertEquals(13, HexUtil.INSTANCE.toInt('D'));
        assertEquals(14, HexUtil.INSTANCE.toInt('E'));
        assertEquals(15, HexUtil.INSTANCE.toInt('F'));

        assertEquals(10, HexUtil.INSTANCE.toInt('a'));
        assertEquals(11, HexUtil.INSTANCE.toInt('b'));
        assertEquals(12, HexUtil.INSTANCE.toInt('c'));
        assertEquals(13, HexUtil.INSTANCE.toInt('d'));
        assertEquals(14, HexUtil.INSTANCE.toInt('e'));
        assertEquals(15, HexUtil.INSTANCE.toInt('f'));
    }

    public void testToHexDigitValidChar_shouldPass() throws Exception
    {
        assertEquals('0', HexUtil.INSTANCE.toHexDigit(0));
        assertEquals('1', HexUtil.INSTANCE.toHexDigit(1));
        assertEquals('2', HexUtil.INSTANCE.toHexDigit(2));
        assertEquals('3', HexUtil.INSTANCE.toHexDigit(3));
        assertEquals('4', HexUtil.INSTANCE.toHexDigit(4));
        assertEquals('5', HexUtil.INSTANCE.toHexDigit(5));
        assertEquals('6', HexUtil.INSTANCE.toHexDigit(6));
        assertEquals('7', HexUtil.INSTANCE.toHexDigit(7));
        assertEquals('8', HexUtil.INSTANCE.toHexDigit(8));
        assertEquals('9', HexUtil.INSTANCE.toHexDigit(9));
        assertEquals('A', HexUtil.INSTANCE.toHexDigit(10));
        assertEquals('B', HexUtil.INSTANCE.toHexDigit(11));
        assertEquals('C', HexUtil.INSTANCE.toHexDigit(12));
        assertEquals('D', HexUtil.INSTANCE.toHexDigit(13));
        assertEquals('E', HexUtil.INSTANCE.toHexDigit(14));
        assertEquals('F', HexUtil.INSTANCE.toHexDigit(15));
    }

    public void testToBytesNullHexString_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toBytes(null);
            fail("Hex string cannot be empty!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToBytesEmptyHexString_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toBytes("");
            fail("Hex string cannot be empty!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToBytesSpaceHexString_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toBytes(" ");
            fail("Hex string cannot be empty!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToBytesSingleDigitHexString_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toBytes("0");
            fail("Invalid string length.  Length must be a multiple of 2.");
        }
        catch (Exception e)
        {
        }
    }

    public void testToBytesOddDigitHexString_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toBytes("012");
            fail("Invalid string length.  Length must be a multiple of 2.");
        }
        catch (Exception e)
        {
        }
    }

    public void testToBytesInvalidHexDigitHexString_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toBytes("GH");
            fail("Invalid hex number format!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToHexStringNullInput_shouldFail() throws Exception
    {
        try
        {
            HexUtil.INSTANCE.toHexString(null);
            fail("Input data cannot be null!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToBytesValidHexString_shouldPass() throws Exception
    {
        String hexString = "00FF";

        byte[] bytes = new byte[2];
        bytes[0] = 0;
        bytes[1] = -1;

        byte[] hexBytes = HexUtil.INSTANCE.toBytes(hexString);
        assertEquals(bytes[0], hexBytes[0]);
        assertEquals(bytes[1], hexBytes[1]);
    }

    public void testToHexStringValidInput_shouldPass() throws Exception
    {
        String hexString = "00FF";

        byte[] bytes = new byte[2];
        bytes[0] = 0;
        bytes[1] = -1;

        assertEquals(hexString, HexUtil.INSTANCE.toHexString(bytes));
    }
}
