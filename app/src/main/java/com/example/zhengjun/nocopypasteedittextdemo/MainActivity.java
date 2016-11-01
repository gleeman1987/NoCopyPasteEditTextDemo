package com.example.zhengjun.nocopypasteedittextdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(MainActivity.this, "https://github.com/gleeman1987/NoCopyPasteEditTextDemo/tree/", Toast.LENGTH_SHORT).show();
    }
}
