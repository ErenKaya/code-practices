package io.erenkaya.spring._01_restservice;

public class Greetings {
    private final long id;
    private final String content;

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Greetings(long id, String content) {
        this.id = id;
        this.content = content;
    }
}