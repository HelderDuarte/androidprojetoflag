package com.example.developer.fragmentos.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.developer.fragmentos.fragment.MainFragment;
import com.example.developer.fragmentos.R;
import com.example.developer.fragmentos.fragment.SegundoFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.Callback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = new MainFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container_fragment,mainFragment,"Main");
        mainFragment.connect(this);
        fragmentTransaction.commit();
    }

    @Override
    public void onclick(String msg) {
        Log.v("MAIN",msg);
        replaceFragment(msg);
    }

    private void replaceFragment(String msg){
        SegundoFragment segundoFragment = new SegundoFragment();

        Bundle args = new Bundle();
        args.putString("SEGUNDO",msg);
        segundoFragment.setArguments(args);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container_fragment,segundoFragment,"Segundo");
        fragmentTransaction.addToBackStack("Main");
        fragmentTransaction.commit();
    }


}
