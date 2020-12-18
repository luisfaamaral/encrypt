package org.encrypt;

import org.Config;
import org.EncryptBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptWithCombinedLettersTest {

    @Test
    void withCombinedLetters() {
        String msg = "C";
        String result = EncryptBuilder.withMsg(msg)
                                      .withCombinedLetters()
                                      .build();
        int sum = result.chars()
                        .reduce(Integer::sum)
                        .orElse(0);
        assertThat(Character.toString(sum - Config.END_ALPHABET_LETTER)).isEqualTo(msg);
    }

}
