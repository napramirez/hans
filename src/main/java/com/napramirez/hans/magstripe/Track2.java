package com.napramirez.hans.magstripe;

/**
 * Track2
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class Track2
{
    public static final int MAX_LENGTH = 40;

    public static final String STX = ";";

    public static final String FS = "=";

    public static final String ETX = "?";

    public static final String ESC = "\\";

    public static final String REGEX_PAN = "[0-9]{0,19}";

    public static final String REGEX_EXPIRY = "([0-9]{4}" + "|" + ESC + FS + ")";

    public static final String REGEX_SERVICE_CODE = "([0-9]{3}" + "|" + ESC + FS + ")";

    public static final String REGEX_DISCRETIONARY_DATA = "[0-9]{0,34}";

    public static final String REGEX_LRC = ".";

    public static final String REGEX = "^" + ESC + STX + REGEX_PAN + ESC + FS + REGEX_EXPIRY + REGEX_SERVICE_CODE + REGEX_DISCRETIONARY_DATA + ESC + ETX
            + REGEX_LRC + "$";

    /**
     * 0-19 digits
     */
    private String pan;

    /**
     * 4 digits YYMM
     */
    private String expirationDate;

    /**
     * 3 digits
     */
    private String serviceCode;

    /**
     * balance of available digits
     */
    private String discretionaryData;

    /**
     * 1 character
     */
    private String lrc;

    public Track2()
    {
    }

    public Track2(String track2String)
    {
        if (track2String == null || track2String.trim().isEmpty())
        {
            throw new IllegalArgumentException("Track2 string cannot be null or empty!");
        }

        if (track2String.length() > MAX_LENGTH)
        {
            throw new IllegalArgumentException("Track2 string cannot exceed length of " + MAX_LENGTH + "!");
        }

        if (!track2String.matches(REGEX))
        {
            throw new IllegalArgumentException("Invalid track2 string!");
        }

        StringBuilder sb = new StringBuilder(track2String);

        sb.deleteCharAt(0); // delete STX

        if (!FS.equals(String.valueOf(sb.charAt(0)))) // check if pan exists
        {
            int indexOfFS = sb.indexOf(FS);
            pan = sb.substring(0, indexOfFS);
            sb.delete(0, indexOfFS + 1); // consume token and delimiter
        }
        else
        {
            sb.deleteCharAt(0);
        }

        int expirationDateLength = 4;
        if (!FS.equals(String.valueOf(sb.charAt(0))))
        {
            expirationDate = sb.substring(0, expirationDateLength);
            sb.delete(0, expirationDateLength);
        }
        else
        {
            sb.deleteCharAt(0);
        }

        int serviceCodeLength = 3;
        if (!FS.equals(String.valueOf(sb.charAt(0))))
        {
            serviceCode = sb.substring(0, serviceCodeLength);
            sb.delete(0, serviceCodeLength);
        }
        else
        {
            sb.deleteCharAt(0);
        }

        int indexOfETX = sb.indexOf(ETX);
        discretionaryData = sb.substring(0, indexOfETX);
        sb.delete(0, indexOfETX + 1);

        lrc = sb.substring(0, 1);
    }

    public String getPan()
    {
        return pan;
    }

    public void setPan(String pan)
    {
        this.pan = pan;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate)
    {
        this.expirationDate = expirationDate;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode)
    {
        this.serviceCode = serviceCode;
    }

    public String getDiscretionaryData()
    {
        return discretionaryData;
    }

    public void setDiscretionaryData(String discretionaryData)
    {
        this.discretionaryData = discretionaryData;
    }

    public String getLrc()
    {
        return lrc;
    }

    public void setLrc(String lrc)
    {
        this.lrc = lrc;
    }

    public static int getMaxLength()
    {
        return MAX_LENGTH;
    }

    public static String getStx()
    {
        return STX;
    }

    public static String getFs()
    {
        return FS;
    }

    public static String getEtx()
    {
        return ETX;
    }

    private String computeLRC()
    {
        return "*";
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(STX);

        if (pan != null && !pan.trim().isEmpty())
        {
            sb.append(pan);
        }
        sb.append(FS);

        sb.append(expirationDate != null && !expirationDate.trim().isEmpty() ? expirationDate : FS);
        sb.append(serviceCode != null && !serviceCode.trim().isEmpty() ? serviceCode : FS);

        sb.append(ETX);
        sb.append(computeLRC());

        return sb.toString();
    }
}
