/*
 * An XML document type.
 * Localname: Person
 * Namespace: http://jmp-classloadin.com/xml/bind/Person
 * Java type: com.jmpClassloadin.xml.bind.person.PersonDocument
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.person;


/**
 * A document containing one Person(@http://jmp-classloadin.com/xml/bind/Person) element.
 *
 * This is a complex type.
 */
public interface PersonDocument extends org.apache.xmlbeans.XmlObject
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(PersonDocument.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9BC851EB781E7870E72C06D5F0B0D541").resolveHandle("person7556doctype");
    
    /**
     * Gets the "Person" element
     */
    com.jmpClassloadin.xml.bind.person.PersonDocument.Person getPerson();
    
    /**
     * Sets the "Person" element
     */
    void setPerson(com.jmpClassloadin.xml.bind.person.PersonDocument.Person person);
    
    /**
     * Appends and returns a new empty "Person" element
     */
    com.jmpClassloadin.xml.bind.person.PersonDocument.Person addNewPerson();
    
    /**
     * An XML Person(@http://jmp-classloadin.com/xml/bind/Person).
     *
     * This is a complex type.
     */
    public interface Person extends org.apache.xmlbeans.XmlObject
    {
        public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
            org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Person.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9BC851EB781E7870E72C06D5F0B0D541").resolveHandle("personfce7elemtype");
        
        /**
         * Gets the "first-name" element
         */
        java.lang.String getFirstName();
        
        /**
         * Gets (as xml) the "first-name" element
         */
        com.jmpClassloadin.xml.bind.person.FirstName xgetFirstName();
        
        /**
         * Sets the "first-name" element
         */
        void setFirstName(java.lang.String firstName);
        
        /**
         * Sets (as xml) the "first-name" element
         */
        void xsetFirstName(com.jmpClassloadin.xml.bind.person.FirstName firstName);
        
        /**
         * Gets the "sur-name" element
         */
        java.lang.String getSurName();
        
        /**
         * Gets (as xml) the "sur-name" element
         */
        com.jmpClassloadin.xml.bind.person.SurName xgetSurName();
        
        /**
         * Sets the "sur-name" element
         */
        void setSurName(java.lang.String surName);
        
        /**
         * Sets (as xml) the "sur-name" element
         */
        void xsetSurName(com.jmpClassloadin.xml.bind.person.SurName surName);
        
        /**
         * Gets the "last-name" element
         */
        java.lang.String getLastName();
        
        /**
         * Gets (as xml) the "last-name" element
         */
        com.jmpClassloadin.xml.bind.person.LastName xgetLastName();
        
        /**
         * Sets the "last-name" element
         */
        void setLastName(java.lang.String lastName);
        
        /**
         * Sets (as xml) the "last-name" element
         */
        void xsetLastName(com.jmpClassloadin.xml.bind.person.LastName lastName);
        
        /**
         * Gets the "birth-date" element
         */
        java.util.Calendar getBirthDate();
        
        /**
         * Gets (as xml) the "birth-date" element
         */
        org.apache.xmlbeans.XmlDate xgetBirthDate();
        
        /**
         * Sets the "birth-date" element
         */
        void setBirthDate(java.util.Calendar birthDate);
        
        /**
         * Sets (as xml) the "birth-date" element
         */
        void xsetBirthDate(org.apache.xmlbeans.XmlDate birthDate);
        
        /**
         * Gets array of all "work-place" elements
         */
        java.lang.String[] getWorkPlaceArray();
        
        /**
         * Gets ith "work-place" element
         */
        java.lang.String getWorkPlaceArray(int i);
        
        /**
         * Gets (as xml) array of all "work-place" elements
         */
        org.apache.xmlbeans.XmlString[] xgetWorkPlaceArray();
        
        /**
         * Gets (as xml) ith "work-place" element
         */
        org.apache.xmlbeans.XmlString xgetWorkPlaceArray(int i);
        
        /**
         * Returns number of "work-place" element
         */
        int sizeOfWorkPlaceArray();
        
        /**
         * Sets array of all "work-place" element
         */
        void setWorkPlaceArray(java.lang.String[] workPlaceArray);
        
        /**
         * Sets ith "work-place" element
         */
        void setWorkPlaceArray(int i, java.lang.String workPlace);
        
        /**
         * Sets (as xml) array of all "work-place" element
         */
        void xsetWorkPlaceArray(org.apache.xmlbeans.XmlString[] workPlaceArray);
        
        /**
         * Sets (as xml) ith "work-place" element
         */
        void xsetWorkPlaceArray(int i, org.apache.xmlbeans.XmlString workPlace);
        
        /**
         * Inserts the value as the ith "work-place" element
         */
        void insertWorkPlace(int i, java.lang.String workPlace);
        
        /**
         * Appends the value as the last "work-place" element
         */
        void addWorkPlace(java.lang.String workPlace);
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "work-place" element
         */
        org.apache.xmlbeans.XmlString insertNewWorkPlace(int i);
        
        /**
         * Appends and returns a new empty value (as xml) as the last "work-place" element
         */
        org.apache.xmlbeans.XmlString addNewWorkPlace();
        
        /**
         * Removes the ith "work-place" element
         */
        void removeWorkPlace(int i);
        
        /**
         * Gets the "genre" element
         */
        com.jmpClassloadin.xml.bind.person.Genre.Enum getGenre();
        
        /**
         * Gets (as xml) the "genre" element
         */
        com.jmpClassloadin.xml.bind.person.Genre xgetGenre();
        
        /**
         * Sets the "genre" element
         */
        void setGenre(com.jmpClassloadin.xml.bind.person.Genre.Enum genre);
        
        /**
         * Sets (as xml) the "genre" element
         */
        void xsetGenre(com.jmpClassloadin.xml.bind.person.Genre genre);
        
        /**
         * Gets the "nationality" element
         */
        com.jmpClassloadin.xml.bind.person.Nationality.Enum getNationality();
        
        /**
         * Gets (as xml) the "nationality" element
         */
        com.jmpClassloadin.xml.bind.person.Nationality xgetNationality();
        
        /**
         * Sets the "nationality" element
         */
        void setNationality(com.jmpClassloadin.xml.bind.person.Nationality.Enum nationality);
        
        /**
         * Sets (as xml) the "nationality" element
         */
        void xsetNationality(com.jmpClassloadin.xml.bind.person.Nationality nationality);
        
        /**
         * Gets the "ID" attribute
         */
        long getID();
        
        /**
         * Gets (as xml) the "ID" attribute
         */
        org.apache.xmlbeans.XmlLong xgetID();
        
        /**
         * Sets the "ID" attribute
         */
        void setID(long id);
        
        /**
         * Sets (as xml) the "ID" attribute
         */
        void xsetID(org.apache.xmlbeans.XmlLong id);
        
        /**
         * A factory class with static methods for creating instances
         * of this type.
         */
        
        public static final class Factory
        {
            public static com.jmpClassloadin.xml.bind.person.PersonDocument.Person newInstance() {
              return (com.jmpClassloadin.xml.bind.person.PersonDocument.Person) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
            
            public static com.jmpClassloadin.xml.bind.person.PersonDocument.Person newInstance(org.apache.xmlbeans.XmlOptions options) {
              return (com.jmpClassloadin.xml.bind.person.PersonDocument.Person) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
            
            private Factory() { } // No instance of this class allowed
        }
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.jmpClassloadin.xml.bind.person.PersonDocument newInstance() {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.person.PersonDocument parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.person.PersonDocument) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
