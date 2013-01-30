package com.napramirez.hans.crypto;

/**
 * Encryptor
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public interface Encryptor
{
    byte[] encrypt(HexKey hexKey, byte[] bytes) throws EncryptionException;

    String encrypt(HexKey hexKey, String message) throws EncryptionException;
}
