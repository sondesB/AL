package medium.implementations;

import medium.interfaces.RecAnnonce;
import stub.Annonce;

/**
 * Created by benja135 on 03/02/17.
 */
public class Mediator implements RecAnnonce {

    private Record record;
    private MessageSender messageSender;

    @Override
    public void addAnnonce(Annonce ann) {
        messageSender.sendAnnonce(record.getListAgents(), ann);
    }
}
