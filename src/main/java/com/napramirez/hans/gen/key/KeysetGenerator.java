package com.napramirez.hans.gen.key;

import com.napramirez.hans.crypto.AESEncryptor;
import com.napramirez.hans.crypto.DESKey;
import com.napramirez.hans.crypto.Encryptor;

/**
 * KeyGenerator
 * 
 * @author <a href="mailto:napramirez@gmail.com">Nap Ramirez</a>
 */
public class KeysetGenerator
{
    public static void main(String[] args) throws Exception
    {
        int KEY_TYPE_COUNT = 2;
        String[] keyTypes = new String[] { "Test", "Prod" };

        Encryptor encryptor = new AESEncryptor();

        String[] plainKEKs = new String[] { "00000000000000000000000000000000", "00000000000000000000000000000000" };
        String[] plainComponent1Keys = new String[] { "00000000000000000000000000000000", "00000000000000000000000000000000" };
        String[] plainComponent2Keys = new String[] { "00000000000000000000000000000000", "00000000000000000000000000000000" };
        String plainCheck = "00000000000000000000000000000000";

        String[] cipherComponent1Keys = new String[KEY_TYPE_COUNT];
        String[] cipherComponent2Keys = new String[KEY_TYPE_COUNT];

        String[] checkComponent1Keys = new String[KEY_TYPE_COUNT];
        String[] checkComponent2Keys = new String[KEY_TYPE_COUNT];

        String[] cipherCombinedComponentKeys = new String[KEY_TYPE_COUNT];
        String[] checkCombinedComponentKeys = new String[KEY_TYPE_COUNT];

        for (int i = 0; i < KEY_TYPE_COUNT; i++)
        {
            cipherComponent1Keys[i] = encryptor.encrypt(new DESKey(plainKEKs[i]), plainComponent1Keys[i]);
            cipherComponent2Keys[i] = encryptor.encrypt(new DESKey(plainKEKs[i]), plainComponent2Keys[i]);
            cipherCombinedComponentKeys[i] = encryptor.encrypt(new DESKey(cipherComponent1Keys[i]), cipherComponent2Keys[i]);

            checkComponent1Keys[i] = encryptor.encrypt(new DESKey(cipherComponent1Keys[i]), plainCheck);
            checkComponent2Keys[i] = encryptor.encrypt(new DESKey(cipherComponent2Keys[i]), plainCheck);
            checkCombinedComponentKeys[i] = encryptor.encrypt(new DESKey(cipherCombinedComponentKeys[i]), plainCheck);

            System.out.println("Key Type: " + keyTypes[i]);
            System.out.println("Part 1: " + cipherComponent1Keys[i].toLowerCase() + ", Check: " + checkComponent1Keys[i].toLowerCase().subSequence(0, 6));
            System.out.println("Part 2: " + cipherComponent2Keys[i].toLowerCase() + ", Check: " + checkComponent2Keys[i].toLowerCase().subSequence(0, 6));
            System.out.println("Combined Check Value: " + checkCombinedComponentKeys[i].toLowerCase().subSequence(0, 6));
            System.out.println();
        }
    }
}
