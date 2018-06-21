package com.caveofprogramming.section2.lecture63.implementingiterators;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Iterator;
import java.util.LinkedList;

public class UrlLibrary implements Iterable<String> {

    private LinkedList<String> urls = new LinkedList<>();

    private class UrlIterator implements Iterator<String> {

        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < urls.size();
        }

        @Override
        public String next() {
            StringBuilder sBuilder = new StringBuilder();
            try {
                URL url = new URL(urls.get(index));
                BufferedReader bReader = new BufferedReader(new InputStreamReader(url.openStream()));
                String line = null;
                while ((line = bReader.readLine()) != null) {
                    sBuilder.append(line);
                    sBuilder.append("\n");
                    bReader.close();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            index++;
            return sBuilder.toString();
        }

        @Override
        public void remove() {
            urls.remove(index);
        }

    }

    public UrlLibrary() {
        this.urls.add("www.google.com.tr");
        this.urls.add("www.caveofprogramming.com.tr");
        this.urls.add("www.facebook.com");
    }

    @Override
    public Iterator<String> iterator() {
        return new UrlIterator();
    }

}
