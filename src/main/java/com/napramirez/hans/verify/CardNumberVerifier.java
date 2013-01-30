package com.napramirez.hans.verify;

/**
 * CardNumberVerifier
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public interface CardNumberVerifier
{
    void verify(String cardNumber) throws VerificationException;
}
