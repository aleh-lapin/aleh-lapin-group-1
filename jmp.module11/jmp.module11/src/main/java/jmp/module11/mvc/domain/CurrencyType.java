package jmp.module11.mvc.domain;

import org.codehaus.jackson.annotate.JsonValue;

public enum CurrencyType {

    US,
    EU,
    RU,
    UK;

    @JsonValue
    public String value() {
        return name();
    }

    @org.codehaus.jackson.annotate.JsonCreator
    public static CurrencyType fromValue(String v) {
        return valueOf(v);
    }

}
