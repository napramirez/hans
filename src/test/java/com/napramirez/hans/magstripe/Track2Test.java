package com.napramirez.hans.magstripe;

import com.napramirez.hans.magstripe.Track2;

import junit.framework.TestCase;

/**
 * Track2Test
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class Track2Test extends TestCase
{
    public void testTrack2GeneratedStrings() throws Exception
    {
        Track2 track2 = new Track2();
        track2.setPan("1234567890123445");
        track2.setExpirationDate("1402");
        track2.setServiceCode("000");

        assertEquals(";1234567890123445=1402000?*", track2.toString());
    }

    public void testTrack2ParsedFields() throws Exception
    {
        Track2 track2 = new Track2(";1234567890123445=1402000?*");

        assertEquals("1234567890123445", track2.getPan());
        assertEquals("1402", track2.getExpirationDate());
        assertEquals("000", track2.getServiceCode());
        assertEquals("*", track2.getLrc());
    }
}
