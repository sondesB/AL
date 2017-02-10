package com.m2dl.sma.infrastructure.etat;

import com.m2dl.sma.infrastructure.communication.ICommunication;

import java.util.Optional;

public abstract class IEtat {

    private ICommunication communication;

    public ICommunication getCommunication() {
        return communication;
    }

    public void setCommunication(ICommunication communication) {
        this.communication = communication;
    }

    abstract Optional<IEtat> executer();

}
