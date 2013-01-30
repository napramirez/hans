package com.napramirez.hans.verify;

/**
 * VerificationException
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class VerificationException extends Exception
{
    private static final long serialVersionUID = -3342647459279066581L;

    public VerificationException(String message)
    {
        super(message);
    }

    public VerificationException(Throwable throwable)
    {
        super(throwable);
    }

    public VerificationException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
