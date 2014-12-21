package jmp.module11.mvc.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String arg0) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = arg0;
        try {
            return format.parse(date);
        } catch (ParseException e) {
            try {
				return new  SimpleDateFormat("yyyy-MM-dd").parse(date);
			} catch (ParseException e1) {
				throw new RuntimeException(e1);
			}
        }
	}


}
