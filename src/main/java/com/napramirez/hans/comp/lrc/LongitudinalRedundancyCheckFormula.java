package com.napramirez.hans.comp.lrc;

import com.napramirez.hans.comp.Formula;
import com.napramirez.hans.comp.Result;
import com.napramirez.hans.comp.SimpleResult;

/**
 * LongitudinalRedundancyCheckFormula
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class LongitudinalRedundancyCheckFormula implements Formula
{

    public Result calculate(String input)
    {
        byte checksum = 0;

        for (int i = 0; i < input.length(); i++)
        {
            byte b = (byte) (Character.getNumericValue(input.charAt(i)) & 0xFF);

            checksum = (byte) ((checksum + b) & 0xFF);
        }

        checksum = (byte) (((checksum ^ 0xFF) + 1) & 0xFF);

        return new SimpleResult(String.valueOf(checksum), true);
    }
}
