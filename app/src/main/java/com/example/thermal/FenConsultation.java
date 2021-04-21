package com.example.thermal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FenConsultation extends AppCompatActivity {

    public FenChronometre time;
    public TimeContainer consultation;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_consultation);

        time = new FenChronometre();
        consultation = Main.getTime();

        final TextView affichageDuree = (TextView) findViewById(R.id.valeurDuree);
        if (consultation.getDuree() != 0){
            affichageDuree.setText(Chronometre.timeToHMS(Chronometre.getConvertSec(consultation.getDuree())));
        } else {
            affichageDuree.setText("Aucune données à afficher !");
        }

        ProgressBar barEntretien = (ProgressBar) findViewById(R.id.progressBarEntretien);
        barEntretien.setMax(108000000);
        barEntretien.setProgress(Math.toIntExact(consultation.getDureeEntretien()));
    }


}