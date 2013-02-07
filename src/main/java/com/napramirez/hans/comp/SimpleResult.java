package com.napramirez.hans.comp;

/**
 * SimpleResult
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class SimpleResult implements Result
{
    private String value;

    private boolean successful;

    public SimpleResult(String value, boolean successful)
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
