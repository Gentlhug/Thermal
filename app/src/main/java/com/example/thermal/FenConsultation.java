package com.example.thermal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FenConsultation extends AppCompatActivity {

    public FenChronometre time;
    public TimeContainer consultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_consultation);

        time = new FenChronometre();
        consultation = (TimeContainer) getIntent().getSerializableExtra("Consultation");

        final TextView affichageDuree = (TextView) findViewById(R.id.valeurDuree);
        if (consultation.getDuree() != 0){
            affichageDuree.setText(Chronometre.timeToHMS(Chronometre.getConvertSec(consultation.getDuree())));
        } else {
            affichageDuree.setText("Aucune données à afficher !");
        }
    }


}