/**
* The InstructionMessage program is Data Value Object.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.vo;

import java.io.Serializable;
import java.util.Date;

import main.com.travisperkin.util.InstructionMessageHelper;
import main.com.travisperkin.util.InstructionMessagePriorityEnum;

public class InstructionMessage implements Serializable, Comparable<InstructionMessage>{
	
	private static final long serialVersionUID = 1L;
	private String instructionType;
	private String productCode;
	private Integer quantity;
	private Integer uom;
	private Date timeStamp;
	public String getInstructionType() {
		return instructionType;
	}
	public void setInstructionType(String instructionType) {
		this.instructionType = instructionType;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getUom() {
		return uom;
	}
	public void setUom(Integer uom) {
		this.uom = uom;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	@Override
	public int compareTo(InstructionMessage message) {

		if(instructionType.equalsIgnoreCase(message.getInstructionType())){
			return 0;
		}
		
		int message1Priority = InstructionMessagePriorityEnum.valueOf(instructionType).getPriority();
		int message2Priority = InstructionMessagePriorityEnum.valueOf(message.getInstructionType()).getPriority();
		
		return message1Priority > message2Priority? 1 : -1;	
	}
	
	@Override
	public String toString() {		
		return "InstructionMessage " + instructionType + " " + productCode + " " + quantity + " " + uom + " " + InstructionMessageHelper.dateToString(timeStamp);
	}
	
	
}
