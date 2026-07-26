package io.github.tpalucki.datastructures.fsm;

public class MyFiniteStateMachine implements FiniteStateMachine {


    private String state;


    @Override
    public void addState(String name) {
    }

    @Override
    public void addRoute(String fromState, String toState, String condition) {
    }

    @Override
    public void next(String condition) {
//        System.out.println("Transition: " + fromState + " --> " + toState + " on condition: " + condition);
    }

    @Override
    public void init() {
        this.state = BaseStates.INTIAL.valueOf();
    }

    @Override
    public String currentState() {
        return this.state;
    }
}
