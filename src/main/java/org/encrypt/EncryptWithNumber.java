package org.encrypt;

import java.util.stream.IntStream;

import org.Config;
import org.Encrypt;

public class EncryptWithNumber implements Encrypt {

    private final String[] alphabet = new String[130];
    private final int formatter;

    public EncryptWithNumber(int formatter) {
        this.formatter = formatter;
    }

    public void initAlphabet() {
        IntStream.rangeClosed(Config.START_ALPHABET_LETTER, Config.END_ALPHABET_LETTER)
                 .forEach(it -> this.alphabet[it] = transform(it));
    }

    private String transform(int val) {
        return String.format("%0"+formatter+"d", val-65);
    }

    @Override
    public String[] getAlphabet() {
        return this.alphabet;
    }

}