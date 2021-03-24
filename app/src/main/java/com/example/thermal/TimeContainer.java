package com.example.thermal;

public class TimeContainer {
    public long allDureeChrono = 0;

    public void addTemps(long dureeChronometre) {
        allDureeChrono = dureeChronometre + allDureeChrono;
    }

    public long getDuree() {
        return allDureeChrono;
    }
}
