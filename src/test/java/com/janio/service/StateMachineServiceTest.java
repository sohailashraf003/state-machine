package com.janio.service;

import com.janio.util.State;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StateMachineServiceTest {

    private static StateMachineService stateMachineService;

    @BeforeAll
    static void shouldReturnAllPossibleStates() {
        stateMachineService = new StateMachineService();
    }

    @Test
    void shouldReturnPossibleTransitions() {
        Map<State, List<State>> stateTransitions = stateMachineService.getStateTransition();
        assertArrayEquals(new State[]{State.APPROVED, State.REJECTED}, stateTransitions.get(State.PENDING).toArray());
        assertArrayEquals(new State[]{State.REJECTED, State.PENDING}, stateTransitions.get(State.APPROVED).toArray());
        assertArrayEquals(new State[]{State.PENDING}, stateTransitions.get(State.REJECTED).toArray());
    }

    @Test
    void shouldValidateThePossibleStates() {
        assertTrue(stateMachineService.isValidState(State.APPROVED));
        assertTrue(stateMachineService.isValidState(State.REJECTED));
        assertTrue(stateMachineService.isValidState(State.PENDING));
        assertFalse(stateMachineService.isValidState(null));
    }

    @Test
    void shouldReturnPossibleState() {
        Map<State, List<State>> stateTransitions = stateMachineService.getStateTransition();
        assertArrayEquals(new State[]{State.APPROVED, State.REJECTED}, stateTransitions.get(State.PENDING).toArray());
        assertArrayEquals(new State[]{State.REJECTED, State.PENDING}, stateTransitions.get(State.APPROVED).toArray());
        assertArrayEquals(new State[]{State.PENDING}, stateTransitions.get(State.REJECTED).toArray());
    }
}