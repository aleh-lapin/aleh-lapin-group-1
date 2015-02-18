package jmp.module14.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XmlMapAdapter extends XmlAdapter<XmlMapAdapter.UnitContainer, Map<Class<?>, List<Long>>> {
	
	public static class UnitContainer {
		
		private List<UnitValue> container;
		
		public UnitContainer() {
			container = new ArrayList<UnitValue>();
		}

		public List<UnitValue> getContainer() {
			return container;
		}

		public void setContainer(List<UnitValue> container) {
			this.container = container;
		}
				
	}
	
	public static class UnitValue {
		
		private String type;

		private Long unit;
		
		public UnitValue() {

		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Long getUnit() {
			return unit;
		}

		public void setUnit(Long unit) {
			this.unit = unit;
		}
				
	}

	@Override
	public UnitContainer marshal(Map<Class<?>, List<Long>> map)
			throws Exception {
		UnitContainer container = new UnitContainer();
		for(Map.Entry<Class<?>, List<Long>> entry : map.entrySet()) {
			for(Long id : entry.getValue()) {
				UnitValue unitValue = new UnitValue();
				unitValue.setType(entry.getKey().getSimpleName());
				unitValue.setUnit(id);
				container.getContainer().add(unitValue);
			}		
		}
		return container;
	}

	@Override
	public Map<Class<?>, List<Long>> unmarshal(UnitContainer container)
			throws Exception {
		Map<Class<?>, List<Long>> units = new HashMap<Class<?>, List<Long>>();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		List<Long> identities = new ArrayList<Long>();
		Class<?> type = null;
		for(UnitValue value : container.getContainer()) {
			identities.add(value.getUnit());
			if (type == null || !type.equals(loader.loadClass(value.type))) {
				units.put(type, identities);
			} 
			type = loader.loadClass(value.type);
		}
		return units;
	}
	
	

}
