package visualisation.implementation;

import visualisation.abstractvisualisation.AbstractAffichage;
import visualisation.interfaces.IStrategieAffichage;
import visualisation.interfaces.ITransfert;

/**
 * Created by alpha on 10/02/2017.
 */
public class Affichage extends AbstractAffichage {
    private IStrategieAffichage stategieAffichage;

    public void afficher () {
    }

    public void affichageMsg(String msg) {
        stategieAffichage.affichageMsg(msg);
    }

    @Override
    protected ITransfert make_recevoirMsgDeJournalisation() {
        return null;
    }
}
