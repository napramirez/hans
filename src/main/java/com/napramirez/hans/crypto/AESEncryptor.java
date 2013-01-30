package com.napramirez.hans.crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import com.napramirez.hans.util.HexUtil;

/**
 * AESEncryptor
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class AESEncryptor implements Encryptor
{
    private Cipher cipher;

    public AESEncryptor() throws EncryptionException
    {
        try
        {
            cipher = Cipher.getInstance("AES/ECB/NoPadding");
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
            SecretKeySpec secretKeySpec = new SecretKeySpec(hexKey.getBytes(), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

            cipherText = cipher.doFinal(bytes);
        }
        catch (InvalidKeyException e)
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
