/*
 * XML Type:  Nationality
 * Namespace: http://jmp-classloadin.com/xml/bind/Person
 * Java type: com.jmpClassloadin.xml.bind.person.Nationality
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.person;


/**
 * An XML Nationality(@http://jmp-classloadin.com/xml/bind/Person).
 *
 * This is an atomic type that is a restriction of com.jmpClassloadin.xml.bind.person.Nationality.
 */
public interface Nationality extends org.apache.xmlbeans.XmlString
{
    public static final org.apache.xmlbeans.SchemaType type = (org.apache.xmlbeans.SchemaType)
        org.apache.xmlbeans.XmlBeans.typeSystemForClassLoader(Nationality.class.getClassLoader(), "schemaorg_apache_xmlbeans.system.s9BC851EB781E7870E72C06D5F0B0D541").resolveHandle("nationalitye9d1type");
    
    org.apache.xmlbeans.StringEnumAbstractBase enumValue();
    void set(org.apache.xmlbeans.StringEnumAbstractBase e);
    
    static final Enum BE = Enum.forString("be");
    static final Enum RU = Enum.forString("ru");
    static final Enum BG = Enum.forString("bg");
    static final Enum ZH = Enum.forString("zh");
    static final Enum EN = Enum.forString("en");
    static final Enum US = Enum.forString("us");
    
    static final int INT_BE = Enum.INT_BE;
    static final int INT_RU = Enum.INT_RU;
    static final int INT_BG = Enum.INT_BG;
    static final int INT_ZH = Enum.INT_ZH;
    static final int INT_EN = Enum.INT_EN;
    static final int INT_US = Enum.INT_US;
    
    /**
     * Enumeration value class for com.jmpClassloadin.xml.bind.person.Nationality.
     * These enum values can be used as follows:
     * <pre>
     * enum.toString(); // returns the string value of the enum
     * enum.intValue(); // returns an int value, useful for switches
     * // e.g., case Enum.INT_BE
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
        
        static final int INT_BE = 1;
        static final int INT_RU = 2;
        static final int INT_BG = 3;
        static final int INT_ZH = 4;
        static final int INT_EN = 5;
        static final int INT_US = 6;
        
        public static final org.apache.xmlbeans.StringEnumAbstractBase.Table table =
            new org.apache.xmlbeans.StringEnumAbstractBase.Table
        (
            new Enum[]
            {
                new Enum("be", INT_BE),
                new Enum("ru", INT_RU),
                new Enum("bg", INT_BG),
                new Enum("zh", INT_ZH),
                new Enum("en", INT_EN),
                new Enum("us", INT_US),
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
        public static com.jmpClassloadin.xml.bind.person.Nationality newValue(java.lang.Object obj) {
          return (com.jmpClassloadin.xml.bind.person.Nationality) type.newValue( obj ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality newInstance() {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality newInstance(org.apache.xmlbeans.XmlOptions options) {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newInstance( type, options ); }
        
        /** @param xmlAsString the string value to parse */
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.lang.String xmlAsString) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.lang.String xmlAsString, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xmlAsString, type, options ); }
        
        /** @param file the file from which to load an xml document */
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.io.File file) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.io.File file, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( file, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.net.URL u) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.net.URL u, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( u, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.io.InputStream is) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.io.InputStream is, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( is, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.io.Reader r) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(java.io.Reader r, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, java.io.IOException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( r, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(javax.xml.stream.XMLStreamReader sr) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(javax.xml.stream.XMLStreamReader sr, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( sr, type, options ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(org.w3c.dom.Node node) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, null ); }
        
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(org.w3c.dom.Node node, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( node, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static com.jmpClassloadin.xml.bind.person.Nationality parse(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return (com.jmpClassloadin.xml.bind.person.Nationality) org.apache.xmlbeans.XmlBeans.getContextTypeLoader().parse( xis, type, options ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, null ); }
        
        /** @deprecated {@link org.apache.xmlbeans.xml.stream.XMLInputStream} */
        public static org.apache.xmlbeans.xml.stream.XMLInputStream newValidatingXMLInputStream(org.apache.xmlbeans.xml.stream.XMLInputStream xis, org.apache.xmlbeans.XmlOptions options) throws org.apache.xmlbeans.XmlException, org.apache.xmlbeans.xml.stream.XMLStreamException {
          return org.apache.xmlbeans.XmlBeans.getContextTypeLoader().newValidatingXMLInputStream( xis, type, options ); }
        
        private Factory() { } // No instance of this class allowed
    }
}
