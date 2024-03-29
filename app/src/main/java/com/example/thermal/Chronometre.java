package com.example.thermal;

public class Chronometre {
    private long tempsDepart = 0;
    private long tempsFin = 0;
    private long pauseDepart = 0;
    private long pauseFin = 0;
    private long duree = 0;

    public void start() {
        if (tempsDepart > 0) return;
        tempsDepart = System.currentTimeMillis();
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }

    public void pause() {
        if (tempsDepart == 0) return;
        pauseDepart = System.currentTimeMillis();
    }

    public void resume() {
        if (tempsDepart == 0) return;
        if (pauseDepart == 0) return;
        pauseFin = System.currentTimeMillis();
        tempsDepart = tempsDepart + pauseFin - pauseDepart;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
        duree = 0;
    }

    public void stop() {
        if (tempsDepart == 0) return;
        tempsFin = System.currentTimeMillis();
        duree = (tempsFin - tempsDepart) - (pauseFin - pauseDepart);
        tempsDepart = 0;
        tempsFin = 0;
        pauseDepart = 0;
        pauseFin = 0;
    }

    public long getDureeSec() {
        return duree/1000;
    }

    public long getDureeMs() {
        return duree;
    }

    public String getDureeTxt() {
        return timeToHMS(getDureeSec());
    }

    // Affichage du temps au format 00h00min00s
    public static String timeToHMS(long tempsS) {
        int h = (int) (tempsS / 3600);
        int m = (int) ((tempsS % 3600) / 60);
        int s = (int) (tempsS % 60);

        String r = "";

        if (h > 0) {
            r += h + "h";
        }

        if (m > 0) {
            r += m + "min";
        }

        if (s > 0) {
            r += s + "s";
        }

        if (h <= 0 && m <= 0 && s <= 0) {
            r = "0s";
        }

        return r;
    }

    // Conversion de la durée en seconde
    public static long getConvertSec(long laDuree) {
        return laDuree/1000;
    }
}