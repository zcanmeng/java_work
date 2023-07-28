package com.cm.collectionwork.homework01;

public class News {
    private String title;
    private String context;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public News(String title, String context) {
        this.title = title;
        this.context = context;
    }

    public News() {
    }

    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
