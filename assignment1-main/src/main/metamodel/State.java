package main.metamodel;

import java.util.ArrayList;
import java.util.List;

public class State {
	
	private String name;
	private List<Transition> transitions = new ArrayList<>();
	
	public State(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public List<Transition> getTransitions() {
		return transitions;
	}
	
	public void addTransition(Transition transition) {
		transitions.add(transition);
	}

	public Transition getTransitionByEvent(String event) {
		for(Transition t : transitions) {
			if (t.getEvent().equals(event)) {
				return t;
			}
		}
		return null;
	}

}
