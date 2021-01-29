package com.example.bookfinderapp.module.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.bookfinderapp.FragmentListener;
import com.example.bookfinderapp.R;
import com.example.bookfinderapp.module.book.BookDetailActivity;
import com.example.bookfinderapp.module.camera.AndroidCamera;
import com.example.bookfinderapp.module.camera.AndroidCameraApi;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btnCamera;
    private Button btnHistory;
    private FragmentListener listener;

    public HomeFragment(){

    }

    public static HomeFragment newInstance(String title){
        HomeFragment fragment = new HomeFragment();

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
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        btnCamera = root.findViewById(R.id.btn_find_book);
        btnHistory = root.findViewById(R.id.btn_history);

        btnCamera.setOnClickListener(this);
        btnHistory.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View view) {

        if(view.getId()==btnCamera.getId()){
            Intent cameraIntent = new Intent(getActivity(), AndroidCameraApi.class);
            startActivity(cameraIntent);
        }else{
            this.listener.setFragment(1);
//            Intent bookIntent = new Intent(getActivity(), BookDetailActivity.class);
//            startActivity(bookIntent);
        }

    }
}

