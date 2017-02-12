package sonde.Composants;

import interfaceswcomp.AcquisitionFailure;

/**
 * Created by Jaafar on 03/02/2017.
 */
public class Sonde implements Runnable {

    private GestionAgent gestionAgent;
    private GestionComposant gestionComposant;
    private PeriodiciterSondage periodiciterSondage;

    @Override
    public void run() {
        //gestionAgent = new GestionAgent();
        gestionComposant = new GestionComposant();
        periodiciterSondage = new PeriodiciterSondage();
        periodiciterSondage.setVisible(true);
        while(true) {
            try {
                gestionComposant.getComposantApparu();
                gestionComposant.getComposantDisparu();
                Thread.sleep(gestionComposant.getPeriodicite());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            catch (AcquisitionFailure e) {
                e.printStackTrace();
            }
        }
    }
}
