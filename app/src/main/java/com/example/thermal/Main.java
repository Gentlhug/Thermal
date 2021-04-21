package com.example.thermal;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    private static final int REQUEST_CODE_DETAIL = 1;
    private static final TimeContainer consultation = new TimeContainer();
    private static final Chronometre chrono = new Chronometre();

    public static TimeContainer getTime(){
        return consultation;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        final Button boutonChrono = (Button) findViewById(R.id.chrono);
        boutonChrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activiteChrono = new Intent(Main.this, FenChronometre.class);
                startActivityForResult(activiteChrono, REQUEST_CODE_DETAIL);
            }
        });

        final Button boutonConsultation = (Button) findViewById(R.id.consultation);
        boutonConsultation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent activiteConsultation = new Intent(Main.this, FenConsultation.class);
                startActivityForResult(activiteConsultation, REQUEST_CODE_DETAIL);
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        if (consultation.isMaintenanceRequested()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
            builder.setMessage("Ça fait 30h, votre machine nécessite un entretien !");
            builder.setNegativeButton("Répeter", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.setPositiveButton("Faire l'entretien", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    consultation.restMaintenance();
                }
            });
            builder.show();
        }
    }
}