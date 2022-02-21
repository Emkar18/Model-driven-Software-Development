package main;

import java.util.HashMap;
import java.util.Map;

import main.metamodel.*;

public class StateMachine {
	
	private Machine metamodel = new Machine();
	private Map<String,State> states = new HashMap<>();
	
	private State currentState;
	private String currentEvent;
	private Transition currentTransition;
	
	public Machine build() {
		return metamodel;
	}

	public StateMachine state(String string) {
		currentState = getState(string);
		metamodel.addState(currentState);
		return this;
	}
	
	public StateMachine initial() {
		metamodel.setInitialState(currentState);
		return this;
	}
	
	private State getState(String name) {
		if(!states.containsKey(name)) states.put(name, new State(name));
		return states.get(name);
	}

	public StateMachine when(String event) {
		currentEvent = event;
		return this;
	}

	public StateMachine to(String state) {
		currentTransition = new Transition(currentEvent, getState(state));
		currentState.addTransition(currentTransition);
		return this;
	}
	
	public StateMachine set(String string, int i) {
		metamodel.addInteger(string, i);
		currentTransition.setSetOperation(true);
		currentTransition.setOperationVariableName(string);
		return this;
	}

	public StateMachine increment(String string) {
		currentTransition.setIncrementOperation(true);
		currentTransition.setOperationVariableName(string);
		return this;
	}

	public StateMachine decrement(String string) {
		currentTransition.setDecrementOperation(true);
		currentTransition.setOperationVariableName(string);
		return this;
	}

	public StateMachine ifEquals(String string, int i) {
		currentTransition.setConditionVariableName(string);
		currentTransition.setConditionComparedValue(i);
		currentTransition.setConditionEqual(true);
		return this;
	}

	public StateMachine ifGreaterThan(String string, int i) {
		currentTransition.setConditionVariableName(string);
		currentTransition.setConditionComparedValue(i);
		currentTransition.setConditionGreaterThan(true);
		return this;
	}

	public StateMachine ifLessThan(String string, int i) {
		currentTransition.setConditionVariableName(string);
		currentTransition.setConditionComparedValue(i);
		currentTransition.setConditionLessThan(true);
		return this;
	}
	
	public StateMachine integer(String integer) {
		metamodel.addInteger(integer, 0);
		return this;
	}
}
