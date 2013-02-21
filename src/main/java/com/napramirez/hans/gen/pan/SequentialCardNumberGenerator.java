package com.napramirez.hans.gen.pan;

import com.napramirez.hans.gen.GenerationException;
import com.napramirez.hans.util.StringPaddingUtil;
import com.napramirez.hans.verify.CardNumberVerifier;
import com.napramirez.hans.verify.VerificationException;

/**
 * SequentialCardNumberGenerator generates card numbers in increasing sequence.
 * The card numbers are verified by the Formula.
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class SequentialCardNumberGenerator implements CardNumberGenerator
{
    private static char DEFAULT_PADDING_CHARACTER = '0';

    private long counter;

    private CardNumberVerifier verifier;

    public SequentialCardNumberGenerator(CardNumberVerifier verifier)
    {
        this(0, verifier);
    }

    public SequentialCardNumberGenerator(long startingNumber, CardNumberVerifier verifier)
    {
        reset(startingNumber);
        this.verifier = verifier;
    }

    public void reset(long start)
    {
        counter = start;
    }

    public String generate(int length) throws GenerationException
    {
        return generate(null, length);
    }

    public String generate(String prefix, int length) throws GenerationException
    {
        if (prefix == null)
        {
            prefix = "";
        }

        if (length < 2)
        {
            throw new GenerationException("Card number length cannot be less than 2 digits!");
        }

        if (length <= prefix.length())
        {
            throw new GenerationException("Card number length should be greater than card prefix length!");
        }

        while (true)
        {
            long currentNumber = counter++;

            String currentNumberString = String.valueOf(currentNumber);
            if (currentNumberString.length() > length - prefix.length())
            {
                throw new GenerationException("Card number length exceeded!");
            }

            String cardNumber = prefix + StringPaddingUtil.INSTANCE.padLeft(currentNumberString, DEFAULT_PADDING_CHARACTER, length - prefix.length());

            try
            {
                verifier.verify(cardNumber);

                return cardNumber;
            }
            catch (VerificationException e)
            {
                continue;
            }
        }
    }
}
