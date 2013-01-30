package com.napramirez.hans.gen;

/**
 * GenerationException
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class GenerationException extends Exception
{
    private static final long serialVersionUID = 5483719976287124713L;

    public GenerationException(String message)
    {
        super(message);
    }

    public GenerationException(Throwable throwable)
    {
        super(throwable);
    }

    public GenerationException(String message, Throwable throwable)
    {
        super(message, throwable);
    }
}
