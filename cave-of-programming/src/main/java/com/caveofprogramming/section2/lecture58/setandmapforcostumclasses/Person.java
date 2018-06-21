
package com.caveofprogramming.section2.lecture58.setandmapforcostumclasses;

import java.util.Objects;


public class Person {
    private int personId;
    private String personName;

    public Person(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "{" + "Person ID is=" + personId + ", Person Name is=" + personName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + this.personId;
        hash = 89 * hash + Objects.hashCode(this.personName);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (this.personId != other.personId) {
            return false;
        }
        if (!Objects.equals(this.personName, other.personName)) {
            return false;
        }
        return true;
    }
    

}
