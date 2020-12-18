package org;

import org.encrypt.EncryptNonAlphabeticWithAscii;
import org.encrypt.EncryptWithCombinedLetters;
import org.encrypt.EncryptWithCustomAlphabet;
import org.encrypt.EncryptWithNumber;
import org.encrypt.EncryptWithOffset;

public class EncryptBuilder {

    private String msg;

    public EncryptBuilder(String msg) {
        this.msg = msg;
    }

    public static EncryptBuilder withMsg(String msg) {
        return new EncryptBuilder(msg.toUpperCase());
    }

    public EncryptBuilder withSplitters(String letter, String word) {
        StringBuilder stringBuilder = new StringBuilder();
        this.msg.chars()
                .forEach(it -> {
                    stringBuilder.append(Character.toString(it));
                    if (Character.isAlphabetic(it)) stringBuilder.append(letter);
                });
        this.msg = stringBuilder.toString()
                                .replace(" ", word)
                                .replace(letter + word + letter, word);
        return this;
    }

    public EncryptBuilder withOffset(int offset) {
        EncryptWithOffset encrypt = new EncryptWithOffset(offset);
        return process(encrypt);
    }

    public EncryptBuilder withNumber(int val) {
        EncryptWithNumber encrypt = new EncryptWithNumber(val);
        return process(encrypt);
    }

    public EncryptBuilder nonAlphabeticWithAscii() {
        EncryptNonAlphabeticWithAscii encrypt = new EncryptNonAlphabeticWithAscii();
        return process(encrypt);
    }

    public EncryptBuilder withCustomAlphabetic(String alphas) {
        EncryptWithCustomAlphabet encrypt = new EncryptWithCustomAlphabet(alphas);
        return process(encrypt);
    }

    public EncryptBuilder withCombinedLetters() {
        EncryptWithCombinedLetters encrypt = new EncryptWithCombinedLetters();
        return process(encrypt);
    }

    public String build() {
        return this.msg;
    }

    private EncryptBuilder process(Encrypt encrypt) {
        encrypt.initAlphabet();
        this.msg = encrypt.apply(this.msg);
        return this;
    }

}
