package jmp.module04.multithreading.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SchemaLoader {
	
	private List<String> schemasList = new ArrayList<String>();

	public String[] getSchemas() throws IOException {
		schemasList.add(loadSchema("/Address.xsd"));
		schemasList.add(loadSchema("/currency.xsd"));
		schemasList.add(loadSchema("/Person.xsd"));
		return schemasList.toArray(new String[0]);
	}

	private String loadSchema(String schema) throws IOException {
		InputStream is = getClass().getResourceAsStream(schema);
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuilder buffer = new StringBuilder();
		String line;
		while ((line = in.readLine()) != null) {
			buffer.append(line).append("\n");
		}
		in.close();
		return buffer.toString();
	}
	
	public void addSchema(String schemaName) {
		try {
			schemasList.add(loadSchema(schemaName));
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

}
