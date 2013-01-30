package com.napramirez.hans.verify;

import com.napramirez.hans.comp.Formula;
import com.napramirez.hans.comp.Result;
import com.napramirez.hans.comp.luhn.LuhnFormula;

/**
 * LuhnCardNumberVerifier
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class LuhnCardNumberVerifier implements CardNumberVerifier
{
    private Formula formula;

    public LuhnCardNumberVerifier()
    {
        formula = new LuhnFormula();
    }

    public void verify(String cardNumber) throws VerificationException
    {
        Result result = formula.calculate(cardNumber);

        if (!result.isSuccessful())
        {
            throw new VerificationException("Check digit mismatch in '" + cardNumber + "': " + result.getValue());
        }
    }
}
