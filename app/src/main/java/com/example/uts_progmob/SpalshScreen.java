package com.example.uts_progmob;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SpalshScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spalsh_screen);
    }

    public void KlickME(View view) {
        Intent intent = new Intent(SpalshScreen.this, LoginScreen.class);
        startActivity(intent);
    }
}
