package com.napramirez.hans.comp.luhn;

import com.napramirez.hans.comp.Formula;
import com.napramirez.hans.comp.Result;

/**
 * LuhnFormula
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class LuhnFormula implements Formula
{
    public Result calculate(String input)
    {
        String checkDigit = input.substring(input.length() - 1);
        String partialCardNumber = input.substring(0, input.length() - 1);

        int sum = 0;
        boolean toDouble = true;
        for (int i = partialCardNumber.length() - 1; i >= 0; i--)
        {
            int digitValue = Integer.parseInt(String.valueOf(partialCardNumber.charAt(i)));

            if (toDouble)
            {
                digitValue *= 2;
                digitValue = digitValue > 9 ? digitValue - 9 : digitValue;
                toDouble = false;
            }
            else
            {
                toDouble = true;
            }

            sum += digitValue;
        }

        int checkDigitValue = sum * 9 % 10;

        return new LuhnResult(String.valueOf(checkDigitValue), checkDigitValue == Integer.parseInt(checkDigit));
    }
}
