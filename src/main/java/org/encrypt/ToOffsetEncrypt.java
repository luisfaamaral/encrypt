package org.encrypt;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import org.Config;
import org.Encrypt;

public class ToOffsetEncrypt implements Encrypt {

    public final Map<String, String> map = new HashMap<>();

    public void initAlphabet(int offset) {
        IntStream.rangeClosed(Config.START_ALPHABET_LETTER, Config.END_ALPHABET_LETTER)
                 .forEach(it -> this.map.put(Character.toString(it), transform(it, offset)));
    }

    private String transform(int val, int offset) {
        val += offset;
        if (val > 90) val = 64 + (val % 90);
        if (val < 65) val = 64 + (90 % val);
        return Character.toString(val);

    }

    @Override
    public Map<String, String> getMap() {
        return this.map;
    }

}