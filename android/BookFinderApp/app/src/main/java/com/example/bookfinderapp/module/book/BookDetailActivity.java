package com.example.bookfinderapp.module.book;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Base64;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookfinderapp.R;
import com.example.bookfinderapp.model.Book;
import com.example.bookfinderapp.module.camera.AndroidCamera;
import com.example.bookfinderapp.utils.autoresizetextview.AutoResizeTextView;
import com.example.bookfinderapp.utils.storage.SQLiteHandler;

import java.io.ByteArrayOutputStream;

import androidx.appcompat.app.AppCompatActivity;

public class BookDetailActivity extends AppCompatActivity implements BookDetailView{

    private BookDetailPresenter presenter;
    private String bookData = null;
    private String TAG = "check";

    private ImageView ivImage;
    private AutoResizeTextView tvTitle;
    private AutoResizeTextView tvAuthor;
    private AutoResizeTextView tvDate;
    private AutoResizeTextView tvIsbn;
    private AutoResizeTextView tvLang;
    private AutoResizeTextView tvPub;
    private AutoResizeTextView tvPage;
    private TextView tvDesc;

    private SQLiteHandler sqLiteHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_activity);

        presenter = new BookDetailPresenter(this);
        sqLiteHandler = new SQLiteHandler(this);
        bookData = Environment.getExternalStorageDirectory()+"/pic.jpg";

        this.ivImage = findViewById(R.id.iv_book);
        this.tvTitle = findViewById(R.id.tv_title);
        this.tvAuthor = findViewById(R.id.tv_author);
        this.tvDate = findViewById(R.id.tv_date);
        this.tvIsbn = findViewById(R.id.tv_isbn);
        this.tvLang = findViewById(R.id.tv_language);
        this.tvPub = findViewById(R.id.tv_publisher);
        this.tvPage = findViewById(R.id.tv_page);
        this.tvDesc = findViewById(R.id.tv_desc);

        Bitmap bm = BitmapFactory.decodeFile(bookData);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos); // bm is the bitmap object
        byte[] b = baos.toByteArray();
        String encodedImage = Base64.encodeToString(b, Base64.URL_SAFE);
        String data = encodedImage;

        Log.d(TAG,encodedImage);

        presenter.getBookByTitle(data);
//        Intent intent = getIntent();
//
//        bookData = intent.getStringExtra("picture");
//        if(bookData!=null){
//            Log.d(TAG,bookData);
//        }


//        presenter = new BookDetailPresenter(this);

    }

    @Override
    public void onGetSuccess(Book book) {

        Log.e("Test API", "on getSuccess "+book.getTitle());
        Log.e("Test API", "on getSuccess "+ivImage.getId());

        byte[] decodedString = Base64.decode(book.getPicture(), Base64.DEFAULT);
        Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
        ivImage.setImageBitmap(decodedByte);

        tvTitle.setText(book.getTitle());
        tvAuthor.setText(book.getAuthor());
        tvDate.setText(book.getTerbitan());
        tvIsbn.setText(book.getIsbn());
        tvPub.setText(book.getPenerbit());
        tvLang.setText(book.getLanguage());
        tvPage.setText(String.valueOf(book.getPage()));
        tvDesc.setText(book.getDescription());

        sqLiteHandler.addBookData(book);
    }
}
