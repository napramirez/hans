package com.napramirez.hans.magstripe;

/**
 * Track2
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class Track2
{
    public static final int MAX_LENGTH = 40;

    public static final int LENGTH_EXPIRY_DATE = 4;

    public static final int LENGTH_SERVICE_CODE = 3;

    public static final String STX = ";";

    public static final String FS = "=";

    public static final String ETX = "?";

    public static final String ESC = "\\";

    public static final String REGEX_FS = ESC + FS;

    public static final String REGEX_PAN = "[0-9]{1,19}";

    public static final String REGEX_EXPIRY = "([0-9]{4}" + "|" + REGEX_FS + ")";

    public static final String REGEX_SERVICE_CODE = "([0-9]{3}" + "|" + REGEX_FS + ")";

    public static final String REGEX_DISCRETIONARY_DATA = "[0-9]*";

    public static final String REGEX_LRC = ".?";

    public static final String REGEX = "^" + ESC + STX + REGEX_PAN + REGEX_FS + REGEX_EXPIRY + REGEX_SERVICE_CODE + REGEX_DISCRETIONARY_DATA + ESC + ETX
            + REGEX_LRC + "$";

    /**
     * 1-19 digits
     */
    private String pan;

    /**
     * 4 digits YYMM, nullable
     */
    private String expirationDate;

    /**
     * 3 digits, nullable
     */
    private String serviceCode;

    /**
     * balance of available digits, nullable
     */
    private String discretionaryData;

    /**
     * 1 character, nullable
     */
    private String lrc;

    public Track2()
    {
    }

    public Track2(String track2String)
    {
        if (track2String == null)
        {
            throw new NullPointerException("Track2 string cannot be null!");
        }

        if (track2String.length() > MAX_LENGTH)
        {
            throw new IllegalArgumentException("Track2 string cannot exceed length of " + MAX_LENGTH + "!");
        }

        if (!track2String.matches(REGEX))
        {
            throw new IllegalArgumentException("Invalid Track2 format for: " + REGEX);
        }

        StringBuilder sb = new StringBuilder(track2String);

        sb.deleteCharAt(0); // delete STX

        int indexOfPanFS = sb.indexOf(FS);
        pan = sb.substring(0, indexOfPanFS);
        sb.delete(0, indexOfPanFS + 1); // consume token and delimiter

        if (!FS.equals(String.valueOf(sb.charAt(0))))
        {
            expirationDate = sb.substring(0, LENGTH_EXPIRY_DATE);
            sb.delete(0, LENGTH_EXPIRY_DATE);
        }
        else
        {
            sb.deleteCharAt(0);
        }

        if (!FS.equals(String.valueOf(sb.charAt(0))))
        {
            serviceCode = sb.substring(0, LENGTH_SERVICE_CODE);
            sb.delete(0, LENGTH_SERVICE_CODE);
        }
        else
        {
            sb.deleteCharAt(0);
        }

        int indexOfETX = sb.indexOf(ETX);
        discretionaryData = sb.substring(0, indexOfETX);
        sb.delete(0, indexOfETX + 1);

        if (sb.length() > 0)
        {
            lrc = sb.substring(0, 1);
        }
    }

    public String getPan()
    {
        return pan;
    }

    public void setPan(String pan)
    {
        if (pan == null)
        {
            throw new NullPointerException("PAN cannot be null!");
        }

        if (!pan.matches(REGEX_PAN))
        {
            throw new IllegalArgumentException("Invalid PAN format for: " + REGEX_PAN);
        }

        this.pan = pan;
    }

    public String getExpirationDate()
    {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate)
    {
        if (expirationDate != null && !expirationDate.matches(REGEX_EXPIRY))
        {
            throw new IllegalArgumentException("Invalid Expiration Date format for: " + REGEX_EXPIRY);
        }

        if (expirationDate.equals(FS))
        {
            throw new IllegalArgumentException("Invalid Expiration Date value: " + expirationDate);
        }

        this.expirationDate = expirationDate;
    }

    public String getServiceCode()
    {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode)
    {
        if (serviceCode != null && !serviceCode.matches(REGEX_SERVICE_CODE))
        {
            throw new IllegalArgumentException("Invalid Service Code format for: " + REGEX_SERVICE_CODE);
        }

        if (serviceCode.equals(FS))
        {
            throw new IllegalArgumentException("Invalid Service Code value: " + serviceCode);
        }

        this.serviceCode = serviceCode;
    }

    public String getDiscretionaryData()
    {
        return discretionaryData;
    }

    public void setDiscretionaryData(String discretionaryData)
    {
        if (discretionaryData != null && !discretionaryData.matches(REGEX_DISCRETIONARY_DATA))
        {
            throw new IllegalArgumentException("Invalid Discretionary Data format for: " + REGEX_DISCRETIONARY_DATA);
        }

        this.discretionaryData = discretionaryData;
    }

    public String getLrc()
    {
        return lrc;
    }

    public void setLrc(String lrc)
    {
        if (lrc != null && !lrc.matches(REGEX_LRC))
        {
            throw new IllegalArgumentException("Invalid LRC format for: " + REGEX_LRC);
        }

        this.lrc = lrc;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(STX);

        if (pan == null)
        {
            throw new NullPointerException("PAN cannot be null!");
        }
        sb.append(pan);
        sb.append(FS);

        sb.append(expirationDate != null && !expirationDate.trim().isEmpty() ? expirationDate : FS);
        sb.append(serviceCode != null && !serviceCode.trim().isEmpty() ? serviceCode : FS);

        if (discretionaryData != null)
        {
            sb.append(discretionaryData);
        }

        sb.append(ETX);

        if (lrc != null)
        {
            sb.append(lrc);
        }

        if (sb.length() > MAX_LENGTH)
        {
            throw new StringIndexOutOfBoundsException(sb.length());
        }

        return sb.toString();
    }
}
