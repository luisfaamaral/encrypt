package org.encrypt;

import org.EncryptBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptWithNumberTest {

    @Test
    void toNumber() {
        String msg = "A";
        String result = EncryptBuilder.withMsg(msg)
                                      .withNumber(3)
                                      .build();
        assertThat(result).isEqualTo("000");
    }

    @Test
    void toNumber_long() {
        String msg = "Ab cd";
        String result = EncryptBuilder.withMsg(msg)
                                      .withNumber(2)
                                      .build();
        assertThat(result).isEqualTo("0001 0203");
    }

    @Test
    void toNumber_long2() {
        String msg = "A Z";
        String result = EncryptBuilder.withMsg(msg)
                                      .withNumber(2)
                                      .build();
        assertThat(result).isEqualTo("00 25");
    }

}
