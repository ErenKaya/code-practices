
package com.caveofprogramming.section.lecture25;


public class Frog {
    private long frogId;
    private String frogName;

    public Frog(long frogId, String frogName) {
        this.frogId = frogId;
        this.frogName = frogName;
    }
    
    
    @Override
    public String toString(){
        
        return String.format("%-2d name is: %s", frogId,frogName);
    }

}
