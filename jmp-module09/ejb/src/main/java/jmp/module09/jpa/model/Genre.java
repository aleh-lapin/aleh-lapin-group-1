package jmp.module09.jpa.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum Genre {

    W,
    M,
    U;

    @JsonValue
    public String value() {
        return name();
    }

    public static Genre fromValue(String v) {
        return valueOf(v);
    }

}
