package medium.implementations;

import medium.services.Acheminement;
import stub.Annonce;

/**
 * Created by benja135 on 03/02/17.
 */
public class MessageReceiver implements Acheminement {

    private Mediator mediator;

    @Override
    public void annoncer(Annonce ann) {
        mediator.addAnnonce(ann);
    }
}
