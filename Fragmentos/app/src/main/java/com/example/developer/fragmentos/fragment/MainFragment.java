package com.example.developer.fragmentos.fragment;


import android.app.Activity;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.developer.fragmentos.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private Button btnNext;
    Callback mCallback;

    public void connect(Activity activity){
        mCallback = (Callback) activity;
    }


    public MainFragment() {
        // Required empty public constructor
    }

    public interface Callback{
        void onclick(String msg);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        btnNext = (Button) view.findViewById(R.id.btn_next);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("FRAGMENT","BTN_NEXT");
                mCallback.onclick("OI Fragment");

            }
        });
        return view;
    }

}
