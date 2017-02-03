package main.java.medium.implementations;

import main.java.medium.services.Acheminement;
import main.java.stub.Annonce;

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
