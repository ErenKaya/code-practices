
package com.caveofprogramming.section2.lecture60.naturalorder;

import java.util.Objects;


public class Person implements Comparable<Person>{
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "{" + "Person name is=" + personName + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.personName);
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
        if (!Objects.equals(this.personName, other.personName)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int compareTo(Person person) {
        int firstLength = personName.length();
        int secLength = person.personName.length();
        if(firstLength>secLength){
            return 1;
        }else if (firstLength<secLength){
            return -1;
        }else{
            return personName.compareTo(person.personName);
        }
    }
    
}
