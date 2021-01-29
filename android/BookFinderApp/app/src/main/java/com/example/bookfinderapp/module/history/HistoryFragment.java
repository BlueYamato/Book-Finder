package com.example.bookfinderapp.module.history;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bookfinderapp.FragmentListener;
import com.example.bookfinderapp.R;
import com.example.bookfinderapp.model.Book;
import com.example.bookfinderapp.model.BookList;
import com.example.bookfinderapp.utils.storage.SQLiteHandler;

import java.util.ArrayList;

public class HistoryFragment extends Fragment implements View.OnClickListener {

    private Button btnCamera;
    private Button btnHistory;
    private FragmentListener listener;

    private HistoryRecycleAdapter adapter;
    private ArrayList<BookList> bookLists = new ArrayList<>();
    private RecyclerView recycler;

    private SQLiteHandler sqLiteHandler;

    public HistoryFragment(){

    }

    public static HistoryFragment newInstance(String title){
        HistoryFragment fragment = new HistoryFragment();

        Bundle args = new Bundle();
        args.putString("title",title);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        if(context instanceof FragmentListener){
            this.listener = (FragmentListener) context;
        }
        else{
            throw new ClassCastException(context.toString()+" must implement FragmentListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View root = inflater.inflate(R.layout.fragment_history, container, false);

        recycler = root.findViewById(R.id.rv_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recycler.setLayoutManager(layoutManager);
        adapter = new HistoryRecycleAdapter(bookLists, this.getContext());
        recycler.setAdapter(adapter);
        sqLiteHandler = new SQLiteHandler(this.getContext());

        bookLists = (ArrayList<BookList>) sqLiteHandler.getAllBooks();
        Log.d("checkdata"," the size "+bookLists.size());
//        bookLists.add(new BookList(1, "a",2323232,"john"));
//        bookLists.add(new BookList(2, "b",2323232,"john"));
//        bookLists.add(new BookList(3, "c",2323232,"john"));



        adapter.notifyDataSetChanged();

        return root;
    }

    @Override
    public void onClick(View view) {

    }
}