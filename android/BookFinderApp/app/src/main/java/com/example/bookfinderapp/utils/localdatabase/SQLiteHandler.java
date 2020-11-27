package com.example.bookfinderapp.utils.localdatabase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.bookfinderapp.model.Book;

import java.util.LinkedList;
import java.util.List;

//public class SQLiteHandler{
//
//}
public class SQLiteHandler extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "book.db";

    private static final String TABLE_CONTACTS = "BookDetail";
    private static final String KEY_ID = "ID_Book" ;
    private static final String KEY_NAME = "title";
    private static final String KEY_PIC = "picture";
    private static final String KEY_AUTHOR = "author";
    private static final String KEY_DESC = "description";
    private static final String KEY_TRBT = "terbitan";
    private static final String KEY_ISBN = "isbn";
    private static final String KEY_LANG = "language";
    private static final String KEY_PNBT = "penerbit";
    private static final String KEY_WEIGHT = "weight";
    private static final String KEY_PAGE = "page";

    public SQLiteHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_IMAGE_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "("

                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_PIC + " TEXT," + KEY_AUTHOR + " TEXT,"
                + KEY_DESC + " TEXT," + KEY_TRBT + " TEXT,"
                + KEY_ISBN + " INTEGER," + KEY_LANG + " TEXT,"
                + KEY_PNBT + " TEXT," + KEY_WEIGHT + " INTEGER,"
                + KEY_PAGE + " INTEGER"+ ")";
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

    public void addBook(Book book) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, book.getId()); //0
        values.put(KEY_NAME, book.getTitle()); //1
        values.put(KEY_PIC, book.getPicture()); //2
        values.put(KEY_AUTHOR, book.getAuthor()); //3
        values.put(KEY_DESC, book.getDescription()); //4
        values.put(KEY_TRBT, book.getTerbitan()); //5
        values.put(KEY_ISBN, book.getIsbn()); //6
        values.put(KEY_LANG, book.getLanguage());
        values.put(KEY_PNBT, book.getPenerbit());
        values.put(KEY_WEIGHT, book.getWeight());
        values.put(KEY_PAGE, book.getPage());

        db.insert(TABLE_CONTACTS, null, values);

        db.close();

    }

    public Book getBook(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS,
                new String[] { KEY_ID, KEY_NAME,KEY_PIC,KEY_AUTHOR,KEY_DESC,KEY_TRBT,KEY_ISBN,KEY_LANG,KEY_PNBT,KEY_WEIGHT,KEY_PAGE}
                , KEY_ID + "=?",

                new String[] { String.valueOf(id) }, null, null, null, null);

        if (cursor != null)

            cursor.moveToFirst();

        Book book = new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)
                ,cursor.getString(3),cursor.getString(4),cursor.getString(5)
                ,cursor.getInt(6),cursor.getString(7),cursor.getString(8)
                ,cursor.getInt(9),cursor.getInt(10));
        return book;

    }

    public List<Book> getAllBook() {

        List<Book> bookList = new LinkedList<Book>();

        String selectQuery = "SELECT * FROM "+TABLE_CONTACTS;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {

            do {

                Book book = new Book(cursor.getInt(0),cursor.getString(1),cursor.getInt(2)
                        ,cursor.getString(3),cursor.getString(4),cursor.getString(5)
                        ,cursor.getInt(6),cursor.getString(7),cursor.getString(8)
                        ,cursor.getInt(9),cursor.getInt(10));

                bookList.add(book);

            } while (cursor.moveToNext());

        }

        db.close();
        return bookList;
    }

//    public List<Book> getAllBook(String title) {
//
//        List<Book> imageList = new LinkedList<Book>();
//
//        String selectQuery = "SELECT * FROM "+TABLE_CONTACTS+" WHERE "+KEY_STUDY+" = '" + pelajaran +"'";
//
//        SQLiteDatabase db = this.getWritableDatabase();
//
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//
//            do {
//
//                Pengajar pengajar = new Pengajar(cursor.getString(1)
//                        ,cursor.getString(2));
//
//                imageList.add(pengajar);
//
//            } while (cursor.moveToNext());
//
//        }
//
//        db.close();
//        return imageList;
//    }
  /*  public int updateImageData(Pengajar pengajar,String judulLama) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, image.getJudul());
        values.put(KEY_NOTE, image.getNote());
        return db.update(TABLE_CONTACTS, values, KEY_PATH + " = ?",
                new String[] { image.getPath() });
    }*/

    public void deleteBook(String nama) {

        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(TABLE_CONTACTS, KEY_ID + " = ?",
                new String[] { nama });
        db.close();

    }

    public int getBookData() {

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