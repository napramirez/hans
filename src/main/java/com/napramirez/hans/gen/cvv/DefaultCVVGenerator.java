package com.napramirez.hans.gen.cvv;

import com.napramirez.hans.crypto.DESKey;
import com.napramirez.hans.crypto.EncryptionException;
import com.napramirez.hans.crypto.Encryptor;
import com.napramirez.hans.crypto.HexKey;
import com.napramirez.hans.crypto.TripleDESEncryptor;
import com.napramirez.hans.gen.GenerationException;
import com.napramirez.hans.util.DecUtil;
import com.napramirez.hans.util.HexUtil;
import com.napramirez.hans.util.StringPaddingUtil;

/**
 * DefaultCVVGenerator
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class DefaultCVVGenerator implements CVVGenerator
{
    private Encryptor encryptor;

    public DefaultCVVGenerator() throws GenerationException
    {
        try
        {
            encryptor = new TripleDESEncryptor();
        }
        catch (EncryptionException e)
        {
            throw new GenerationException(e);
        }
    }

    public String generate(HexKey hexKey1, HexKey hexKey2, String pan, String expiryDate, String serviceCode) throws GenerationException
    {
        String block = StringPaddingUtil.INSTANCE.padRight(pan + expiryDate + serviceCode, '0', 32);
        String blockA = block.substring(0, 16);
        String blockB = block.substring(16);

        String result;
        try
        {
            result = encryptor.encrypt(new DESKey(hexKey1), blockA);
            result = HexUtil.INSTANCE.xor(result, blockB);
            result = encryptor.encrypt(new DESKey(hexKey1, hexKey2), result);
        }
        catch (EncryptionException e)
        {
            throw new GenerationException(e);
        }

        return DecUtil.INSTANCE.decimalizeFromHex(result.substring(0, 3));
    }
}
