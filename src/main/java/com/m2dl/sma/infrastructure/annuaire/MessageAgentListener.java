package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.IMessageAgent;

public interface MessageAgentListener {

    void messageEnvoye(ReferenceAgent expediteur, ReferenceAgent destinataire,
            IMessageAgent IMessageAgent);

    void messageRecu(ReferenceAgent expediteur, ReferenceAgent destinataire,
            IMessageAgent IMessageAgent);
}
