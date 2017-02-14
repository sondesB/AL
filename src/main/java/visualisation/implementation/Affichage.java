package visualisation.implementation;

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

    public void affichageMsg(String msg) {
        stategieAffichage.affichageMsg(msg);
    }

}
