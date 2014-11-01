package jmp.module04.multithreading.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.xmlbeans.SchemaTypeSystem;
import org.apache.xmlbeans.XmlBeans;
import org.apache.xmlbeans.XmlError;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlOptions;
import org.w3c.dom.Node;

public class XmlProcessor {
	private XmlOptions parseOptions = (new XmlOptions()).setLoadLineNumbers().setLoadMessageDigest();
    private List<XmlObject> schemas = new ArrayList<XmlObject>();
    private SchemaTypeSystem typeSystem;
        
    public XmlProcessor(SchemaLoader schemaLoader) {
        try {
            String[] common = schemaLoader.getSchemas();
            for (String schema : common) {
                schemas.add(XmlObject.Factory.parse(schema, parseOptions));
            }
            
            Collection<Object> compErrors = new ArrayList<Object>();
            XmlOptions opt = new XmlOptions();
            opt.setErrorListener(compErrors);
            typeSystem = XmlBeans.compileXsd(typeSystem, schemas.toArray(new XmlObject[0]), XmlBeans.loadXsd(schemas.toArray(new XmlObject[0])), opt);
        } catch (XmlException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
        
    public XmlObject parse(Node componentXml) {
        try {
            XmlObject xobj = typeSystem.parse(componentXml, null, parseOptions);
            if (!validate(xobj))
            		throw new RuntimeException("Validation fail during XmlObject unmarshalling.");
            return xobj;
        } catch (XmlException e) {
            throw new RuntimeException(e);
        }
    }
    
    private boolean validate(XmlObject rootXObject) {
    	
        XmlOptions validateOptions = new XmlOptions();
        ArrayList<Object> errorList = new ArrayList<Object>();
        validateOptions.setErrorListener(errorList);

        boolean isValid = rootXObject.validate(validateOptions);

        if (!isValid) {
            for (int i = 0; i < errorList.size(); i++) {
                XmlError error = (XmlError) errorList.get(i);
                System.out.println(" ERROR " + error);
            }
        }

        return isValid;
    }

}
