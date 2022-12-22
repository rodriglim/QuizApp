package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.Objects;

public class VencedorActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vencedor);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(this.getSupportActionBar()).hide();


        Handler handler = new Handler();
        Toast.makeText(this, "Aguarde 3 segundos...", Toast.LENGTH_SHORT).show();
        handler.postDelayed(this, 3000);
    }

    @Override
    public void run() {
        Intent intent = new Intent(getApplicationContext(), SplashActivity2.class);
        startActivity(intent);
    }
}