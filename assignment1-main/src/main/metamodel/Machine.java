package main.metamodel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Machine {
	
	private List<State> states = new ArrayList<State>();
	private State initialState;
	private int numberOfIntegers;
	private Map<String, Integer> integers = new HashMap<>();
	private String currentInteger;
	

	public Machine() {
		// TODO Auto-generated constructor stub
	}
	
	public Machine(Collection<State> states, State initialState) {
		this.states.addAll(states);
		this.initialState = initialState;
		numberOfIntegers = 0;
	}
	
	public List<State> getStates() {
		return states;
	}
	
	public void addState(State state) {
		states.add(state);
	}

	public State getInitialState() {
		return initialState;
	}
	
	public void setInitialState(State state) {
		initialState = state;
	}

	public State getState(String name) {
		for (State st : states) {
			if (st.getName().equals(name)) {
				return st;
			}
		}
		return null;
	}

	public int numberOfIntegers() {
		return numberOfIntegers;
	}


	public boolean hasInteger(String string) {
		if(integers.containsKey(string)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Integer getInteger(String name) {
		if(integers.containsKey(name)) {
			return integers.get(name);
		}
		return 0;
	}

	public void addInteger(String variable, int i) {
		integers.put(variable, i);
		numberOfIntegers++;
		currentInteger = variable;
	}
	
	public String getCurrentInteger() {
		return currentInteger;
	}
	
	public void incrementInteger(String variable) {
		integers.put(variable, integers.get(variable) + 1);
	}
	
	public void decrementInteger(String variable) {
		integers.put(variable, integers.get(variable) - 1);
	}

}

