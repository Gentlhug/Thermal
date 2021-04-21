package com.example.thermal;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class TimeContainer {
    protected Context membre;
    public TimeContainer(Context context){
        this.membre = context;
    }

    public long allDureeChrono = 0; // en MS

    public void addTemps(long dureeChronometre) {
        allDureeChrono = dureeChronometre + allDureeChrono;
    }

    public long getDuree() {
        return allDureeChrono;
    }

    protected void getMessageEntretien(){
        if (getDuree() >= 2000){
            AlertDialog.Builder builder = new AlertDialog.Builder(membre);
            builder.setMessage("Ça fait 30h, votre machine nécessite un entretien !");
            builder.show();
        }
    }
}
