package sonde.Composants;

import sonde.Services.Configuration;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class GestionAgent implements Configuration{

    //Périodicité du sondage
    private int periodicite;
    @Override
    public void definirPeriodicite(int valeur) {
        this.periodicite = valeur;
    }
}
