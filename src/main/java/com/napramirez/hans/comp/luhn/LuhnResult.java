package com.napramirez.hans.comp.luhn;

import com.napramirez.hans.comp.Result;

/**
 * LuhnResult
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class LuhnResult implements Result
{
    private String value;

    private boolean successful;

    public LuhnResult(String value, boolean successful)
    {
        this.value = value;
        this.successful = successful;
    }

    public String getValue()
    {
        return value;
    }

    public boolean isSuccessful()
    {
        return successful;
    }
}
