package com.napramirez.hans.gen.cvv;

import com.napramirez.hans.crypto.HexKey;
import com.napramirez.hans.gen.GenerationException;

/**
 * CVVGenerator
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public interface CVVGenerator
{
    String generate(HexKey hexKey1, HexKey hexKey2, String pan, String expiryDate, String serviceCode) throws GenerationException;
}
