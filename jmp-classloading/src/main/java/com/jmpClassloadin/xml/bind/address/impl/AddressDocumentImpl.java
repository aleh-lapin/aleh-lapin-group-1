/*
 * An XML document type.
 * Localname: Address
 * Namespace: http://jmp-classloadin.com/xml/bind/Address
 * Java type: com.jmpClassloadin.xml.bind.address.AddressDocument
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.address.impl;
/**
 * A document containing one Address(@http://jmp-classloadin.com/xml/bind/Address) element.
 *
 * This is a complex type.
 */
public class AddressDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jmpClassloadin.xml.bind.address.AddressDocument
{
    
    public AddressDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName ADDRESS$0 = 
        new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Address", "Address");
    
    
    /**
     * Gets the "Address" element
     */
    public com.jmpClassloadin.xml.bind.address.AddressDocument.Address getAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.AddressDocument.Address target = null;
            target = (com.jmpClassloadin.xml.bind.address.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Address" element
     */
    public void setAddress(com.jmpClassloadin.xml.bind.address.AddressDocument.Address address)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.AddressDocument.Address target = null;
            target = (com.jmpClassloadin.xml.bind.address.AddressDocument.Address)get_store().find_element_user(ADDRESS$0, 0);
            if (target == null)
            {
                target = (com.jmpClassloadin.xml.bind.address.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
            }
            target.set(address);
        }
    }
    
    /**
     * Appends and returns a new empty "Address" element
     */
    public com.jmpClassloadin.xml.bind.address.AddressDocument.Address addNewAddress()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.AddressDocument.Address target = null;
            target = (com.jmpClassloadin.xml.bind.address.AddressDocument.Address)get_store().add_element_user(ADDRESS$0);
            return target;
        }
    }
    /**
     * An XML Address(@http://jmp-classloadin.com/xml/bind/Address).
     *
     * This is a complex type.
     */
    public static class AddressImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jmpClassloadin.xml.bind.address.AddressDocument.Address
    {
        
        public AddressImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName COUNTRY$0 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Address", "country");
        private static final javax.xml.namespace.QName CITY$2 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Address", "city");
        private static final javax.xml.namespace.QName DISTRICT$4 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Address", "district");
        private static final javax.xml.namespace.QName TELEPHONES$6 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Address", "telephones");
        
        
        /**
         * Gets the "country" element
         */
        public java.lang.String getCountry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COUNTRY$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "country" element
         */
        public org.apache.xmlbeans.XmlString xgetCountry()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COUNTRY$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "country" element
         */
        public void setCountry(java.lang.String country)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(COUNTRY$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(COUNTRY$0);
                }
                target.setStringValue(country);
            }
        }
        
        /**
         * Sets (as xml) the "country" element
         */
        public void xsetCountry(org.apache.xmlbeans.XmlString country)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(COUNTRY$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(COUNTRY$0);
                }
                target.set(country);
            }
        }
        
        /**
         * Gets the "city" element
         */
        public java.lang.String getCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "city" element
         */
        public org.apache.xmlbeans.XmlString xgetCity()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "city" element
         */
        public void setCity(java.lang.String city)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(CITY$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(CITY$2);
                }
                target.setStringValue(city);
            }
        }
        
        /**
         * Sets (as xml) the "city" element
         */
        public void xsetCity(org.apache.xmlbeans.XmlString city)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(CITY$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(CITY$2);
                }
                target.set(city);
            }
        }
        
        /**
         * Gets the "district" element
         */
        public java.lang.String getDistrict()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISTRICT$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "district" element
         */
        public org.apache.xmlbeans.XmlString xgetDistrict()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DISTRICT$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "district" element
         */
        public void setDistrict(java.lang.String district)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(DISTRICT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(DISTRICT$4);
                }
                target.setStringValue(district);
            }
        }
        
        /**
         * Sets (as xml) the "district" element
         */
        public void xsetDistrict(org.apache.xmlbeans.XmlString district)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(DISTRICT$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(DISTRICT$4);
                }
                target.set(district);
            }
        }
        
        /**
         * Gets the "telephones" element
         */
        public com.jmpClassloadin.xml.bind.address.Telephones getTelephones()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.address.Telephones target = null;
                target = (com.jmpClassloadin.xml.bind.address.Telephones)get_store().find_element_user(TELEPHONES$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target;
            }
        }
        
        /**
         * Sets the "telephones" element
         */
        public void setTelephones(com.jmpClassloadin.xml.bind.address.Telephones telephones)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.address.Telephones target = null;
                target = (com.jmpClassloadin.xml.bind.address.Telephones)get_store().find_element_user(TELEPHONES$6, 0);
                if (target == null)
                {
                    target = (com.jmpClassloadin.xml.bind.address.Telephones)get_store().add_element_user(TELEPHONES$6);
                }
                target.set(telephones);
            }
        }
        
        /**
         * Appends and returns a new empty "telephones" element
         */
        public com.jmpClassloadin.xml.bind.address.Telephones addNewTelephones()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.address.Telephones target = null;
                target = (com.jmpClassloadin.xml.bind.address.Telephones)get_store().add_element_user(TELEPHONES$6);
                return target;
            }
        }
    }
}
