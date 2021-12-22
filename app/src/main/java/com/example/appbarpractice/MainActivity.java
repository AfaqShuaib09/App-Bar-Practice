package com.example.appbarpractice;

import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Toolbar custom_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        custom_toolbar = (Toolbar) findViewById(R.id.customToolBar);

        setSupportActionBar(custom_toolbar);
    }
}