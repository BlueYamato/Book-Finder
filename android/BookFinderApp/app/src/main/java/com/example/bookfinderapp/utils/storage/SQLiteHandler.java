package com.example.bookfinderapp.utils.storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bookfinderapp.model.Book;
import com.example.bookfinderapp.model.BookList;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SQLiteHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "book.db";

    private static final String TABLE_CONTACTS = "Book";
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_PICTURE = "picture";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_TERBITAN = "terbitan";
    private static final String KEY_ISBN = "isbn";
    private static final String KEY_LANGUAGE = "language";
    private static final String KEY_PENERBIT = "penerbit";
    private static final String KEY_PAGE = "page";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_IMAGE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("

                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_TITLE + " VARCHAR(10000),"
                + KEY_PICTURE + " TEXT,"
                + KEY_AUTHOR + " TEXT,"
                + KEY_DESCRIPTION + " TEXT,"
                + KEY_TERBITAN + " TEXT,"
                + KEY_ISBN + " INTEGER,"
                + KEY_LANGUAGE + " TEXT,"
                + KEY_PENERBIT + " TEXT,"
                + KEY_PAGE + " INTEGER" + ")";
        db.execSQL(CREATE_IMAGE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addBookData(Book book) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, book.getId());
        values.put(KEY_TITLE, book.getTitle());
        values.put(KEY_PICTURE, book.getPicture());
        values.put(KEY_AUTHOR, book.getAuthor());
        values.put(KEY_DESCRIPTION, book.getDescription());
        values.put(KEY_TERBITAN, book.getTerbitan());
        values.put(KEY_ISBN, book.getIsbn());
        values.put(KEY_LANGUAGE, book.getLanguage());
        values.put(KEY_PENERBIT, book.getPenerbit());
        values.put(KEY_PAGE, book.getPage());

        db.insert(TABLE_CONTACTS, null, values);

        db.close();

    }

    public Book getBook(String bookName) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[]{
                        KEY_ID, KEY_TITLE, KEY_PICTURE, KEY_AUTHOR, KEY_DESCRIPTION, KEY_TERBITAN, KEY_ISBN, KEY_LANGUAGE, KEY_PENERBIT, KEY_PAGE
                }, KEY_TITLE + "=?",

                new String[]{String.valueOf(bookName)}, null, null, null, null);

        if (cursor != null)

            cursor.moveToFirst();

        Book book = new Book(
                cursor.getInt(0),
                cursor.getString(1),
                cursor.getString(2),
                cursor.getString(3),
                cursor.getString(4),
                cursor.getString(5),
                cursor.getString(6),
                cursor.getString(7),
                cursor.getString(8),
                cursor.getInt(9)
        );
        return book;

    }

    public ArrayList<BookList> getAllBooks() {

        ArrayList<BookList> books = new ArrayList<BookList>();

        String selectQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                BookList bookList = new BookList(
                        cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                );

                books.add(bookList);

            } while (cursor.moveToNext());

        }

        db.close();
        return books;
    }

    public void deleteBook(String bookName) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CONTACTS, KEY_TITLE + " = ?",
                new String[]{bookName});
        db.close();

    }

    public int getDataBook() {

        String countQuery = "SELECT * FROM " + TABLE_CONTACTS;

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(countQuery, null);

        cursor.close();

        return cursor.getCount();

    }

   /* public boolean checkIfPathExistInDB(String path){
        String query = "SELECT * FROM "+TABLE_CONTACTS+" WHERE path = '" + path + "'";

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        return cursor.getCount() > 0;
    }*/
}

