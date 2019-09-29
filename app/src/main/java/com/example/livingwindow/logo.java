package com.example.livingwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.livingwindow.ui.logo.LogoFragment;

public class logo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, LogoFragment.newInstance())
                    .commitNow();
        }
    }
}
