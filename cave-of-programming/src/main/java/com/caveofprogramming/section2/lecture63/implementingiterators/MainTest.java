
package com.caveofprogramming.section2.lecture63.implementingiterators;


public class MainTest {
    public static void main(String[] args) {
        UrlLibrary urlLibrary=new UrlLibrary();
        for(String html: urlLibrary){
            System.out.println(html.length());
//            System.out.println(html);
        }
    }

}
