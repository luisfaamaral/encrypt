package org.encrypt;

import org.EncryptBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptWithCustomAlphabetEncryptTest {

    @Test
    void toAsciiNonAlphabetic() {
        String msg = "EF NOP";
        String result = EncryptBuilder.withMsg(msg)
                                      .withCustomAlphabetic("SUPERJACKPOT")
                                      .build();
        assertThat(result).isEqualTo("RJ DFG");
    }


}
