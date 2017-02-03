package com.m2dl.sma.infrastructure.communication;

import java.util.Optional;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

public interface Communicateur {

    void envoyerMessage(ReferenceAgent expediteur, ReferenceAgent destinataire,
            MessageAgent messageAgent) throws AgentNotFoundException;

    void diffuserMessage(ReferenceAgent expediteur, MessageAgent messageAgent);

    Optional<MessageAgent> recevoirMessage(ReferenceAgent destinataire);
}
