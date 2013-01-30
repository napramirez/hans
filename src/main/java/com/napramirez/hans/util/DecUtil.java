package com.napramirez.hans.util;

/**
 * DecUtil
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public enum DecUtil
{
    INSTANCE;

    public String decimalizeFromHex(String hexString)
    {
        StringBuilder sb = new StringBuilder();

        for (char c : hexString.toCharArray())
        {
            sb.append(HexUtil.INSTANCE.toInt(c) % 10);
        }

        return sb.toString();
    }
}
