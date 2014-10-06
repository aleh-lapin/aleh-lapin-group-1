/*
 * An XML document type.
 * Localname: Person
 * Namespace: http://jmp-classloadin.com/xml/bind/Person
 * Java type: com.jmpClassloadin.xml.bind.person.PersonDocument
 *
 * Automatically generated - do not modify.
 */
package com.jmpClassloadin.xml.bind.person.impl;
/**
 * A document containing one Person(@http://jmp-classloadin.com/xml/bind/Person) element.
 *
 * This is a complex type.
 */
public class PersonDocumentImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jmpClassloadin.xml.bind.person.PersonDocument
{
    
    public PersonDocumentImpl(org.apache.xmlbeans.SchemaType sType)
    {
        super(sType);
    }
    
    private static final javax.xml.namespace.QName PERSON$0 = 
        new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "Person");
    
    
    /**
     * Gets the "Person" element
     */
    public com.jmpClassloadin.xml.bind.person.PersonDocument.Person getPerson()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.person.PersonDocument.Person target = null;
            target = (com.jmpClassloadin.xml.bind.person.PersonDocument.Person)get_store().find_element_user(PERSON$0, 0);
            if (target == null)
            {
                return null;
            }
            return target;
        }
    }
    
    /**
     * Sets the "Person" element
     */
    public void setPerson(com.jmpClassloadin.xml.bind.person.PersonDocument.Person person)
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.person.PersonDocument.Person target = null;
            target = (com.jmpClassloadin.xml.bind.person.PersonDocument.Person)get_store().find_element_user(PERSON$0, 0);
            if (target == null)
            {
                target = (com.jmpClassloadin.xml.bind.person.PersonDocument.Person)get_store().add_element_user(PERSON$0);
            }
            target.set(person);
        }
    }
    
    /**
     * Appends and returns a new empty "Person" element
     */
    public com.jmpClassloadin.xml.bind.person.PersonDocument.Person addNewPerson()
    {
        synchronized (monitor())
        {
            check_orphaned();
            com.jmpClassloadin.xml.bind.person.PersonDocument.Person target = null;
            target = (com.jmpClassloadin.xml.bind.person.PersonDocument.Person)get_store().add_element_user(PERSON$0);
            return target;
        }
    }
    /**
     * An XML Person(@http://jmp-classloadin.com/xml/bind/Person).
     *
     * This is a complex type.
     */
    public static class PersonImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements com.jmpClassloadin.xml.bind.person.PersonDocument.Person
    {
        
        public PersonImpl(org.apache.xmlbeans.SchemaType sType)
        {
            super(sType);
        }
        
        private static final javax.xml.namespace.QName FIRSTNAME$0 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "first-name");
        private static final javax.xml.namespace.QName SURNAME$2 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "sur-name");
        private static final javax.xml.namespace.QName LASTNAME$4 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "last-name");
        private static final javax.xml.namespace.QName BIRTHDATE$6 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "birth-date");
        private static final javax.xml.namespace.QName WORKPLACE$8 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "work-place");
        private static final javax.xml.namespace.QName GENRE$10 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "genre");
        private static final javax.xml.namespace.QName NATIONALITY$12 = 
            new javax.xml.namespace.QName("http://jmp-classloadin.com/xml/bind/Person", "nationality");
        private static final javax.xml.namespace.QName ID$14 = 
            new javax.xml.namespace.QName("", "ID");
        
        
        /**
         * Gets the "first-name" element
         */
        public java.lang.String getFirstName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$0, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "first-name" element
         */
        public com.jmpClassloadin.xml.bind.person.FirstName xgetFirstName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.FirstName target = null;
                target = (com.jmpClassloadin.xml.bind.person.FirstName)get_store().find_element_user(FIRSTNAME$0, 0);
                return target;
            }
        }
        
        /**
         * Sets the "first-name" element
         */
        public void setFirstName(java.lang.String firstName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(FIRSTNAME$0, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(FIRSTNAME$0);
                }
                target.setStringValue(firstName);
            }
        }
        
        /**
         * Sets (as xml) the "first-name" element
         */
        public void xsetFirstName(com.jmpClassloadin.xml.bind.person.FirstName firstName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.FirstName target = null;
                target = (com.jmpClassloadin.xml.bind.person.FirstName)get_store().find_element_user(FIRSTNAME$0, 0);
                if (target == null)
                {
                    target = (com.jmpClassloadin.xml.bind.person.FirstName)get_store().add_element_user(FIRSTNAME$0);
                }
                target.set(firstName);
            }
        }
        
        /**
         * Gets the "sur-name" element
         */
        public java.lang.String getSurName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SURNAME$2, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "sur-name" element
         */
        public com.jmpClassloadin.xml.bind.person.SurName xgetSurName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.SurName target = null;
                target = (com.jmpClassloadin.xml.bind.person.SurName)get_store().find_element_user(SURNAME$2, 0);
                return target;
            }
        }
        
        /**
         * Sets the "sur-name" element
         */
        public void setSurName(java.lang.String surName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(SURNAME$2, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(SURNAME$2);
                }
                target.setStringValue(surName);
            }
        }
        
        /**
         * Sets (as xml) the "sur-name" element
         */
        public void xsetSurName(com.jmpClassloadin.xml.bind.person.SurName surName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.SurName target = null;
                target = (com.jmpClassloadin.xml.bind.person.SurName)get_store().find_element_user(SURNAME$2, 0);
                if (target == null)
                {
                    target = (com.jmpClassloadin.xml.bind.person.SurName)get_store().add_element_user(SURNAME$2);
                }
                target.set(surName);
            }
        }
        
        /**
         * Gets the "last-name" element
         */
        public java.lang.String getLastName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTNAME$4, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) the "last-name" element
         */
        public com.jmpClassloadin.xml.bind.person.LastName xgetLastName()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.LastName target = null;
                target = (com.jmpClassloadin.xml.bind.person.LastName)get_store().find_element_user(LASTNAME$4, 0);
                return target;
            }
        }
        
        /**
         * Sets the "last-name" element
         */
        public void setLastName(java.lang.String lastName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(LASTNAME$4, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(LASTNAME$4);
                }
                target.setStringValue(lastName);
            }
        }
        
        /**
         * Sets (as xml) the "last-name" element
         */
        public void xsetLastName(com.jmpClassloadin.xml.bind.person.LastName lastName)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.LastName target = null;
                target = (com.jmpClassloadin.xml.bind.person.LastName)get_store().find_element_user(LASTNAME$4, 0);
                if (target == null)
                {
                    target = (com.jmpClassloadin.xml.bind.person.LastName)get_store().add_element_user(LASTNAME$4);
                }
                target.set(lastName);
            }
        }
        
        /**
         * Gets the "birth-date" element
         */
        public java.util.Calendar getBirthDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BIRTHDATE$6, 0);
                if (target == null)
                {
                    return null;
                }
                return target.getCalendarValue();
            }
        }
        
        /**
         * Gets (as xml) the "birth-date" element
         */
        public org.apache.xmlbeans.XmlDate xgetBirthDate()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDate target = null;
                target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(BIRTHDATE$6, 0);
                return target;
            }
        }
        
        /**
         * Sets the "birth-date" element
         */
        public void setBirthDate(java.util.Calendar birthDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(BIRTHDATE$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(BIRTHDATE$6);
                }
                target.setCalendarValue(birthDate);
            }
        }
        
        /**
         * Sets (as xml) the "birth-date" element
         */
        public void xsetBirthDate(org.apache.xmlbeans.XmlDate birthDate)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlDate target = null;
                target = (org.apache.xmlbeans.XmlDate)get_store().find_element_user(BIRTHDATE$6, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlDate)get_store().add_element_user(BIRTHDATE$6);
                }
                target.set(birthDate);
            }
        }
        
        /**
         * Gets array of all "work-place" elements
         */
        public java.lang.String[] getWorkPlaceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(WORKPLACE$8, targetList);
                java.lang.String[] result = new java.lang.String[targetList.size()];
                for (int i = 0, len = targetList.size() ; i < len ; i++)
                    result[i] = ((org.apache.xmlbeans.SimpleValue)targetList.get(i)).getStringValue();
                return result;
            }
        }
        
        /**
         * Gets ith "work-place" element
         */
        public java.lang.String getWorkPlaceArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKPLACE$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return target.getStringValue();
            }
        }
        
        /**
         * Gets (as xml) array of all "work-place" elements
         */
        public org.apache.xmlbeans.XmlString[] xgetWorkPlaceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                java.util.List targetList = new java.util.ArrayList();
                get_store().find_all_element_users(WORKPLACE$8, targetList);
                org.apache.xmlbeans.XmlString[] result = new org.apache.xmlbeans.XmlString[targetList.size()];
                targetList.toArray(result);
                return result;
            }
        }
        
        /**
         * Gets (as xml) ith "work-place" element
         */
        public org.apache.xmlbeans.XmlString xgetWorkPlaceArray(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKPLACE$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                return (org.apache.xmlbeans.XmlString)target;
            }
        }
        
        /**
         * Returns number of "work-place" element
         */
        public int sizeOfWorkPlaceArray()
        {
            synchronized (monitor())
            {
                check_orphaned();
                return get_store().count_elements(WORKPLACE$8);
            }
        }
        
        /**
         * Sets array of all "work-place" element
         */
        public void setWorkPlaceArray(java.lang.String[] workPlaceArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(workPlaceArray, WORKPLACE$8);
            }
        }
        
        /**
         * Sets ith "work-place" element
         */
        public void setWorkPlaceArray(int i, java.lang.String workPlace)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(WORKPLACE$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.setStringValue(workPlace);
            }
        }
        
        /**
         * Sets (as xml) array of all "work-place" element
         */
        public void xsetWorkPlaceArray(org.apache.xmlbeans.XmlString[]workPlaceArray)
        {
            synchronized (monitor())
            {
                check_orphaned();
                arraySetterHelper(workPlaceArray, WORKPLACE$8);
            }
        }
        
        /**
         * Sets (as xml) ith "work-place" element
         */
        public void xsetWorkPlaceArray(int i, org.apache.xmlbeans.XmlString workPlace)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().find_element_user(WORKPLACE$8, i);
                if (target == null)
                {
                    throw new IndexOutOfBoundsException();
                }
                target.set(workPlace);
            }
        }
        
        /**
         * Inserts the value as the ith "work-place" element
         */
        public void insertWorkPlace(int i, java.lang.String workPlace)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = 
                    (org.apache.xmlbeans.SimpleValue)get_store().insert_element_user(WORKPLACE$8, i);
                target.setStringValue(workPlace);
            }
        }
        
        /**
         * Appends the value as the last "work-place" element
         */
        public void addWorkPlace(java.lang.String workPlace)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(WORKPLACE$8);
                target.setStringValue(workPlace);
            }
        }
        
        /**
         * Inserts and returns a new empty value (as xml) as the ith "work-place" element
         */
        public org.apache.xmlbeans.XmlString insertNewWorkPlace(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().insert_element_user(WORKPLACE$8, i);
                return target;
            }
        }
        
        /**
         * Appends and returns a new empty value (as xml) as the last "work-place" element
         */
        public org.apache.xmlbeans.XmlString addNewWorkPlace()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlString target = null;
                target = (org.apache.xmlbeans.XmlString)get_store().add_element_user(WORKPLACE$8);
                return target;
            }
        }
        
        /**
         * Removes the ith "work-place" element
         */
        public void removeWorkPlace(int i)
        {
            synchronized (monitor())
            {
                check_orphaned();
                get_store().remove_element(WORKPLACE$8, i);
            }
        }
        
        /**
         * Gets the "genre" element
         */
        public com.jmpClassloadin.xml.bind.person.Genre.Enum getGenre()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENRE$10, 0);
                if (target == null)
                {
                    return null;
                }
                return (com.jmpClassloadin.xml.bind.person.Genre.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "genre" element
         */
        public com.jmpClassloadin.xml.bind.person.Genre xgetGenre()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.Genre target = null;
                target = (com.jmpClassloadin.xml.bind.person.Genre)get_store().find_element_user(GENRE$10, 0);
                return target;
            }
        }
        
        /**
         * Sets the "genre" element
         */
        public void setGenre(com.jmpClassloadin.xml.bind.person.Genre.Enum genre)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(GENRE$10, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(GENRE$10);
                }
                target.setEnumValue(genre);
            }
        }
        
        /**
         * Sets (as xml) the "genre" element
         */
        public void xsetGenre(com.jmpClassloadin.xml.bind.person.Genre genre)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.Genre target = null;
                target = (com.jmpClassloadin.xml.bind.person.Genre)get_store().find_element_user(GENRE$10, 0);
                if (target == null)
                {
                    target = (com.jmpClassloadin.xml.bind.person.Genre)get_store().add_element_user(GENRE$10);
                }
                target.set(genre);
            }
        }
        
        /**
         * Gets the "nationality" element
         */
        public com.jmpClassloadin.xml.bind.person.Nationality.Enum getNationality()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NATIONALITY$12, 0);
                if (target == null)
                {
                    return null;
                }
                return (com.jmpClassloadin.xml.bind.person.Nationality.Enum)target.getEnumValue();
            }
        }
        
        /**
         * Gets (as xml) the "nationality" element
         */
        public com.jmpClassloadin.xml.bind.person.Nationality xgetNationality()
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.Nationality target = null;
                target = (com.jmpClassloadin.xml.bind.person.Nationality)get_store().find_element_user(NATIONALITY$12, 0);
                return target;
            }
        }
        
        /**
         * Sets the "nationality" element
         */
        public void setNationality(com.jmpClassloadin.xml.bind.person.Nationality.Enum nationality)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_element_user(NATIONALITY$12, 0);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_element_user(NATIONALITY$12);
                }
                target.setEnumValue(nationality);
            }
        }
        
        /**
         * Sets (as xml) the "nationality" element
         */
        public void xsetNationality(com.jmpClassloadin.xml.bind.person.Nationality nationality)
        {
            synchronized (monitor())
            {
                check_orphaned();
                com.jmpClassloadin.xml.bind.person.Nationality target = null;
                target = (com.jmpClassloadin.xml.bind.person.Nationality)get_store().find_element_user(NATIONALITY$12, 0);
                if (target == null)
                {
                    target = (com.jmpClassloadin.xml.bind.person.Nationality)get_store().add_element_user(NATIONALITY$12);
                }
                target.set(nationality);
            }
        }
        
        /**
         * Gets the "ID" attribute
         */
        public long getID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$14);
                if (target == null)
                {
                    return 0L;
                }
                return target.getLongValue();
            }
        }
        
        /**
         * Gets (as xml) the "ID" attribute
         */
        public org.apache.xmlbeans.XmlLong xgetID()
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(ID$14);
                return target;
            }
        }
        
        /**
         * Sets the "ID" attribute
         */
        public void setID(long id)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.SimpleValue target = null;
                target = (org.apache.xmlbeans.SimpleValue)get_store().find_attribute_user(ID$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.SimpleValue)get_store().add_attribute_user(ID$14);
                }
                target.setLongValue(id);
            }
        }
        
        /**
         * Sets (as xml) the "ID" attribute
         */
        public void xsetID(org.apache.xmlbeans.XmlLong id)
        {
            synchronized (monitor())
            {
                check_orphaned();
                org.apache.xmlbeans.XmlLong target = null;
                target = (org.apache.xmlbeans.XmlLong)get_store().find_attribute_user(ID$14);
                if (target == null)
                {
                    target = (org.apache.xmlbeans.XmlLong)get_store().add_attribute_user(ID$14);
                }
                target.set(id);
            }
        }
    }
}
