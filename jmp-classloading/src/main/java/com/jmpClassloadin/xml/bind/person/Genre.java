/*
 * XML Type:  genre
 * Namespace: http://jmp-classloadin.com/xml/bind/Person
 * Java type: com.jmpClassloadin.xml.bind.person.Genre
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.person;


/**
 * An XML genre(@http://jmp-classloadin.com/xml/bind/Person).
 *
 * This is an atomic type that is a restriction of com.jmpClassloadin.xml.bind.person.Genre.
 */
public interface Genre extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Genre.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9BC851EB781E7870E72C06D5F0B0D541").resolveHandle("genre2e4atype");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum W = Enum.forString("W");
    static final Enum M = Enum.forString("M");
    static final Enum U = Enum.forString("U");
    
    static final int INT_W = Enum.INT_W;
    static final int INT_M = Enum.INT_M;
    static final int INT_U = Enum.INT_U;
    
    /**
     * Enumeration value class for com.jmpClassloadin.xml.bind.person.Genre.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_W
     * Enum.forString(s); // returns the enum value for a string
     * Enum.forInt(i); // returns the enum value for an int
     * </pre>
     * Enumeration objects are immutable singleton objects that
     * can be compared using == object equality. They have no
     * public constructor. See the constants defined within this
     * class for all the valid values.
     */
    static final class Enum extends org.apache.xmlbeans.StringEnumAbstractBase
    {
        /**
         * Returns the enum value for a string, or null if none.
         */
        public static Enum forString(java.lang.String s)
            { return (Enum)table.forString(s); }
        /**
         * Returns the enum value corresponding to an int, or null if none.
         */
        public static Enum forInt(int i)
            { return (Enum)table.forInt(i); }
        
        private Enum(java.lang.String s, int i)
            { super(s, i); }
        
        static final int INT_W = 1;
        static final int INT_M = 2;
        static final int INT_U = 3;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("W", INT_W),
                new Enum("M", INT_M),
                new Enum("U", INT_U),
            }
        );
        private static final long serialVersionUID = 1L;
        private java.lang.Object readResolve() { return forInt(intValue()); } 
    }
    
    /**
     * A factory class with static methods for creating instances
     * of this type.
     */
    
    public static final class Factory
    {
        public static com.jmpClassloadin.xml.bind.person.Genre newValue(java.lang.Object obj) {
          return (com.jmpClassloadin.xml.bind.person.Genre) type.newValue( obj ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre newInstance() {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Genre parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.person.Genre parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.person.Genre parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.person.Genre) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
