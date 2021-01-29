package com.example.bookfinderapp.model;

public class Book {
    private int id;
    private String title;
    private String picture;
    private String author;
    private String description;
    private String terbitan;
    private String isbn;
    private String language;
    private String penerbit;
    private int page;

    public Book(
            int id,
            String title,
            String picture,
            String author,
            String description,
            String terbitan,
            String isbn,
            String language,
            String penerbit,
            int page) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.author = author;
        this.description = description;
        this.terbitan = terbitan;
        this.isbn = isbn;
        this.language = language;
        this.penerbit = penerbit;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
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

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}
