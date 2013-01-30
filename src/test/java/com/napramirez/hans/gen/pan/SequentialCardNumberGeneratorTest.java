package com.napramirez.hans.gen.pan;

import junit.framework.TestCase;

import com.napramirez.hans.gen.GenerationException;
import com.napramirez.hans.verify.LuhnCardNumberVerifier;

/**
 * SequentialCardNumberGeneratorTest
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class SequentialCardNumberGeneratorTest extends TestCase
{
    private SequentialCardNumberGenerator cardNumberGenerator;

    protected void setUp() throws Exception
    {
        super.setUp();
        cardNumberGenerator = new SequentialCardNumberGenerator(new LuhnCardNumberVerifier());
    }

    public void testGenerateWithInvalidLength() throws Exception
    {
        try
        {
            cardNumberGenerator.generate(-1);
            fail("Card number lengths should be greater than 1!");
        }
        catch (GenerationException e)
        {
        }

        try
        {
            cardNumberGenerator.generate(0);
            fail("Card number lengths should be greater than 1!");
        }
        catch (GenerationException e)
        {
        }
    }

    public void testGenerateWithInvalidPrefix() throws Exception
    {
        try
        {
            cardNumberGenerator.generate("000000", 6);
            fail("Prefix lengths cannot be equal to the card number length!");
        }
        catch (GenerationException e)
        {
        }

        try
        {
            cardNumberGenerator.generate("0000000", 6);
            fail("Prefix lengths cannot be greater than the card number length!");
        }
        catch (GenerationException e)
        {
        }
    }
}
