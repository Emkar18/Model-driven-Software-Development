package main;

import main.metamodel.*;

public class MachineInterpreter {
	
	private Machine machine;
	private State currentState;

	public void run(Machine m) {
		machine = m;
		currentState = machine.getInitialState();
	}

	public State getCurrentState() {
		return currentState;
	}

	public void processEvent(String event) {
		for(Transition t: currentState.getTransitions()) {
			if(t.getEvent().equals(event)) {
				if (t.isConditional()) {
					if(t.isConditionEqual() && t.getConditionComparedValue().equals(machine.getInteger(t.getConditionVariableName()))) {
						if (t.hasOperation()){
							processOperation(t);
						}
						currentState = t.getTarget();
						return;
					} else if (t.isConditionLessThan() && t.getConditionComparedValue() > machine.getInteger(t.getConditionVariableName())) {
						if (t.hasOperation()){
							processOperation(t);
						}
						currentState = t.getTarget();
						return;
					} else if (t.isConditionGreaterThan() && t.getConditionComparedValue() < machine.getInteger(t.getConditionVariableName())) {
						if (t.hasOperation()){
							processOperation(t);
						}
						currentState = t.getTarget();
						return;
					}
				} else {
					if (t.hasOperation()){
						processOperation(t);
					}
					currentState = t.getTarget();
					return;
				}
			}
		}
		System.err.println("Unhandled event " + event);
	}
	
	private void processOperation(Transition t) {
		if(t.hasDecrementOperation()) {
			machine.decrementInteger(machine.getCurrentInteger());
		} else if (t.hasIncrementOperation()) {
			machine.incrementInteger(machine.getCurrentInteger());
		}
	}
	

	public int getInteger(String integer) {
		return machine.getInteger(integer);
	}

}
