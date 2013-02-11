package com.napramirez.hans.magstripe;

import junit.framework.TestCase;

/**
 * Track2Test
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class Track2Test extends TestCase
{
    public void testSetPan_nullPANShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setPan(null);

            fail("PAN should not be null!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetPan_emptyPANShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setPan("");

            fail("PAN should not be empty!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetPan_nonNumericPANShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setPan("ABC");

            fail("PAN should be numeric!");
        }
        catch (Exception e)
        {
        }

    }

    public void testSetPan_exceedingLengthPANShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setPan("12345678901234567890");

            fail("PAN length should not exceed allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetExpirationDate_emptyExpiryDateShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setExpirationDate("");

            fail("Expiration Date should not be empty!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetExpirationDate_nonNumericExpiryDateShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setExpirationDate("ABC");

            fail("Expiration Date should be numeric!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetExpirationDate_separatorInExpiryDateShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setExpirationDate("=");

            fail("Expiration Date should not contain the field separator!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetExpirationDate_exceedingLengthExpiryDateShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setExpirationDate("12345");

            fail("Expiration Date should exceed the allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetServiceCode_emptyServiceCodeShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setServiceCode("");

            fail("Service Code should not be empty!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetServiceCode_nonNumericServiceCodeShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setServiceCode("ABC");

            fail("Service Code should be numeric!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetServiceCode_separatorInServiceCodeShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setServiceCode("=");

            fail("Service Code should not contain the field separator!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetServiceCode_exceedingLengthServiceCodeShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setServiceCode("1234");

            fail("Service Code should not exceed the allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetServiceCode_nonNumericDiscretionaryDataShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setDiscretionaryData("ABC");

            fail("Service Code should be numeric!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetDiscretionaryData_separatorInDiscretionaryDataShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setDiscretionaryData("?");

            fail("Discretionary Data should not contain the end sentinel!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetLRC_exceedingLengthLRCShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setLrc("12");

            fail("LRC should not exceed the allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToString_nullPANShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.toString();

            fail("PAN should not be null!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToString_exceedingTrack2LengthShouldFail() throws Exception
    {
        try
        {
            Track2 track2 = new Track2();
            track2.setPan("1111222233334444555");
            track2.setExpirationDate("1234");
            track2.setServiceCode("123");
            track2.setDiscretionaryData("00000000001");
            track2.setLrc("*");
            track2.toString();

            fail("Track2 should not exceed the allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToString_allFieldsFilledShouldPass() throws Exception
    {
        Track2 track2 = new Track2();
        track2.setPan("1111222233334444555");
        track2.setExpirationDate("1234");
        track2.setServiceCode("123");
        track2.setDiscretionaryData("0000000000");
        track2.setLrc("*");

        assertEquals(";1111222233334444555=12341230000000000?*", track2.toString());
    }

    public void testToString_allRequiredFieldsFilledShouldPass() throws Exception
    {
        Track2 track2 = new Track2();
        track2.setPan("1111222233334444555");

        assertEquals(";1111222233334444555===?", track2.toString());
    }
}
