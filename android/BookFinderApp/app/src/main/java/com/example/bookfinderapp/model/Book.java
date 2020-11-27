package com.example.bookfinderapp.model;

public class Book {
    private int id;
    private String title;
    private int picture;
    private String author;
    private String description;
    private String terbitan;
    private int isbn;
    private String language;
    private String penerbit;
    private int weight;
    private int page;

    public Book(
            int id,
            String title,
            int picture,
            String author,
            String description,
            String terbitan,
            int isbn,
            String language,
            String penerbit,
            int weight,
            int page)
    {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.author = author;
        this.description = description;
        this.terbitan = terbitan;
        this.isbn = isbn;
        this.language = language;
        this.penerbit = penerbit;
        this.weight = weight;
        this.page = page;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerbitan() {
        return terbitan;
    }

    public void setTerbitan(String terbitan) {
        this.terbitan = terbitan;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPenerbit() {
        return penerbit;
    }

    public void setPenerbit(String penerbit) {
        this.penerbit = penerbit;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
