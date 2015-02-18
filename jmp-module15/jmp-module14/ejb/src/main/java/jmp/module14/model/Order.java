package jmp.module14.model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement
@XmlType(name = "order")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Order {
	
	@XmlType(name = "status")
	@XmlEnum
	public enum OrderStatus {
		@XmlEnumValue("ORDER_ACCEPTED")
		ACCEPTED,
		@XmlEnumValue("ORDER_PROCCESSED")
		PROCCESSED,
		@XmlEnumValue("ORDER_REJECTED")
		REJECTED;
	}
	
	@XmlTransient
	private static long sequence = 0L;
	
	@XmlTransient
	private final long id = ++sequence;
	
	private Long identity = id;
	
	private Double amount;
	
	private Date orderDate;
	
	private OrderStatus status;
	
	
	private Map<Class<?>, List<Long>> units = new HashMap<Class<?>, List<Long>>();
	
	public Order() {
		
	}

	public Long getIdentity() {
		return identity;
	}

	@XmlAttribute
	public void setIdentity(Long identity) {
		this.identity = identity;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@XmlJavaTypeAdapter(XmlDateAdapter.class)
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@XmlJavaTypeAdapter(XmlMapAdapter.class)
	public Map<Class<?>, List<Long>> getUnits() {
		return units;
	}

	public void setUnits(Map<Class<?>, List<Long>> units) {
		this.units = units;
	}
	
}
