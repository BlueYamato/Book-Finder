package com.example.bookfinderapp.api;

import com.example.bookfinderapp.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    @POST("/findBook")
    Call<Book> postBook(@Body String picture);

    @GET("/books")
    Call<List<Book>> getBooks();

    @GET("/test")
    Call<Book> testBooks();
}
