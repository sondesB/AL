package visualisation.implementation;

import visualisation.interfaces.IStrategieAffichage;

/**
 * Created by alpha on 10/02/2017.
 */
public class AffichageText implements IStrategieAffichage {

    @Override
    public void affichageMsg(String msg) {
        System.out.println(msg);
    }
}
