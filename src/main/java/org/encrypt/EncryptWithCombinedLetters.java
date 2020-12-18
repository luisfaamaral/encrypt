package org.encrypt;

import java.util.Random;
import java.util.stream.IntStream;

import org.Config;
import org.Encrypt;

public class EncryptWithCombinedLetters implements Encrypt {

    private final String[] alphabet = new String[130];

    public void initAlphabet() {
        IntStream.rangeClosed(Config.START_ALPHABET_LETTER, Config.END_ALPHABET_LETTER)
                 .forEach(it -> this.alphabet[it] = transform(it));
    }

    private String transform(int val) {
        int first = new Random().nextInt(Config.END_ALPHABET_LETTER - Config.START_ALPHABET_LETTER + 1) + Config.START_ALPHABET_LETTER;
        int second = 0;
        if (first > val) {
            second = val - first + Config.END_ALPHABET_LETTER;
        } else {
            second = val - first + Config.START_ALPHABET_LETTER;
        }
        return String.format("%s%s", Character.toString(first), Character.toString(second));
    }

    @Override
    public String[] getAlphabet() {
        return this.alphabet;
    }

}
