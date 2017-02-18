package com.m2dl.sma.infrastructure.communication;

import java.util.Optional;

import com.m2dl.sma.infrastructure.agent.ReferenceAgent;

public interface ICommunication {

    void envoyerMessage(ReferenceAgent expediteur, ReferenceAgent destinataire,

            IMessageAgent IMessageAgent);

    void diffuserMessage(ReferenceAgent expediteur, IMessageAgent IMessageAgent);

    Optional<IMessageAgent> recevoirMessage(ReferenceAgent destinataire);

}
