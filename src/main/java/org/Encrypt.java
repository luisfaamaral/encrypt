package org;

import java.util.stream.Collectors;

public interface Encrypt {

    default String apply(String msg) {
        return msg.chars()
                  .mapToObj(it -> getAlphabet()[it] == null ? Character.toString(it) : getAlphabet()[it])
                  .collect(Collectors.joining());
    }

    String[] getAlphabet();
    void initAlphabet();

}
