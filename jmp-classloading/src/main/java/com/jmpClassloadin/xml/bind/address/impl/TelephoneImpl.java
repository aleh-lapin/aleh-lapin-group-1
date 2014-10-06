/*
 * XML Type:  telephone
 * Namespace: http://jmp-classloadin.com/xml/bind/Address
 * Java type: com.jmpClassloadin.xml.bind.address.Telephone
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.address.impl;
/**
 * An XML telephone(@http://jmp-classloadin.com/xml/bind/Address).
 *
 * This is an atomic type that is a restriction of com.jmpClassloadin.xml.bind.address.Telephone.
 */
public class TelephoneImpl extends org.apache.xmlbeans.impl.values.JavaStringHolderEx implements com.jmpClassloadin.xml.bind.address.Telephone
{
    
    public TelephoneImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType, true);
    }
    
    protected TelephoneImpl(org.apache.xmlbeans.SchemaType sType, boolean b)
    {
        super(sType, b);
    }
    
    private static final javax.xml.namespace.QName TELEPHONETYPE$0 = 
        new javax.xml.namespace.QName("", "telephone-type");
    
    
    /**
     * Gets the "telephone-type" attribute
     */
    public com.jmpClassloadin.xml.bind.address.TelephoneType.Enum getTelephoneType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TELEPHONETYPE$0);
            if (target == null)
            {
                return null;
            }
            return (com.jmpClassloadin.xml.bind.address.TelephoneType.Enum)target.getEnumValue();
        }
    }
    
    /**
     * Gets (as xml) the "telephone-type" attribute
     */
    public com.jmpClassloadin.xml.bind.address.TelephoneType xgetTelephoneType()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.TelephoneType target = null;
            target = (com.jmpClassloadin.xml.bind.address.TelephoneType)get_store().find_attribute_user(TELEPHONETYPE$0);
            return target;
        }
    }
    
    /**
     * Sets the "telephone-type" attribute
     */
    public void setTelephoneType(com.jmpClassloadin.xml.bind.address.TelephoneType.Enum telephoneType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            org.apache.xmlbeans.SimpleValue target = null;
            target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(TELEPHONETYPE$0);
            if (target == null)
            {
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(TELEPHONETYPE$0);
            }
            target.setEnumValue(telephoneType);
        }
    }
    
    /**
     * Sets (as xml) the "telephone-type" attribute
     */
    public void xsetTelephoneType(com.jmpClassloadin.xml.bind.address.TelephoneType telephoneType)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.TelephoneType target = null;
            target = (com.jmpClassloadin.xml.bind.address.TelephoneType)get_store().find_attribute_user(TELEPHONETYPE$0);
            if (target == null)
            {
                target = (com.jmpClassloadin.xml.bind.address.TelephoneType)get_store().add_attribute_user(TELEPHONETYPE$0);
            }
            target.set(telephoneType);
        }
    }
}
