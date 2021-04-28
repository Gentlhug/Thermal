package com.example.thermal;

import android.content.Context;

import androidx.appcompat.app.AlertDialog;

public class TimeContainer {

    public long allDureeChrono = 0; // en MS
    public long entretien = 0;

    public void addTemps(long dureeChronometre) {
        allDureeChrono = dureeChronometre + allDureeChrono;
        entretien = dureeChronometre + entretien;
    }

    public long getDuree() {
        return allDureeChrono;
    }

    public long getDureeEntretien(){
        return entretien;
    }

    public boolean isMaintenanceRequested(){
        if (entretien >= 108000000){
            return true;
        }
        return false;
    }

    public void restMaintenance(){
        entretien = 0;
    }
}