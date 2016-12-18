/**
* The InvalidMessageException is used as an custom exception for InstructionQueue.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.exception;

public class InvalidMessageException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public InvalidMessageException(String exceptionMessage){
		super(exceptionMessage);
	}

}
