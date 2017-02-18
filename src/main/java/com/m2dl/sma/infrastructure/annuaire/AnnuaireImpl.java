package com.m2dl.sma.infrastructure.annuaire;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

import com.m2dl.sma.infrastructure.agent.Agent;
import com.m2dl.sma.infrastructure.agent.ReferenceAgent;
import com.m2dl.sma.infrastructure.communication.IMessageAgent;

public class AnnuaireImpl implements Annuaire {

    private List<AgentListener> agentListeners;
    private List<ReferenceAgentListener> referenceAgentListeners;
    private List<MessageAgentListener> messageAgentListeners;
    private ConcurrentMap<ReferenceAgent, Agent> agents;
    private ConcurrentMap<ReferenceAgent, ConcurrentLinkedQueue<IMessageAgent>> agentsMessagesQueues;
    private ConcurrentMap<ReferenceAgent, ReadWriteLock> agentsLocks;

    public AnnuaireImpl() {
        referenceAgentListeners = Collections.synchronizedList(new ArrayList<>());
        agentListeners = Collections.synchronizedList(new ArrayList<>());
        messageAgentListeners = Collections.synchronizedList(new ArrayList<>());
        agents = new ConcurrentHashMap<>();
        agentsMessagesQueues = new ConcurrentHashMap<>();
        agentsLocks = new ConcurrentHashMap<>();
    }

    @Override
    public void addAgent(Agent agent) {
        agentsLocks.put(agent.getReferenceAgent(), new ReentrantReadWriteLock());
        lockAgentEcriture(agent.getReferenceAgent());
        agents.put(agent.getReferenceAgent(), agent);
        agentsMessagesQueues.put(agent.getReferenceAgent(), new ConcurrentLinkedQueue<>());
        unlockAgentEcriture(agent.getReferenceAgent());
        referenceAgentListeners.forEach(
                agentListener -> agentListener.agentAjoute(agent.getReferenceAgent()));
        agentListeners.forEach(
                agentListener -> agentListener.agentAjoute(agent));
    }

    @Override
    public void removeAgent(ReferenceAgent referenceAgent) {
        agentListeners.forEach(
                agentListener -> agentListener.agentRetire(agents.get(referenceAgent)));
        lockAgentEcriture(referenceAgent);
        agents.remove(referenceAgent);
        agentsMessagesQueues.remove(referenceAgent);
        unlockAgentEcriture(referenceAgent);
        referenceAgentListeners.forEach(agentListener -> agentListener.agentRetire(referenceAgent));

    }

    @Override
    public void envoyerMessage(ReferenceAgent expediteur, ReferenceAgent destinataire,
                               IMessageAgent IMessageAgent) {
        lockAgentLecture(destinataire);
        if (agentsMessagesQueues.containsKey(destinataire)) {
            agentsMessagesQueues.get(destinataire).add(IMessageAgent);
            messageAgentListeners.forEach(
                    messageAgentListener -> messageAgentListener.messageEnvoye(expediteur,
                            destinataire, IMessageAgent));
        }
        unlockAgentLecture(destinataire);
    }

    @Override
    public void diffuserMessage(ReferenceAgent expediteur, IMessageAgent IMessageAgent) {
        agentsMessagesQueues.keySet().forEach(this::lockAgentLecture);
        agentsMessagesQueues.entrySet().forEach(referenceAgentEntry -> {
            referenceAgentEntry.getValue().add(IMessageAgent);
            notifierMessageAgentListeners(expediteur, IMessageAgent, referenceAgentEntry.getKey());
        });
        agentsMessagesQueues.keySet().forEach(this::unlockAgentLecture);
    }

    private void notifierMessageAgentListeners(ReferenceAgent expediteur, IMessageAgent IMessageAgent,
                                               ReferenceAgent referenceAgent) {
        messageAgentListeners.forEach(
                messageAgentListener -> messageAgentListener.messageEnvoye(expediteur,
                        referenceAgent, IMessageAgent));
    }

    @Override
    public Optional<IMessageAgent> recevoirMessage(ReferenceAgent destinataire) {
        lockAgentLecture(destinataire);
        Optional<IMessageAgent> message = Optional.ofNullable(agentsMessagesQueues.get(destinataire))
                .map(ConcurrentLinkedQueue::poll);
        message.ifPresent(
                messageAgent -> notifierMessageAgentListeners(messageAgent.getExpediteur(),
                        messageAgent, destinataire));
        unlockAgentLecture(destinataire);
        return message;
    }

    public void ajouterAgentListener(AgentListener agentListener) {
        agentListeners.add(agentListener);
    }

    public void retirerAgentListener(AgentListener agentListener) {
        agentListeners.remove(agentListener);
    }

    public void ajouterReferenceAgentListener(ReferenceAgentListener referenceAgentListener) {
        referenceAgentListeners.add(referenceAgentListener);
    }

    public void retirerReferenceAgentListener(ReferenceAgentListener referenceAgentListener) {
        referenceAgentListeners.remove(referenceAgentListener);
    }


    @Override
    public void ajouterMessageAgentListener(MessageAgentListener messageAgentListener) {
        messageAgentListeners.add(messageAgentListener);
    }

    @Override
    public void retirerMessageAgentListener(MessageAgentListener messageAgentListener) {
        messageAgentListeners.remove(messageAgentListener);
    }

    private void lockAgentEcriture(ReferenceAgent referenceAgent) {
        executeIfPresent(agentsLocks.get(referenceAgent),
                readWriteLock -> readWriteLock.writeLock().lock());
    }

    private void lockAgentLecture(ReferenceAgent referenceAgent) {
        executeIfPresent(agentsLocks.get(referenceAgent),
                readWriteLock -> readWriteLock.readLock().lock());
    }

    private void unlockAgentEcriture(ReferenceAgent referenceAgent) {
        executeIfPresent(agentsLocks.get(referenceAgent),
                readWriteLock -> readWriteLock.writeLock().unlock());
    }

    private void unlockAgentLecture(ReferenceAgent referenceAgent) {
        executeIfPresent(agentsLocks.get(referenceAgent),
                readWriteLock -> readWriteLock.readLock().unlock());
    }

    private <T> void executeIfPresent(T object, Consumer<T> objectConsumer) {
        if (object != null) {
            objectConsumer.accept(object);
        }
    }
}