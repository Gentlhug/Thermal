package com.example.thermal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class FenChronometre extends AppCompatActivity {

    // Variables
    public int numClicButton = 0;
    public int renit = 1;
    public long dureeChrono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fen_chronometre);

        // Chronometre
        final Chronometer chronoAffichage = (Chronometer) findViewById(R.id.chronometre);


        // Bouton Start
        final Button boutonStart = (Button) findViewById(R.id.buttonStart);
        boutonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronoAffichage.setBase(SystemClock.elapsedRealtime());
                chronoAffichage.start();
                boutonStart.setEnabled(false);
            }
        });

        // Bouton Pause
        final Button boutonStop = (Button) findViewById(R.id.buttonStop);
        boutonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    dureeChrono = SystemClock.elapsedRealtime() - chronoAffichage.getBase();
                    chronoAffichage.stop();
                    boutonStart.setEnabled(true);
                    // Snackbar
                    Snackbar.make(view, "Temps : " + dureeChrono/1000 + "s", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
            }
        });
    }
}