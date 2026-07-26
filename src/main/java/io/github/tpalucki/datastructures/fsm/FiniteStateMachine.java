package io.github.tpalucki.datastructures.fsm;

public interface FiniteStateMachine {

    void addState(String name);

    void addRoute(String fromState, String toState, String condition);

    void next(String condition);

    void init();

    String currentState();
}
