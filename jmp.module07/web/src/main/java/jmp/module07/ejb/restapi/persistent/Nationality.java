package jmp.module07.ejb.restapi.persistent;

import org.codehaus.jackson.annotate.JsonValue;

public enum Nationality  {

    BE("BE"),
    RU("RU"),
    BG("BG"),
    ZH("ZH"),
    EN("EN"),
    US("US");
    
    private final String value;

    private Nationality(String v) {
        value = v;
    }

    @JsonValue
    public String value() {
        return value;
    }

    public static Nationality fromValue(String v) {
        for (Nationality c: Nationality.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
