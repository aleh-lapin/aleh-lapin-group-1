package jmp.module09.jpa.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum UnitType {
	
	QUALITY_ASSURANCE, DEVEPOPING_TEAM, HELP_DESK_TEAM, SERVICE_TEAM;
	
	@JsonValue
    public String value() {
        return name();
    }

    public static UnitType fromValue(String v) {
        return valueOf(v);
    }

}
