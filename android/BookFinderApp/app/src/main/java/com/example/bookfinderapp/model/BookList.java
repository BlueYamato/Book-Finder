package com.example.bookfinderapp.model;

public class BookList {

    private int id;
    private String title;
    private int picture;
    private String author;

    public BookList(int id, String title,int picture,String author){
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
