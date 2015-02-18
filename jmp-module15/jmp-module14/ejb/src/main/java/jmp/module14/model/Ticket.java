package jmp.module14.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(name = "ticket")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Ticket {
	
	@XmlTransient
	private static long uuid = 0L;
	
	@XmlTransient
	private final long id = ++uuid;
	
	private Long identity = id;
	
	private String seat;
	
	private Integer amount;
	
	private Double price;
	
	private String description;

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	public Long getIdentity() {
		return identity;
	}

	@XmlAttribute
	public void setIdentity(Long identity) {
		this.identity = identity;
	}
		
	
}
