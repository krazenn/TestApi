package com.example.krazenn.testapi.Controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.krazenn.testapi.Fragment.MainFragment;
import com.example.krazenn.testapi.R;

public class MainActivity extends AppCompatActivity {

    private MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.configureAndShowMainFragment();
    }

    // -------------------
    // CONFIGURATION
    // -------------------

    private void configureAndShowMainFragment(){

        mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.activity_main_frame_layout);

        if (mainFragment == null) {
            mainFragment = new MainFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.activity_main_frame_layout, mainFragment)
                    .commit();
        }
    }
}