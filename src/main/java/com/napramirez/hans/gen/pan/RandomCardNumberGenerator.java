package com.napramirez.hans.gen.pan;

import com.napramirez.hans.gen.GenerationException;
import com.napramirez.hans.verify.CardNumberVerifier;
import com.napramirez.hans.verify.VerificationException;

/**
 * RandomCardNumberGenerator generates random card numbers that are verfied by
 * the Formula.
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class RandomCardNumberGenerator implements CardNumberGenerator
{
    private CardNumberVerifier verifier;

    public RandomCardNumberGenerator(CardNumberVerifier verifier)
    {
        this.verifier = verifier;
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
            StringBuilder sb = new StringBuilder(prefix);

            for (int i = sb.length(); i < length; i++)
            {
                sb.append(new Double(Math.floor(Math.random() * 10)).intValue());
            }

            String cardNumber = sb.toString();

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
