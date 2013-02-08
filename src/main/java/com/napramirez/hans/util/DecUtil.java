package com.napramirez.hans.util;

/**
 * DecUtil
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public enum DecUtil
{
    INSTANCE;

    private static final String cMap = "0123456789";

    public String decimalizeFromHex(String hexString)
    {
        StringBuilder sb = new StringBuilder();

        for (char c : hexString.toCharArray())
        {
            sb.append(HexUtil.INSTANCE.toInt(c) % 10);
        }

        return sb.toString();
    }

    public int toInt(char c)
    {
        String cString = String.valueOf(c);

        if (!cMap.contains(cString))
        {
            throw new IllegalArgumentException("Invalid decimal character '" + c + "'");
        }

        return cMap.indexOf(cString);
    }

    public String subtractMod10(String minuend, String subtrahend)
    {
        if (minuend == null || minuend.length() == 0)
        {
            throw new IllegalArgumentException("Minuend cannot be empty!");
        }

        if (subtrahend == null || subtrahend.length() == 0)
        {
            throw new IllegalArgumentException("Subtrahend cannot be empty!");
        }

        if (minuend.length() != subtrahend.length())
        {
            throw new IllegalArgumentException("Input strings must be of the same length!");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < minuend.length(); i++)
        {
            int minuendMod10 = toInt(minuend.charAt(i)) + 10;
            int subtrahendMod10 = toInt(subtrahend.charAt(i));
            sb.append((minuendMod10 - subtrahendMod10) % 10);
        }

        return sb.toString();
    }
}
