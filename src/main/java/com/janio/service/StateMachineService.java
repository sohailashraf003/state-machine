package com.janio.service;

import com.janio.util.State;
import sun.plugin.dom.exception.InvalidStateException;

import java.util.*;

import static com.sun.jmx.snmp.ThreadContext.contains;

public class StateMachineService {
    private Map<State, List<State>> stateTransition = new HashMap<>();

    {
        stateTransition.put(State.PENDING, Arrays.asList(State.APPROVED, State.REJECTED));
        stateTransition.put(State.APPROVED, Arrays.asList(State.REJECTED, State.PENDING));
        stateTransition.put(State.REJECTED, Arrays.asList(State.PENDING));
    }

    public Map<State, List<State>> getStateTransition() {
        return stateTransition;
    }

    public List<State> getPossibleTransitions(State state) {
        if(stateTransition.get(state) == null ) {
            throw new InvalidStateException("Invalid State");
        }
        return stateTransition.get(state);
    }

    public boolean isValidState(State state) {

        if(stateTransition.get(state) == null) {
            return false;
        }

        return true;
    }

}