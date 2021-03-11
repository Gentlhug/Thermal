package com.example.thermal;

public class TimeContainer {
    public long allDureeChrono;

    public void addTemps(long dureeChronometre) {
        allDureeChrono = dureeChronometre + allDureeChrono;
    }

    public long getDuree() {
        return allDureeChrono;
    }
}
