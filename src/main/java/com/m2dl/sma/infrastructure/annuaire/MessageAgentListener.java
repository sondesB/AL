package com.m2dl.sma.infrastructure.annuaire;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

import com.m2dl.sma.infrastructure.communication.IMessageAgent;
import com.m2dl.sma.infrastructure.communication.MessageAgent;


public interface MessageAgentListener {

    void messageEnvoye(ReferenceAgent expediteur, ReferenceAgent destinataire,

                       IMessageAgent messageAgent);

    void messageRecu(ReferenceAgent expediteur, ReferenceAgent destinataire,
            MessageAgent messageAgent);

}
