package com.example.thermal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class FenConsultation extends AppCompatActivity {

    public FenChronometre time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_consultation);



        final TextView affichageDuree = (TextView) findViewById(R.id.valeurDuree);
        affichageDuree.setText(FenChronometre.getTime());
    }


}