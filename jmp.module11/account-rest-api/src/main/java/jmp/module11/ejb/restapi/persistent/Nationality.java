package jmp.module11.ejb.restapi.persistent;

import org.codehaus.jackson.annotate.JsonValue;

public enum Nationality  {

    BE("be"),
    RU("ru"),
    BG("bg"),
    ZH("zh"),
    EN("en"),
    US("us");
    
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
