package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

import java.util.Objects;

public class SplashActivity3 extends AppCompatActivity {

    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash3);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        imageButton = findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AnimationClass animationClass = new AnimationClass();
                animationClass.setButton(imageButton);
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                startActivity(intent);
            }
        });
    }
}