package org.encrypt;

import org.EncryptBuilder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MixEncryptTest {

    @Test
    public void mix1() {
        String msg = "AB CD EF";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(1)
                                      .withNumber(2)
                                      .build();
        assertThat(result).isEqualTo("0102 0304 0506");
    }

    @Test
    public void mix2() {
        String msg = "AB CD EF";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(1)
                                      .nonAlphabeticWithAscii()
                                      .build();
        assertThat(result).isEqualTo("BC32DE32FG");
    }


    @Test
        // TWO is the key
    void void_mix_L1() {
        String msg = "This is the level number one. Can you solve it?";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(2)
                                      .build();
        System.out.println(msg);
        System.out.println(result);
        assertThat(result).isNotEmpty();
    }


    @Test
        // scrambled three in a row
    void void_mix_L2() {
        String msg = "Here comes the puzzle level 2. This is a little bit harder, dont you think?";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(-1)
                                      .withNumber(3)
                                      .build();
        System.out.println(msg);
        System.out.println(result);
        assertThat(result).isNotEmpty();
    }

    @Test
        // together we are better than alone
    void void_mix_L3() {
        String msg = "If you solve this puzzle, you can consider yourself a code cracker!";
        String result = EncryptBuilder.withMsg(msg)
                                      .withSplitters("-", " ")
                                      .withCombinedLetters()
                                      .build();
        System.out.println(msg);
        System.out.println(result);
        assertThat(result).isNotEmpty();
    }

    @Test
        // play like a spider
        // TODO:: Manually put text in vertical
    void void_mix_L4() {
        String msg = "Congratulations. Sometimes a line is not always a line.";
        String result = EncryptBuilder.withMsg(msg)
                                      .withOffset(2)
                                      .build();
        System.out.println(msg);
        System.out.println(result);
        assertThat(result).isNotEmpty();
    }

    @Test
        // the "PLAYWITHFUN" alphabet
    void void_mix_L5() {
        String msg = "In this one you play with a custom alphabet. This is super fun and complex. Can you tell me what is the smallest city in the world?";
        String result = EncryptBuilder.withMsg(msg)
                                      .withCustomAlphabetic("PLAYWITHFUN")
                                      .build();
        System.out.println(msg);
        System.out.println(result);
        assertThat(result).isNotEmpty();
    }

    @Test
    // the spider "SUPERJACKPOT" alphabet
    public void mix_L6() {
        String msg = "Goed zo. Gefeliciteerd! You cracked it. Now, can you tell me what is the LCM of nine, twelve and eighteen?";
        String result = EncryptBuilder.withMsg(msg)
                                      .withCustomAlphabetic("SUPERJACKPOT")
                                      .nonAlphabeticWithAscii()
                                      .build();
        System.out.println(msg);
        System.out.println(result);
        assertThat(result).isNotEmpty();
    }

}
