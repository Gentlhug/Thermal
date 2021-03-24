package com.example.thermal;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    private static final int REQUEST_CODE_DETAIL = 1;
    private static final TimeContainer consultation = new TimeContainer();

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
}