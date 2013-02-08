package com.napramirez.hans.util;

import com.napramirez.hans.crypto.DESKey;
import com.napramirez.hans.crypto.HexKey;

/**
 * HexKeyUtil
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public enum HexKeyUtil
{
    INSTANCE;

    public HexKey add(HexKey key1, HexKey key2)
    {
        if (key1 == null)
        {
            throw new IllegalArgumentException("Key1 cannot be null!");
        }

        if (key2 == null)
        {
            throw new IllegalArgumentException("Key2 cannot be null!");
        }

        String keyString1 = key1.toString();
        String keyString2 = key2.toString();

        if (key1.getKeyLength().lengthInHexDigits() < key2.getKeyLength().lengthInHexDigits())
        {
            keyString1 = StringPaddingUtil.INSTANCE.padRight(keyString1, '0', keyString2.length());
        }

        return new DESKey(HexUtil.INSTANCE.addMod16(keyString1, keyString2));
    }
}
