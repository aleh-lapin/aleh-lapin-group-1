package jmp.module07.ejb.restapi.persistent;

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

    public static CurrencyType fromValue(String v) {
        return valueOf(v);
    }

}
