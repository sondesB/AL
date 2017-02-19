package visualisation.implementation;

import visualisation.abstractvisualisation.AbstractAffichage;
import visualisation.interfaces.IStrategieAffichage;
import visualisation.interfaces.ITransfert;

/**
 * Created by alpha on 10/02/2017.
 */
public class Affichage extends AbstractAffichage implements ITransfert {
    private IStrategieAffichage stategieAffichage;

    public Affichage(){
        stategieAffichage = new AffichageText();
    }
    @Override
    protected ITransfert make_recevoirMsgDeJournalisation() {
        return this;
    }

    @Override
    public void lireInformations(String msg) {
        stategieAffichage.lireInformations(msg);

    }
}
