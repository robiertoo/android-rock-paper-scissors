package com.robiertoo.pedrapapeltesoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView txtResult;
    private ImageView imgAppChoice;
    private ImageView imgChoiceRock;
    private ImageView imgChoicePaper;
    private ImageView imgChoiceScissors;
    private List<String> choices = Arrays.asList(
            "Rock",
            "Paper",
            "Scissors"
    );
    private String lastAppChoice = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtResult = findViewById(R.id.txt_result);
        imgAppChoice = findViewById(R.id.img_app_choice);
        imgChoiceRock = findViewById(R.id.img_choice_rock);
        imgChoicePaper = findViewById(R.id.img_choice_paper);
        imgChoiceScissors = findViewById(R.id.img_choice_scissors);

        imgChoicePaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected("Paper");
            }
        });

        imgChoiceRock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected("Rock");
            }
        });

        imgChoiceScissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setSelected("Scissors");
            }
        });
    }

    private String generateAppChoice() {
        int randomNumber = new Random().nextInt(choices.size());
        imgAppChoice.setImageResource(getAppImage(randomNumber));
        if(choices.get(randomNumber).equals(this.lastAppChoice)) return generateAppChoice();
        return choices.get(randomNumber);
    }

    private int getAppImage(int number) {
        if(number == 0) return R.drawable.pedra;
        if(number == 1) return R.drawable.papel;
        return R.drawable.tesoura;
    }

    private void setSelected(String userChoice) {
        String appChoice = generateAppChoice();
        switch (userChoice) {
            case "Paper":
                if(appChoice.equals("Paper")) txtResult.setText("Empate!");
                if(appChoice.equals("Rock")) txtResult.setText("Ganhou!");
                if(appChoice.equals("Scissors")) txtResult.setText("Perdeu!");
                break;
            case "Rock":
                if(appChoice.equals("Paper")) txtResult.setText("Perdeu!");
                if(appChoice.equals("Rock")) txtResult.setText("Empate!");
                if(appChoice.equals("Scissors")) txtResult.setText("Ganhou!");
                break;
            case "Scissors":
                if(appChoice.equals("Paper")) txtResult.setText("Ganhou!");
                if(appChoice.equals("Rock")) txtResult.setText("Perdeu!");
                if(appChoice.equals("Scissors")) txtResult.setText("Empate!");
                break;
            default:
                break;
        }
        lastAppChoice = appChoice;
    }
}