package medium.implementations;

import medium.interfaces.RecAnnonce;
import stub.Annonce;

/**
 * Ce composant est un médiateur entre le composant MessageSender
 * et les deux composants Record et MessageReceiver.
 */
public class Mediator implements RecAnnonce {

    private Record record;
    private MessageSender messageSender;

    /**
     * Transmet l'annonce ann ainsi que la liste des agents disponibles
     * au composant MessageSender.
     *
     * @param ann annonce
     */
    @Override
    public void addAnnonce(Annonce ann) {
        messageSender.sendAnnonce(record.getListAgents(), ann);
    }
}
