package com.example.bookfinderapp.module.history;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Picture;
import android.media.Image;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bookfinderapp.R;
import com.example.bookfinderapp.model.BookList;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HistoryRecycleAdapter extends RecyclerView.Adapter<HistoryRecycleAdapter.BookHolder> {

    private ArrayList<BookList> bookLists;
    private Context mContext;


    public HistoryRecycleAdapter(ArrayList<BookList> bookLists, Context context) {
        this.bookLists = bookLists;
        this.mContext = context;
    }

    @Override
    public BookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        // Inflate the layout view you have created for the list rows here
        View view = layoutInflater.inflate(R.layout.rv_history_layout, parent, false);

        return new BookHolder(view);
    }

    @Override
    public int getItemCount() {
        return bookLists == null ? 0 : bookLists.size();
    }

    @Override
    public void onBindViewHolder(@NonNull BookHolder holder, final int position) {
        final BookList books = bookLists.get(position);


        holder.setTitle(books.getTitle());
        holder.setAuthor(books.getAuthor());
        holder.setPicture(books.getPicture());


    }

    public class BookHolder extends RecyclerView.ViewHolder {

        private ImageView picture;
        private TextView tvTitle;
        private TextView tvAuthor;

        public BookHolder(View itemView) {
            super(itemView);

            picture = itemView.findViewById(R.id.iv_booklist);
            tvTitle = itemView.findViewById(R.id.atv_history_title);
            tvAuthor = itemView.findViewById(R.id.atv_history_author);
//            ibDelete = itemView.findViewById(R.id.btn_delete);
        }

        public void setTitle(String title) {
            tvTitle.setText(title);
        }

        public void setAuthor(String author) {
            tvAuthor.setText(author);
        }

        public void setPicture(String picture) {
            byte[] decodedString = Base64.decode(picture, Base64.DEFAULT);
            Bitmap decodedByte = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);
            this.picture.setImageBitmap(decodedByte);
        }

//        public void setPicture(String uri) {
//            picture.setImageURI(uri);
//        }


    }
}
