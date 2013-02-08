package com.napramirez.hans.gen.pin;

import com.napramirez.hans.crypto.DESEncryptor;
import com.napramirez.hans.crypto.DESKey;
import com.napramirez.hans.crypto.EncryptionException;
import com.napramirez.hans.crypto.Encryptor;
import com.napramirez.hans.crypto.HexKey;
import com.napramirez.hans.gen.GenerationException;
import com.napramirez.hans.util.DecUtil;

/**
 * DefaultPINGenerator
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class DefaultPINGenerator implements PINGenerator
{
    public static final int DEFAULT_PIN_LENGTH = 4;

    private Encryptor encryptor;

    public DefaultPINGenerator() throws GenerationException
    {
        try
        {
            encryptor = new DESEncryptor(true);
        }
        catch (EncryptionException e)
        {
            throw new GenerationException(e);
        }
    }

    public String generate(HexKey key, String pan) throws GenerationException
    {
        return generate(key, pan, DEFAULT_PIN_LENGTH);
    }

    public String generate(HexKey key, String pan, int length) throws GenerationException
    {
        if (length > key.getKeyLength().lengthInHexDigits())
        {
            throw new IllegalArgumentException("PIN length cannot exceed the PIN cipher length!");
        }

        String result;
        try
        {
            result = encryptor.encrypt(key, pan);
        }
        catch (EncryptionException e)
        {
            throw new GenerationException(e);
        }

        return DecUtil.INSTANCE.decimalizeFromHex(result.substring(0, length));
    }
}
