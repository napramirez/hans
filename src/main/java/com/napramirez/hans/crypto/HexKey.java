package com.napramirez.hans.crypto;

/**
 * HexKey
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public interface HexKey
{
    KeyLength getKeyLength();

    byte[] getBytes();
}
