package org.encrypt;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.Config;
import org.Encrypt;

public class ToNumberEncrypt implements Encrypt {

    public final Map<String, String> map = new HashMap<>();

    public void initAlphabet() {
        IntStream.rangeClosed(Config.START_ALPHABET_LETTER, Config.END_ALPHABET_LETTER)
                 .forEach(it -> this.map.put(Character.toString(it), transform(it)));
    }

    private String transform(int val) {
        return String.format("%02d", val-65);
    }

    @Override
    public Map<String, String> getMap() {
        return this.map;
    }

}