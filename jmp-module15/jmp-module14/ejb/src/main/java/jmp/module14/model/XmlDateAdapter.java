package jmp.module14.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class XmlDateAdapter extends XmlAdapter<String, Date> {
	
	private final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public String marshal(Date v) throws Exception {
		String stringDate = "";
		if (v != null) {
			stringDate = getFormatter().format(v);
		}
		return stringDate;
	}

	@Override
	public Date unmarshal(String v) throws Exception {
		Date date = null;
		if (v != null) {
			date = getFormatter().parse(v);
		}
		return date;
	}

	public DateFormat getFormatter() {
		return formatter;
	}
	

}
