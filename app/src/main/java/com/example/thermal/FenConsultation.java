package com.example.thermal;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class FenConsultation extends AppCompatActivity {

    public FenChronometre time;
    public TimeContainer consultation;
    private static final int REQUEST_CODE_DETAIL = 1;
    private static final FenModificationTemps usingTime = new FenModificationTemps();

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

        final Button boutonEntrerTemps = (Button) findViewById(R.id.entrerTempsUtilisation);
        boutonEntrerTemps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tempsUtilisation = new Intent(FenConsultation.this, FenModificationTemps.class);
                startActivityForResult(tempsUtilisation, REQUEST_CODE_DETAIL);
            }
        });
    }


}