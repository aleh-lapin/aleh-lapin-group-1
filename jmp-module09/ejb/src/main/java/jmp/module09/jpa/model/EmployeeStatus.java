package jmp.module09.jpa.model;

import org.codehaus.jackson.annotate.JsonValue;

public enum EmployeeStatus {
	
	BILLABLE, FULL_TIME, PART_TIME, STUDENT;
	
	@JsonValue
    public String value() {
        return name();
    }

    public static EmployeeStatus fromValue(String v) {
        return valueOf(v);
    }

}
