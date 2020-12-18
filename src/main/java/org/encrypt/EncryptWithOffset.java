package org.encrypt;

import java.util.stream.IntStream;

import org.Config;
import org.Encrypt;

public class EncryptWithOffset implements Encrypt {

    private final String[] alphabet = new String[130];
    private final int offset;

    public EncryptWithOffset(int offset) {
        this.offset = offset;
    }

    public void initAlphabet() {
        IntStream.rangeClosed(Config.START_ALPHABET_LETTER, Config.END_ALPHABET_LETTER)
                 .forEach(it -> alphabet[it] = transform(it, offset));
    }

    private String transform(int val, int offset) {
        val += offset;
        if (val > 90) val = 64 + (val % 90);
        if (val < 65) val = 64 + (90 % val);
        return Character.toString(val);

    }

    @Override
    public String[] getAlphabet() {
        return this.alphabet;
    }

}