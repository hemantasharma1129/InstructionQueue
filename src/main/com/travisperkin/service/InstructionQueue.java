/**
* The InstructionQueue program provides the functionality of Queue.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.service;

import java.util.PriorityQueue;

import main.com.travisperkin.exception.InvalidMessageException;
import main.com.travisperkin.vo.InstructionMessage;

public class InstructionQueue extends PriorityQueue<InstructionMessage>{
	
	private static final long serialVersionUID = 1L;

	/**
	 * The method validates and adds valid message to Queue.
	 * @param message - Instruction Message.
	 * @exception - InvalidMessageException
	 */
	public void enqueue(InstructionMessage message) throws InvalidMessageException{
		MessageValidator validator = new MessageValidator();
		if(validator.validateMessage(message)){
			super.add(message);
		}else{
			throw new InvalidMessageException("Invalid Instruction Message : " + message.toString());
		}		
	}
	
	/**
	 * The method returns highest priority message from Queue and Removes it.
	 * @return InstructionMessage. 
	 */
	public InstructionMessage dequeue() {		
		return super.poll();
	}
	
	/**
	 * The method returns highest priority message from Queue but doesn't Remove it.
	 * @return InstructionMessage. 
	 */
	public InstructionMessage peek() {				
		return super.peek();
	}
	
	/**
	 * The method returns size of Queue.
	 * @return int. 
	 */
	public int count() {
		return super.size();
	}

	/**
	 * The method checks if Queue is empty.
	 * @return Boolean. 
	 */
	public boolean isEmpty() {		
		return super.isEmpty();
	}
	
}
