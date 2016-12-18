package main.com.travisperkin.api;

import main.com.travisperkin.vo.InstructionMessage;

public interface IMessageReceiver {
	void receive(String message);
	InstructionMessage getInstructionMessage();
}
