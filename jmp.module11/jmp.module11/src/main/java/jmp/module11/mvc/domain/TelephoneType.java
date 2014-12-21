package jmp.module11.mvc.domain;

import org.codehaus.jackson.annotate.JsonValue;

public enum TelephoneType {

    WORK("WORK"),
    HOME("HOME"),
    MOBILE("MOBILE"),
    VO_IP("VoIP");
    private final String value;

    TelephoneType(String v) {
        value = v;
    }

    @JsonValue
    public String value() {
        return fromValue(this.value).name();
    }

    @org.codehaus.jackson.annotate.JsonCreator
    public static TelephoneType fromValue(String v) {
        for (TelephoneType c: TelephoneType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
