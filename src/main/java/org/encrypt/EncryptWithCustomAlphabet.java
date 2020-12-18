package org.encrypt;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

import org.Config;
import org.Encrypt;

public class EncryptWithCustomAlphabet implements Encrypt {

    private final String[] alphabet = new String[130];
    private final String alphas;

    public EncryptWithCustomAlphabet(String alphas) {
        this.alphas = alphas;
    }

    @Override
    public String[] getAlphabet() {
        return this.alphabet;
    }

    @Override
    public void initAlphabet() {
        initAlphas();
        completeAlphabet();
    }

    private void completeAlphabet() {
        AtomicInteger start = new AtomicInteger(Config.START_ALPHABET_LETTER + this.alphas.length());
        IntStream.rangeClosed(Config.START_ALPHABET_LETTER, Config.END_ALPHABET_LETTER)
                 .mapToObj(Character::toString)
                 .forEach(it -> {
                     if (!this.alphas.contains(it)) this.alphabet[start.getAndIncrement()] = it;
                 });
    }

    private void initAlphas() {
        AtomicInteger start = new AtomicInteger(Config.START_ALPHABET_LETTER);
        this.alphas.chars()
                .mapToObj(Character::toString)
                .forEach(it -> this.alphabet[start.getAndIncrement()] = it);
    }

}
