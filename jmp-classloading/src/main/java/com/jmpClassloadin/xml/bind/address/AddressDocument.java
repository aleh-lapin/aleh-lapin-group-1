/*
 * An XML document type.
 * Localname: Address
 * Namespace: http://jmp-classloadin.com/xml/bind/Address
 * Java type: com.jmpClassloadin.xml.bind.address.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.address;


/**
 * A document containing one Address(@http://jmp-classloadin.com/xml/bind/Address) element.
 *
 * This is a complex type.
 */
public interface AddressDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(AddressDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9BC851EB781E7870E72C06D5F0B0D541").resolveHandle("addressb2a0doctype");
    
    /**
     * Gets the "Address" element
     */
    com.jmpClassloadin.xml.bind.address.AddressDocument.Address getAddress();
    
    /**
     * Sets the "Address" element
     */
    void setAddress(com.jmpClassloadin.xml.bind.address.AddressDocument.Address address);
    
    /**
     * Appends and returns a new empty "Address" element
     */
    com.jmpClassloadin.xml.bind.address.AddressDocument.Address addNewAddress();
    
    /**
     * An XML Address(@http://jmp-classloadin.com/xml/bind/Address).
     *
     * This is a complex type.
     */
    public interface Address extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Address.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9BC851EB781E7870E72C06D5F0B0D541").resolveHandle("addressd2e0elemtype");
        
        /**
         * Gets the "country" element
         */
        java.lang.String getCountry();
        
        /**
         * Gets (as xml) the "country" element
         */
        org.apache.xmlbeans.XmlString xgetCountry();
        
        /**
         * Sets the "country" element
         */
        void setCountry(java.lang.String country);
        
        /**
         * Sets (as xml) the "country" element
         */
        void xsetCountry(org.apache.xmlbeans.XmlString country);
        
        /**
         * Gets the "city" element
         */
        java.lang.String getCity();
        
        /**
         * Gets (as xml) the "city" element
         */
        org.apache.xmlbeans.XmlString xgetCity();
        
        /**
         * Sets the "city" element
         */
        void setCity(java.lang.String city);
        
        /**
         * Sets (as xml) the "city" element
         */
        void xsetCity(org.apache.xmlbeans.XmlString city);
        
        /**
         * Gets the "district" element
         */
        java.lang.String getDistrict();
        
        /**
         * Gets (as xml) the "district" element
         */
        org.apache.xmlbeans.XmlString xgetDistrict();
        
        /**
         * Sets the "district" element
         */
        void setDistrict(java.lang.String district);
        
        /**
         * Sets (as xml) the "district" element
         */
        void xsetDistrict(org.apache.xmlbeans.XmlString district);
        
        /**
         * Gets the "telephones" element
         */
        com.jmpClassloadin.xml.bind.address.Telephones getTelephones();
        
        /**
         * Sets the "telephones" element
         */
        void setTelephones(com.jmpClassloadin.xml.bind.address.Telephones telephones);
        
        /**
         * Appends and returns a new empty "telephones" element
         */
        com.jmpClassloadin.xml.bind.address.Telephones addNewTelephones();
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.jmpClassloadin.xml.bind.address.AddressDocument.Address newInstance() {
              return (com.jmpClassloadin.xml.bind.address.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.jmpClassloadin.xml.bind.address.AddressDocument.Address newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.jmpClassloadin.xml.bind.address.AddressDocument.Address) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.jmpClassloadin.xml.bind.address.AddressDocument newInstance() {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.address.AddressDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.address.AddressDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
