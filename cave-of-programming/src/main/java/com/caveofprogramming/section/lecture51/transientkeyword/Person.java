
package com.caveofprogramming.section.lecture51.transientkeyword;

import java.io.Serializable;


public class Person implements Serializable{

    private static final long serialVersionUID = 0b10L;
    private int personId;
    private String personName;
 
    public Person(int personId, String personName) {
        this.personId = personId;
        this.personName = personName;
    }

    @Override
    public String toString() {
        return "Person[id="+personId+" "+"name="+personName+"]";
    }
    
    

}
