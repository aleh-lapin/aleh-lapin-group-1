
package jmp.module14.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "memeber")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Member {

	@XmlTransient
	private static long sequence = 0L;
	
	@XmlTransient
	private final long id = ++sequence;
	
	private Long identity = id;

    private String name;

    private String email;

    private String phoneNumber;
    
    private Double ballance;
    
    private Long orderCount;

    public Long getIdentity() {
        return identity;
    }

    public void setIdentity(Long identity) {
        this.identity = identity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber =
        		phoneNumber;
    }

	public Double getBallance() {
		return ballance;
	}

	public void setBallance(Double ballance) {
		this.ballance = ballance;
	}

	public Long getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(Long orderCount) {
		this.orderCount = orderCount;
	}
    
}
