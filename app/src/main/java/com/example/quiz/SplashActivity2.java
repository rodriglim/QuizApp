package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.Objects;

public class SplashActivity2 extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash2);

        imageButton = findViewById(R.id.imageButton);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationClass animationClass = new AnimationClass();
                animationClass.setButton(imageButton);
                Intent intent = new Intent(getApplicationContext(), SplashActivity3.class);
                startActivity(intent);
            }
        });

    }
}