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
import javax.crypto.spec.DESKeySpec;

import com.napramirez.hans.util.HexUtil;

/**
 * DESEncryptor
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class DESEncryptor implements Encryptor
{
    private Cipher cipher;

    private SecretKeyFactory secretKeyFactory;

    public DESEncryptor() throws EncryptionException
    {
        this(false);
    }

    public DESEncryptor(boolean pad) throws EncryptionException
    {
        try
        {
            cipher = Cipher.getInstance("DES/ECB/" + (pad ? "PKCS5Padding" : "NoPadding"));
            secretKeyFactory = SecretKeyFactory.getInstance("DES");
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
            KeySpec keySpec = new DESKeySpec(hexKey.getBytes());
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
