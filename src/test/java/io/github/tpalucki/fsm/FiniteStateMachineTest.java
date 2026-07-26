package io.github.tpalucki.fsm;

import io.github.tpalucki.datastructures.fsm.BaseStates;
import io.github.tpalucki.datastructures.fsm.FiniteStateMachine;
import io.github.tpalucki.datastructures.fsm.MyFiniteStateMachine;
import org.junit.jupiter.api.Test;

class FiniteStateMachineTest {


    // TODO This is very poor quality test and in fact doesnt validate the result
    @Test
    void stateMachineBasicUsage() {
        FiniteStateMachine fsm = new MyFiniteStateMachine();

        fsm.addState("A");
        fsm.addState("B");
        fsm.addState("C");
        fsm.addState("D");

        fsm.addRoute(BaseStates.INTIAL.valueOf(), "A", "a");
        fsm.addRoute("A", "B", "b");
        fsm.addRoute("A", "C", "c");
        fsm.addRoute("B", "D", "d");
        fsm.addRoute("C", "D", "d");
        fsm.addRoute("D", BaseStates.FINAL.valueOf(), BaseStates.FINAL.valueOf().toLowerCase());

        fsm.init();

        fsm.next("a");
        fsm.next("b");
        fsm.next("d");
        fsm.next("final");
    }
}
