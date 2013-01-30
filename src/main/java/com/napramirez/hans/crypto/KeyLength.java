package com.napramirez.hans.crypto;

/**
 * KeyLength
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public enum KeyLength
{
    SINGLE(8),
    DOUBLE(16),
    TRIPLE(24);

    private int length;

    KeyLength(int length)
    {
        this.length = length;
    }

    public int lengthInBytes()
    {
        return length;
    }

    public int lengthInHexDigits()
    {
        return length * 2;
    }
}
