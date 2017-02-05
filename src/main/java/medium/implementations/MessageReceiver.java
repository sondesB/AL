package medium.implementations;

import medium.services.Acheminement;
import stub.Annonce;

/**
 * Composant récupérant l’annonce d’un agent.
 * Sa méthode "annoncer" est accessible via l'interface Acheminement.
 */
public class MessageReceiver implements Acheminement {

    private Mediator mediator;

    /**
     * Permet à un agent de s'annoncer. Transmet l'annonce au mediator.
     *
     * @param ann annonce
     */
    @Override
    public void annoncer(Annonce ann) {
        mediator.addAnnonce(ann);
    }
}
