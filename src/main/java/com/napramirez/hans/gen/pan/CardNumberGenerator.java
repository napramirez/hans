package com.napramirez.hans.gen.pan;

import com.napramirez.hans.gen.GenerationException;

/**
 * CardNumberGenerator
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public interface CardNumberGenerator
{
    String generate(int length) throws GenerationException;

    String generate(String prefix, int length) throws GenerationException;
}
