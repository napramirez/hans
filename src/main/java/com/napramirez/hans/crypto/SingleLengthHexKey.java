package com.napramirez.hans.crypto;

import com.napramirez.hans.util.HexUtil;

/**
 * SingleLengthHexKey
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class SingleLengthHexKey implements HexKey
{
    private byte[] bytes;

    public SingleLengthHexKey(byte[] bytes)
    {
        if (bytes.length != getKeyLength().lengthInBytes())
        {
            throw new IllegalArgumentException("Invalid key length: " + bytes.length);
        }

        this.bytes = bytes;
    }

    public SingleLengthHexKey(String keyString)
    {
        this(HexUtil.INSTANCE.toBytes(keyString));
    }

    public KeyLength getKeyLength()
    {
        return KeyLength.SINGLE;
    }

    public byte[] getBytes()
    {
        return bytes;
    }

    @Override
    public String toString()
    {
        return HexUtil.INSTANCE.toHexString(bytes);
    }
}
