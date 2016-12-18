/**
* The InstructionMessagePriorityEnum program is used for maintaining message priorities.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.util;

public enum InstructionMessagePriorityEnum {
	
	A(1), B(2), C(3), D(3);
	private int priority;
	
	private InstructionMessagePriorityEnum(int priority) {
		this.priority=priority;
	}

	public int getPriority() {
		return priority;
	}
	
}
