package jmp.module07.ejb.restapi.persistent;

import org.codehaus.jackson.annotate.JsonValue;

public enum TelephoneType {

    WORK("WORK"),
    HOME("HOME"),
    MOBILE("MOBILE"),
    VO_IP("VO_IP");
    private final String value;

    TelephoneType(String v) {
        value = v;
    }

    @JsonValue
    public String value() {
        return value;
    }

    public static TelephoneType fromValue(String v) {
        for (TelephoneType c: TelephoneType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
