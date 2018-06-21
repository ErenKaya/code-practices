
package com.caveofprogramming.section.lecture52.passingbyvalue;


public class Person {
    private String personName;

    public Person(String personName) {
        this.personName = personName;
    }

    public Person() {
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person[name="+personName+"]";
    }
    

}
