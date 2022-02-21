package main.metamodel;

public class Transition {
	
	private String event;
	private State toState;
	
	private String operationVariableName;
	private String conditionalVariableName;
	private int conditionalComparedValue;
	
	private boolean setOperation;
	private boolean incrementOperation;
	private boolean decrementOperation;
	private boolean conditionEqual;
	private boolean lessThan;
	private boolean greaterThan;

	public Transition(String event, State state) {
		super();
		this.event = event;
		toState = state;
		
		setOperation = false;
		incrementOperation = false;
		decrementOperation = false;
		conditionEqual = false;
		lessThan = false;
		greaterThan = false;
	}
	
	public void process() {
		
	}

	public String getEvent() {
		return event;
	}

	public State getTarget() {
		return toState;
	}

	public boolean hasSetOperation() {
		return setOperation;
	}
	
	public void setSetOperation(boolean bool) {
		setOperation = bool;
	}

	public boolean hasIncrementOperation() {
		return incrementOperation;
	}
	
	public void setIncrementOperation(boolean bool) {
		incrementOperation = bool;
	}

	public boolean hasDecrementOperation() {
		return decrementOperation;
	}
	
	public void setDecrementOperation(boolean bool) {
		decrementOperation = bool;
	}

	public Object getOperationVariableName() {
		return operationVariableName;
	}
	
	public void setOperationVariableName(String name) {
		operationVariableName = name;
	}

	public boolean isConditional() {
		if(conditionEqual || greaterThan || lessThan) {
			return true;
		}
		return false;
	}


	public String getConditionVariableName() {
		return conditionalVariableName;
	}

	public Integer getConditionComparedValue() {
		return conditionalComparedValue;
	}
	
	public void setConditionVariableName(String name) {
		conditionalVariableName = name;
	}

	public void setConditionComparedValue(int i) {
		conditionalComparedValue = i;
	}

	public boolean isConditionEqual() {
		return conditionEqual;
	}
	
	public void setConditionEqual(boolean bool) {
		conditionEqual = bool;
	}

	public boolean isConditionGreaterThan() {
		return greaterThan;
	}
	
	public void setConditionGreaterThan(boolean bool) {
		greaterThan = bool;
	}

	public boolean isConditionLessThan() {
		return lessThan;
	}
	
	public void setConditionLessThan(boolean bool) {
		lessThan = bool;
	}

	public boolean hasOperation() {
		if(incrementOperation || decrementOperation) {
			return true;
		}
		return false;
	}

}
