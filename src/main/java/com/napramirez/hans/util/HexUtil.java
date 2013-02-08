package com.napramirez.hans.util;

/**
 * HexUtil
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public enum HexUtil
{
    INSTANCE;

    private static final String cMap = "0123456789ABCDEF";

    /**
     * Implementation from <a href=
     * "http://stackoverflow.com/questions/9840675/xor-hex-string-in-java-of-different-length"
     * >Stack Overflow</a> with modifications.
     * 
     * @author <a href="http://stackoverflow.com/users/22656/jon-skeet">Jon
     *         Skeet</a>
     * @param a
     * @param b
     */
    public String xor(String a, String b)
    {
        if (a == null || a.length() == 0)
        {
            throw new IllegalArgumentException("Hex string '" + a + "' cannot be empty!");
        }

        if (b == null || b.length() == 0)
        {
            throw new IllegalArgumentException("Hex string '" + b + "' cannot be empty!");
        }

        if (a.length() != b.length())
        {
            throw new IllegalArgumentException("Input strings must be of the same length!");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length(); i++)
        {
            sb.append(toHexDigit(toInt(a.charAt(i)) ^ toInt(b.charAt(i))));
        }

        return sb.toString();
    }

    public String addMod16(String a, String b)
    {
        if (a == null || a.length() == 0)
        {
            throw new IllegalArgumentException("Hex string '" + a + "' cannot be empty!");
        }

        if (b == null || b.length() == 0)
        {
            throw new IllegalArgumentException("Hex string '" + b + "' cannot be empty!");
        }

        if (a.length() != b.length())
        {
            throw new IllegalArgumentException("Input strings must be of the same length!");
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < a.length(); i++)
        {
            int intA = toInt(a.charAt(i));
            int intB = toInt(b.charAt(i));
            int result = (intA + intB) % 16;
            sb.append(toHexDigit(result));
        }

        return sb.toString();
    }

    public int toInt(char c)
    {
        String cString = String.valueOf(c).toUpperCase();

        if (!cMap.contains(cString))
        {
            throw new IllegalArgumentException("Invalid hex character '" + c + "'");
        }

        return cMap.indexOf(cString);
    }

    /**
     * Implementation from <a href=
     * "http://stackoverflow.com/questions/9840675/xor-hex-string-in-java-of-different-length"
     * >Stack Overflow</a> with modifications.
     * 
     * @author <a href="http://stackoverflow.com/users/22656/jon-skeet">Jon
     *         Skeet</a>
     * @param a
     * @param b
     */
    public char toHexDigit(int i)
    {
        if (i < 0 || i > 15)
        {
            throw new IllegalArgumentException("Invalid hex digit '" + i + "'");
        }

        return cMap.charAt(i);
    }

    /**
     * @author Herong Yang
     * @see <a
     *      href="http://www.herongyang.com/Cryptography/DES-JDK-Testing-PKCS5Padding.html">HerongYang.com</a>
     * @param hexString
     * @return byte[] value of the hex string
     */
    public byte[] toBytes(String hexString)
    {
        if (hexString == null || hexString.trim().length() == 0)
        {
            throw new IllegalArgumentException("Hex string cannot be empty!");
        }

        if (hexString.length() % 2 != 0)
        {
            throw new IllegalArgumentException("Invalid string length: " + hexString.length() + ".  Length must be a multiple of 2.");
        }

        int lengthInBytes = hexString.length() / 2;
        byte[] bytes = new byte[lengthInBytes];

        for (int i = 0; i < lengthInBytes; i++)
        {
            String hexNumber = hexString.substring(i * 2, i * 2 + 2);
            try
            {
                bytes[i] = (byte) Integer.parseInt(hexNumber, 16);
            }
            catch (NumberFormatException e)
            {
                throw new IllegalArgumentException("Invalid hex number format: " + hexNumber, e);
            }
        }

        return bytes;
    }

    public String toHexString(byte[] data)
    {
        if (data == null)
        {
            throw new IllegalArgumentException("Input data cannot be null!");
        }

        char[] hexChars = new char[data.length * 2];

        for (int i = 0; i < data.length; i++)
        {
            hexChars[i * 2] = cMap.charAt((data[i] >>> 4) & 0x0F);
            hexChars[(i * 2) + 1] = cMap.charAt(data[i] & 0x0F);
        }

        return String.valueOf(hexChars);
    }

    /**
     * @author aco
     * @param padawan
     * @return Hex string representation of the input byte[]
     * @deprecated
     * @see String toHexString(byte[] data)
     */
    @SuppressWarnings("unused")
    private String toJediMaster(byte[] padawan)
    {
        if (padawan == null)
        {
            throw new IllegalArgumentException("This is not the droids you are looking for...");
        }

        final String[] theForce = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };

        StringBuilder jediMaster = new StringBuilder();
        for (byte training : padawan)
        {
            jediMaster.append(theForce[(training >> 4) & 0x0F]);
            jediMaster.append(theForce[training & 0x0F]);
        }

        return jediMaster.toString();
    }
}
