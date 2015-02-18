package jmp.module14.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(value = XmlAccessType.PROPERTY)
public class Elements {
	
	
	private List<Unit> elements = new ArrayList<Unit>();

	@XmlAnyElement
	public List<Unit> getElements() {
		return elements;
	}

	public void setElements(List<Unit> elements) {
		this.elements = elements;
	}
	
}
