package com.napramirez.hans.magstripe;

import junit.framework.TestCase;

/**
 * Track1Test
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class Track1Test extends TestCase
{
    public void testSetPan_nullPANShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setPan(null);

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
            Track1 track1 = new Track1();
            track1.setPan("");

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
            Track1 track1 = new Track1();
            track1.setPan("ABC");

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
            Track1 track1 = new Track1();
            track1.setPan("12345678901234567890");

            fail("PAN length should not exceed allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetName_nullNameShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setName(null);

            fail("Name should not be null!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetName_emptyNameShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setName("");

            fail("Name should not be empty!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetName_separatorInNameShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setName("DE LA CRUZ/JUAN^");

            fail("Name should not contain the field separator!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetName_exceedingLengthNameShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setName("DE LA CRUZ/JUAN TATAMAD-TAMAD");

            fail("Name should not exceed the allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetExpirationDate_emptyExpiryDateShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setExpirationDate("");

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
            Track1 track1 = new Track1();
            track1.setExpirationDate("ABC");

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
            Track1 track1 = new Track1();
            track1.setExpirationDate("^");

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
            Track1 track1 = new Track1();
            track1.setExpirationDate("12345");

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
            Track1 track1 = new Track1();
            track1.setServiceCode("");

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
            Track1 track1 = new Track1();
            track1.setServiceCode("ABC");

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
            Track1 track1 = new Track1();
            track1.setServiceCode("^");

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
            Track1 track1 = new Track1();
            track1.setServiceCode("1234");

            fail("Service Code should not exceed the allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testSetDiscretionaryData_separatorInDiscretionaryDataShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setDiscretionaryData("?");

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
            Track1 track1 = new Track1();
            track1.setLrc("12");

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
            Track1 track1 = new Track1();
            track1.setName("DE LA CRUZ/JUAN");
            track1.toString();

            fail("PAN should not be null!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToString_nullNameShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setPan("1111222233334444");
            track1.toString();

            fail("Name should not be null!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToString_exceedingTrack1LengthShouldFail() throws Exception
    {
        try
        {
            Track1 track1 = new Track1();
            track1.setPan("1111222233334444555");
            track1.setName("DE LA CRUZ/JUAN");
            track1.setExpirationDate("1234");
            track1.setServiceCode("123");
            track1.setDiscretionaryData("                                  ");
            track1.setLrc("*");
            track1.toString();

            fail("Track1 should not exceed the allowed length!");
        }
        catch (Exception e)
        {
        }
    }

    public void testToString_allFieldsFilledShouldPass() throws Exception
    {
        Track1 track1 = new Track1();
        track1.setPan("1111222233334444555");
        track1.setName("DE LA CRUZ/JUAN");
        track1.setExpirationDate("1234");
        track1.setServiceCode("123");
        track1.setDiscretionaryData("                                ");
        track1.setLrc("*");

        assertEquals("%B1111222233334444555^DE LA CRUZ/JUAN^1234123                                ?*", track1.toString());
    }

    public void testToString_allRequiredFieldsFilledShouldPass() throws Exception
    {
        Track1 track1 = new Track1();
        track1.setPan("1111222233334444555");
        track1.setName("DE LA CRUZ/JUAN");

        assertEquals("%B1111222233334444555^DE LA CRUZ/JUAN^^^?", track1.toString());
    }
}
