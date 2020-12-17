package org;

import java.util.Map;
import java.util.stream.Collectors;

public interface Encrypt {

    default String apply(String msg) {
        return msg.chars()
                  .mapToObj(Character::toString)
                  .map(it -> getMap().getOrDefault(it, it))
                  .collect(Collectors.joining());
    }

    Map<String, String> getMap();

}
