package org.encrypt;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.Config;
import org.Encrypt;

public class EncryptNonAlphabeticWithAscii implements Encrypt {

    private final String[] alphabet = new String[130];

    @Override
    public void initAlphabet() {
        IntStream.range(32, Config.START_ALPHABET_LETTER)
                 .forEach(it -> this.alphabet[it] = transform(it));
    }

    private String transform(int val) {
        return String.valueOf(val);
    }

    @Override
    public String[] getAlphabet() {
        return this.alphabet;
    }

}
