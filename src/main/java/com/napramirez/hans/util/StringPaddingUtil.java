package com.napramirez.hans.util;

/**
 * StringPaddingUtil
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public enum StringPaddingUtil
{
    INSTANCE;

    public String padLeft(String input, char padding, int totalStringLength)
    {
        return pad(input, padding, totalStringLength, true);
    }

    public String padRight(String input, char padding, int totalStringLength)
    {
        return pad(input, padding, totalStringLength, false);
    }

    public String padLeft(String input, String padding, int totalStringLength)
    {
        return pad(input, padding, totalStringLength, true);
    }

    public String padRight(String input, String padding, int totalStringLength)
    {
        return pad(input, padding, totalStringLength, false);
    }

    private String pad(String input, char padding, int totalStringLength, boolean leftPad)
    {
        return pad(input, String.valueOf(padding), totalStringLength, leftPad);
    }

    private String pad(String input, String padding, int totalStringLength, boolean leftPad)
    {
        if (input == null)
        {
            throw new IllegalArgumentException("Input string cannot be null!");
        }

        if (padding == null || padding.length() == 0)
        {
            throw new IllegalArgumentException("Padding string cannot be empty!");
        }

        if (totalStringLength < input.length())
        {
            throw new IllegalArgumentException("Input string (" + input.length() + ") cannot be longer than total string length (" + totalStringLength + ")!");
        }

        StringBuilder sb = new StringBuilder(input);

        for (int i = 0; sb.length() < totalStringLength; i++)
        {
            sb.insert(leftPad ? 0 : sb.length(), padding.charAt(leftPad ? (padding.length() - 1) - (i % padding.length()) : i % padding.length()));
        }

        return sb.toString();
    }
}
