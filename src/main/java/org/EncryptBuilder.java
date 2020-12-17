package org;

import org.encrypt.ToNumberEncrypt;
import org.encrypt.ToOffsetEncrypt;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EncryptBuilder {

    private String msg;

    public static EncryptBuilder withMsg(String msg) {
        return new EncryptBuilder(msg.toUpperCase());
    }

    public EncryptBuilder toOffset(int offset) {
        ToOffsetEncrypt encrypt = new ToOffsetEncrypt();
        encrypt.initAlphabet(offset);
        this.msg = encrypt.apply(this.msg);
        return this;
    }

    public EncryptBuilder toNumber() {
        ToNumberEncrypt encrypt = new ToNumberEncrypt();
        encrypt.initAlphabet();
        this.msg = encrypt.apply(this.msg);
        return this;
    }

    public String build() {
        return this.msg;
    }

}
