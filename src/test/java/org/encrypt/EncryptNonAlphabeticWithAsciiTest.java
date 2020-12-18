package org.encrypt;

import org.EncryptBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptNonAlphabeticWithAsciiTest {

    @Test
    void toAsciiNonAlphabetic() {
        String msg = ". ,";
        String result = EncryptBuilder.withMsg(msg)
                                      .nonAlphabeticWithAscii()
                                      .build();
        assertThat(result).isEqualTo("463244");
    }


}
