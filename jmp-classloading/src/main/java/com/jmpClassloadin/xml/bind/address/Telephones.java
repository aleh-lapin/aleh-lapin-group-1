/*
 * XML Type:  telephones
 * Namespace: http://jmp-classloadin.com/xml/bind/Address
 * Java type: com.jmpClassloadin.xml.bind.address.Telephones
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.address;


/**
 * An XML telephones(@http://jmp-classloadin.com/xml/bind/Address).
 *
 * This is a complex type.
 */
public interface Telephones extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Telephones.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9BC851EB781E7870E72C06D5F0B0D541").resolveHandle("telephonese1fdtype");
    
    /**
     * Gets array of all "telephone" elements
     */
    com.jmpClassloadin.xml.bind.address.Telephone[] getTelephoneArray();
    
    /**
     * Gets ith "telephone" element
     */
    com.jmpClassloadin.xml.bind.address.Telephone getTelephoneArray(int i);
    
    /**
     * Returns number of "telephone" element
     */
    int sizeOfTelephoneArray();
    
    /**
     * Sets array of all "telephone" element
     */
    void setTelephoneArray(com.jmpClassloadin.xml.bind.address.Telephone[] telephoneArray);
    
    /**
     * Sets ith "telephone" element
     */
    void setTelephoneArray(int i, com.jmpClassloadin.xml.bind.address.Telephone telephone);
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "telephone" element
     */
    com.jmpClassloadin.xml.bind.address.Telephone insertNewTelephone(int i);
    
    /**
     * Appends and returns a new empty value (as xml) as the last "telephone" element
     */
    com.jmpClassloadin.xml.bind.address.Telephone addNewTelephone();
    
    /**
     * Removes the ith "telephone" element
     */
    void removeTelephone(int i);
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.jmpClassloadin.xml.bind.address.Telephones newInstance() {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.address.Telephones parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.address.Telephones) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
