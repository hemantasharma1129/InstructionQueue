/**
* The InstructionQueueTest program implements an testunit that
* simply checks the possible number testcases for InstructionQueue
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package test.com.travisperkin.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import main.com.travisperkin.api.IMessageReceiver;
import main.com.travisperkin.exception.InvalidMessageException;
import main.com.travisperkin.service.InstructionQueue;
import main.com.travisperkin.service.MessageReceiver;
import main.com.travisperkin.util.InstructionMessageConstants;
import main.com.travisperkin.vo.InstructionMessage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InstructionQueueTest
{
	private IMessageReceiver iMessageReceiver;		
	private List<String> instructionMessages;
	private InstructionQueue instructionQueue;
			
	@Before
    public void setUp() {
		iMessageReceiver = new MessageReceiver();
		instructionQueue = new InstructionQueue();
		instructionMessages = readInstructionFile(InstructionMessageConstants.FILE_LOCATION);
    }
	
	@Test
	public void enque_should_only_add_valid_message() throws Exception{		
		this.addInstructionMessageToQueue();
		Assert.assertTrue(6 == instructionQueue.count());
	}	
		
	@Test
	public void deque_should_remove_and_returns_highest_priority_message_from_queue() throws Exception{		
		this.addInstructionMessageToQueue();		
		InstructionMessage dequedMessage = instructionQueue.dequeue();		
		Assert.assertTrue(InstructionMessageConstants.HIGHEST_MESSAGE_PRIORITY.equalsIgnoreCase(dequedMessage.getInstructionType()));
		Assert.assertTrue(5 == instructionQueue.count());
	}
	
	@Test
	public void peek_should_return_highest_priority_message_from_queue_without_removing() throws Exception{		
		this.addInstructionMessageToQueue();		
		InstructionMessage highestPriorityMessage = instructionQueue.peek();
		Assert.assertTrue(InstructionMessageConstants.HIGHEST_MESSAGE_PRIORITY.equalsIgnoreCase(highestPriorityMessage.getInstructionType()));
		Assert.assertTrue(6 == instructionQueue.count());
	}
	
	@Test
	public void emptyQueue_checks_if_queue_is_empty() {		
		Assert.assertTrue(instructionQueue.isEmpty());
	}
		
	private void addInstructionMessageToQueue() throws InvalidMessageException{
		for(String message : instructionMessages){
			iMessageReceiver.receive(message);
			InstructionMessage instructionMesage = iMessageReceiver.getInstructionMessage();
			instructionQueue.enqueue(instructionMesage);			
		}
	}
	
	private List<String> readInstructionFile(String aFileName)
	{
		List<String> messageList = null;
		Path path = Paths.get(aFileName);		
		if(Files.exists(path))
		{	
		    try {
				messageList = Files.readAllLines(path, InstructionMessageConstants.ENCODING);
			} catch (IOException e) {
				e.printStackTrace();				
			}
		}
		return messageList;
	}
}
