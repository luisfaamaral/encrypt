package org.encrypt;

import org.EncryptBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EncryptWithOffsetTest {

    @Test
    void toOffset_plus1() {
        String msg = "Z";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(1)
                                      .build();
        assertThat(result).isEqualTo("A");
    }

    @Test
    void toOffset_minus1() {
        String msg = "A";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(-1)
                                      .build();
        assertThat(result).isEqualTo("Z");
    }

    @Test
    void toOffset_long() {
        String msg = "ABC DEF GHI";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(2)
                                      .build();
        assertThat(result).isEqualTo("CDE FGH IJK");
    }

}
