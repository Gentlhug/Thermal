package com.example.thermal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.google.android.material.snackbar.Snackbar;

public class FenChronometre extends AppCompatActivity {

    // Variables
    public int numClicButton = 0;
    public int renit = 1;
    public long dureeChrono;
    public String resultTempsChrono;
    public static TimeContainer consultation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_chronometre);

        // Chronometre
        final Chronometer chronoAffichage = (Chronometer) findViewById(R.id.chronometre);

        final Button boutonStart = (Button) findViewById(R.id.buttonStart);
        final Button boutonStop = (Button) findViewById(R.id.buttonStop);

        // Bouton Start
        boutonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronoAffichage.setBase(SystemClock.elapsedRealtime());
                chronoAffichage.start();
                boutonStart.setEnabled(false);
                boutonStop.setEnabled(true);
            }
        });

        // Bouton Pause
        boutonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    dureeChrono = SystemClock.elapsedRealtime() - chronoAffichage.getBase();
                    consultation.addTemps(dureeChrono);
                    chronoAffichage.stop();
                    boutonStart.setEnabled(true);
                    boutonStop.setEnabled(false);
                    resultTempsChrono = Chronometre.timeToHMS(Chronometre.getConvertSec(dureeChrono));
                    // Snackbar
                    Snackbar.make(view, "Temps : " + resultTempsChrono, Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
            }
        });
    }

    public static String getTime() {
        return Chronometre.timeToHMS(consultation.getDuree());
    }

}