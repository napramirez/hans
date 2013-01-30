package com.napramirez.hans.crypto;

/**
 * EncryptionException
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class EncryptionException extends Exception
{
    private static final long serialVersionUID = -1677270268668370804L;

    public EncryptionException(String message)
    {
        super(message);
    }

    public EncryptionException(Throwable throwable)
    {
        super(throwable);
    }

    public EncryptionException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
