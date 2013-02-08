package com.napramirez.hans.gen.pin;

import com.napramirez.hans.crypto.HexKey;
import com.napramirez.hans.gen.GenerationException;

/**
 * PINGenerator
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public interface PINGenerator
{
    String generate(HexKey key, String pan) throws GenerationException;

    String generate(HexKey key, String pan, int length) throws GenerationException;
}
