package com.napramirez.hans.crypto;

import java.util.Arrays;

import com.napramirez.hans.util.HexUtil;

/**
 * DESKey
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class DESKey implements HexKey
{
    private HexKey partA;

    private HexKey partB;

    private HexKey partC;

    private KeyLength keyLength;

    private byte[] bytes;

    public DESKey(byte[] bytes)
    {
        this(new String(bytes));
    }

    public DESKey(String keyString)
    {
        if (keyString.length() == KeyLength.SINGLE.lengthInHexDigits())
        {
            partA = new SingleLengthHexKey(keyString);
            partB = partA;
            partC = partA;
            keyLength = KeyLength.SINGLE;
        }
        else if (keyString.length() == KeyLength.DOUBLE.lengthInHexDigits())
        {
            partA = new SingleLengthHexKey(keyString.substring(0, KeyLength.SINGLE.lengthInHexDigits()));
            partB = new SingleLengthHexKey(keyString.substring(KeyLength.SINGLE.lengthInHexDigits()));
            partC = partA;
            keyLength = KeyLength.DOUBLE;
        }
        else if (keyString.length() == KeyLength.TRIPLE.lengthInHexDigits())
        {
            partA = new SingleLengthHexKey(keyString.substring(0, KeyLength.SINGLE.lengthInHexDigits()));
            partB = new SingleLengthHexKey(keyString.substring(KeyLength.SINGLE.lengthInHexDigits(), KeyLength.DOUBLE.lengthInHexDigits()));
            partC = new SingleLengthHexKey(keyString.substring(KeyLength.DOUBLE.lengthInHexDigits()));
            keyLength = KeyLength.TRIPLE;
        }
        else
        {
            throw new IllegalArgumentException("Invalid key length: " + keyString.length());
        }

        int minKeyLengthInBytes = KeyLength.SINGLE.lengthInBytes();
        int maxKeyLengthInBytes = KeyLength.TRIPLE.lengthInBytes();
        bytes = new byte[maxKeyLengthInBytes];

        System.arraycopy(partA.getBytes(), 0, bytes, 0, minKeyLengthInBytes);
        System.arraycopy(partB.getBytes(), 0, bytes, minKeyLengthInBytes, minKeyLengthInBytes);
        System.arraycopy(partC.getBytes(), 0, bytes, minKeyLengthInBytes * 2, minKeyLengthInBytes);
    }

    public KeyLength getKeyLength()
    {
        return keyLength;
    }

    public byte[] getBytes()
    {
        switch (keyLength)
        {
            case SINGLE:
            {
                return Arrays.copyOfRange(bytes, 0, KeyLength.SINGLE.lengthInBytes());
            }
            case DOUBLE:
            {
                return Arrays.copyOfRange(bytes, 0, KeyLength.DOUBLE.lengthInBytes());
            }
            case TRIPLE:
            {
                return bytes;
            }
        }

        return null;
    }

    @Override
    public String toString()
    {
        return HexUtil.INSTANCE.toHexString(getBytes());
    }

    public HexKey getPartA()
    {
        return partA;
    }

    public HexKey getPartB()
    {
        return partB;
    }

    public HexKey getPartC()
    {
        return partC;
    }
}
