package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class QuestionActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView questaoA, questaoB, questaoC, questaoD, tempoView, questaoView;

    int score = 0;
    int totalQuestao = Questoes.questoes.length;
    int questaoIndice = 0;
    String alternativaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(this.getSupportActionBar()).hide();

        questaoView = findViewById(R.id.questao);
        tempoView = findViewById(R.id.tempo);
        questaoA = findViewById(R.id.questaoA);
        questaoB = findViewById(R.id.questaoB);
        questaoC = findViewById(R.id.questaoC);
        questaoD = findViewById(R.id.questaoD);

        questaoA.setOnClickListener(this);
        questaoB.setOnClickListener(this);
        questaoC.setOnClickListener(this);
        questaoD.setOnClickListener(this);

        startTime();
        carregarNovaQuestao();

    }

    @Override
    public void onClick(View view) {
        TextView button = (TextView) view;

        alternativaSelecionada = button.getText().toString();

        if(alternativaSelecionada.equals(Questoes.resposta[questaoIndice])){
            score++;
        }

        questaoIndice++;
        carregarNovaQuestao();
    }

    private void carregarNovaQuestao() {

        if(questaoIndice == totalQuestao){
            alertMessage();
           if(totalScore()){
               getIntent(VencedorActivity.class);
           }else{
               getIntent(DerrotaActivity.class);
           }
        }

        questaoView.setText(Questoes.questoes[questaoIndice]);
        questaoA.setText(Questoes.alternativas[questaoIndice][0]);
        questaoB.setText(Questoes.alternativas[questaoIndice][1]);
        questaoC.setText(Questoes.alternativas[questaoIndice][2]);
        questaoD.setText(Questoes.alternativas[questaoIndice][3]);

    }

    private void alertMessage(){
        Toast.makeText(this, "Pontuação\n "+  score + " / " + totalQuestao, Toast.LENGTH_SHORT).show();
    }
    private void  getIntent(Class name){
        Intent intent = new Intent(getApplicationContext(), name);
        startActivity(intent);
    }

    private void returnAcabouTempo(){
        getIntent(DerrotaActivity.class);
    }

    private boolean totalScore(){
        boolean vitoria = false;
        if(score > totalQuestao*0.60){
            vitoria = true;
        }

        return vitoria;
    }

    public void startTime(){
        new CountDownTimer(45000, 1000){

            @Override
            public void onTick(long l) {
                tempoView.setText(l/1000 + "s");
            }

            @Override
            public void onFinish() {
               returnAcabouTempo();
            }
        }.start();
    }
}