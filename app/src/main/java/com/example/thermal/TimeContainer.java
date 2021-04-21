package com.example.thermal;

import android.content.Context;

import java.io.Serializable;

import androidx.appcompat.app.AlertDialog;

public class TimeContainer implements Serializable {
    public TimeContainer(){

    }

    public long allDureeChrono = 0; // en MS

    public void addTemps(long dureeChronometre) {
        allDureeChrono = dureeChronometre + allDureeChrono;
    }

    public long getDuree() {
        return allDureeChrono;
    }

    protected void getMessageEntretien(Context membre){
        if (getDuree() >= 2000){
            AlertDialog.Builder builder = new AlertDialog.Builder(membre);
            builder.setMessage("Ça fait 30h, votre machine nécessite un entretien !");
            builder.show();
        }
    }
}
