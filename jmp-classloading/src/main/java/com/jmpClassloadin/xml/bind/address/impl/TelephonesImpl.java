/*
 * XML Type:  telephones
 * Namespace: http://jmp-classloadin.com/xml/bind/Address
 * Java type: com.jmpClassloadin.xml.bind.address.Telephones
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.address.impl;
/**
 * An XML telephones(@http://jmp-classloadin.com/xml/bind/Address).
 *
 * This is a complex type.
 */
public class TelephonesImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jmpClassloadin.xml.bind.address.Telephones
{
    
    public TelephonesImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName TELEPHONE$0 = 
        new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Address", "telephone");
    
    
    /**
     * Gets array of all "telephone" elements
     */
    public com.jmpClassloadin.xml.bind.address.Telephone[] getTelephoneArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            java.util.List targetList = new java.util.ArrayList();
            get_store().find_all_element_users(TELEPHONE$0, targetList);
            com.jmpClassloadin.xml.bind.address.Telephone[] result = new com.jmpClassloadin.xml.bind.address.Telephone[targetList.size()];
            targetList.toArray(result);
            return result;
        }
    }
    
    /**
     * Gets ith "telephone" element
     */
    public com.jmpClassloadin.xml.bind.address.Telephone getTelephoneArray(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.Telephone target = null;
            target = (com.jmpClassloadin.xml.bind.address.Telephone)get_store().find_element_user(TELEPHONE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            return target;
        }
    }
    
    /**
     * Returns number of "telephone" element
     */
    public int sizeOfTelephoneArray()
    {
        synchronized (monitor())
        {
            check_orphaned();
            return get_store().count_elements(TELEPHONE$0);
        }
    }
    
    /**
     * Sets array of all "telephone" element
     */
    public void setTelephoneArray(com.jmpClassloadin.xml.bind.address.Telephone[] telephoneArray)
    {
        synchronized (monitor())
        {
            check_orphaned();
            arraySetterHelper(telephoneArray, TELEPHONE$0);
        }
    }
    
    /**
     * Sets ith "telephone" element
     */
    public void setTelephoneArray(int i, com.jmpClassloadin.xml.bind.address.Telephone telephone)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.Telephone target = null;
            target = (com.jmpClassloadin.xml.bind.address.Telephone)get_store().find_element_user(TELEPHONE$0, i);
            if (target == null)
            {
                throw new IndexOutOfBoundsException();
            }
            target.set(telephone);
        }
    }
    
    /**
     * Inserts and returns a new empty value (as xml) as the ith "telephone" element
     */
    public com.jmpClassloadin.xml.bind.address.Telephone insertNewTelephone(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.Telephone target = null;
            target = (com.jmpClassloadin.xml.bind.address.Telephone)get_store().insert_element_user(TELEPHONE$0, i);
            return target;
        }
    }
    
    /**
     * Appends and returns a new empty value (as xml) as the last "telephone" element
     */
    public com.jmpClassloadin.xml.bind.address.Telephone addNewTelephone()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.address.Telephone target = null;
            target = (com.jmpClassloadin.xml.bind.address.Telephone)get_store().add_element_user(TELEPHONE$0);
            return target;
        }
    }
    
    /**
     * Removes the ith "telephone" element
     */
    public void removeTelephone(int i)
    {
        synchronized (monitor())
        {
            check_orphaned();
            get_store().remove_element(TELEPHONE$0, i);
        }
    }
}
