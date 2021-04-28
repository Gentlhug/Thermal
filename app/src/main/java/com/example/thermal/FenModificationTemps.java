package com.example.thermal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FenModificationTemps extends AppCompatActivity {

    public Editable leTempsUtilisation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fen_modification_temps);

        final EditText tempsUtilisation = (EditText) findViewById(R.id.tempsUtilisation);

        final Button boutonEntrer = (Button) findViewById(R.id.boutonEntrer);
        boutonEntrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                leTempsUtilisation = tempsUtilisation.getText();
            }
        });
    }

    public Editable getTempsUtilisation(){
        return leTempsUtilisation;
    }
}