package com.napramirez.hans.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import com.napramirez.hans.util.HexUtil;

/**
 * TripleDESEncryptor
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class TripleDESEncryptor implements Encryptor
{
    private Cipher cipher;

    private SecretKeyFactory secretKeyFactory;

    public TripleDESEncryptor() throws EncryptionException
    {
        try
        {
            cipher = Cipher.getInstance("DESede/ECB/NoPadding");
            secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new EncryptionException(e);
        }
        catch (NoSuchPaddingException e)
        {
            throw new EncryptionException(e);
        }
    }

    public byte[] encrypt(HexKey hexKey, byte[] bytes) throws EncryptionException
    {
        byte[] cipherText = null;

        try
        {
            KeySpec keySpec = new DESedeKeySpec(hexKey.getBytes());
            SecretKey key = secretKeyFactory.generateSecret(keySpec);
            cipher.init(Cipher.ENCRYPT_MODE, key);

            cipherText = cipher.doFinal(bytes);
        }
        catch (InvalidKeyException e)
        {
            throw new EncryptionException(e);
        }
        catch (InvalidKeySpecException e)
        {
            throw new EncryptionException(e);
        }
        catch (IllegalBlockSizeException e)
        {
            throw new EncryptionException(e);
        }
        catch (BadPaddingException e)
        {
            throw new EncryptionException(e);
        }

        return cipherText;
    }

    public String encrypt(HexKey hexKey, String message) throws EncryptionException
    {
        return HexUtil.INSTANCE.toHexString(encrypt(hexKey, HexUtil.INSTANCE.toBytes(message)));
    }
}
