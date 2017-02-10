package visualisation.implementation;

import visualisation.abstractvisualisation.AbstractAffichage;
import visualisation.interfaces.IStrategieAffichage;

/**
 * Created by alpha on 10/02/2017.
 */
public class Affichage extends AbstractAffichage {
    private IStrategieAffichage stategieAffichage;

    public void afficher () {
        String information = this.requires().donneRecu().lireInformations();
        System.out.println(information);
    }

    public void transfertMsg(String msg) {
        stategieAffichage.transfertMsg(msg);
    }
    public void affichageMsg(String msg) {
        stategieAffichage.affichageMsg(msg);
    }
}
