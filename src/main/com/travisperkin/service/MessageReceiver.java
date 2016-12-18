/**
* The MessageReceiver program is used for processing each message.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.service;

import main.com.travisperkin.api.IMessageReceiver;
import main.com.travisperkin.util.InstructionMessageConstants;
import main.com.travisperkin.util.InstructionMessageHelper;
import main.com.travisperkin.vo.InstructionMessage;


public class MessageReceiver implements IMessageReceiver{
	
	InstructionMessage instructionMessage;

	/**
	 * This is the method which converts instructionmessages into object of InstructionMessage class.
	 * @param message - Instruction Message.
	 */
	@Override
	public void receive(String message) {
		instructionMessage = new InstructionMessage();
		if(message != null && !message.isEmpty() ){
			String[] tokens = message.split(InstructionMessageConstants.EMPTY_SPACE);
			instructionMessage.setInstructionType(tokens[1]);
			instructionMessage.setProductCode(tokens[2]);
			instructionMessage.setQuantity(Integer.parseInt(tokens[3]));
			instructionMessage.setUom(Integer.parseInt(tokens[4]));
			instructionMessage.setTimeStamp(InstructionMessageHelper.stringToDate(tokens[5]));
		}
	}
	
	public InstructionMessage getInstructionMessage() {
		return instructionMessage;
	}
	
}
