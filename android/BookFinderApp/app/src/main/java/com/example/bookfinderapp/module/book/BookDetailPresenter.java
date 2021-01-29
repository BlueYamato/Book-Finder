package com.example.bookfinderapp.module.book;

import android.util.Log;

import com.example.bookfinderapp.api.ApiClient;
import com.example.bookfinderapp.api.ApiInterface;
import com.example.bookfinderapp.model.Book;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookDetailPresenter {
    private BookDetailView view;

    private ApiInterface api ;

    BookDetailPresenter(BookDetailView view){
        this.view = view;
        this.api = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getAllBook(){
//        Call<List<Book>> call = api.getBooks();
        Call<Book> call = api.testBooks();
        call.enqueue(
                new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Log.e("Test API", "on Response "+response.body());
                        Book book = response.body();
                        Log.e("Test API", "on Response "+book.getAuthor());
                        Log.e("Test API", "on Response "+book.getTitle());
                        Log.e("Test API", "on Response "+book.getLanguage());
                        Log.e("Test API", "on Response "+book.getDescription());
                        view.onGetSuccess(book);
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Log.i("Test API", "on Failure "+t.getLocalizedMessage());
                    }
                }
        );
    }

    public void getBookByTitle(String base64){
//        Call<List<Book>> call = api.getBooks();
        Call<Book> call = api.postBook(base64);
        call.enqueue(
                new Callback<Book>() {
                    @Override
                    public void onResponse(Call<Book> call, Response<Book> response) {
                        Log.e("Test API", "on Response "+response.body());
                        Book book = response.body();
                        Log.e("Test API", "on Response "+book.getAuthor());
                        Log.e("Test API", "on Response "+book.getTitle());
                        Log.e("Test API", "on Response "+book.getLanguage());
                        Log.e("Test API", "on Response "+book.getDescription());
                        view.onGetSuccess(book);
                    }

                    @Override
                    public void onFailure(Call<Book> call, Throwable t) {
                        Log.i("Test API", "on Failure "+t.getLocalizedMessage());
                    }
                }
        );
    }
}
