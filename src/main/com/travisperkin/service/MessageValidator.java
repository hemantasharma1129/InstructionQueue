/**
* The MessageValidator program is used for applying validation rules.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.service;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import main.com.travisperkin.util.InstructionMessageConstants;
import main.com.travisperkin.util.InstructionMessagePriorityEnum;
import main.com.travisperkin.vo.InstructionMessage;

public class MessageValidator {
	
	
	public boolean validateMessage(InstructionMessage insMessage){
		if(this.isValidInstructionType(insMessage.getInstructionType()) && this.isValidProductCode(insMessage.getProductCode()) &&
		   this.isValidQuantity(insMessage.getQuantity()) && this.isValidUOM(insMessage.getUom()) && this.isValidTimestamp(insMessage.getTimeStamp())){
			return true;
		}
		
		return false;
	}

	public boolean isValidInstructionType(String insType){
		try{
			InstructionMessagePriorityEnum.valueOf(insType).getPriority();
		}catch(IllegalArgumentException e){			
			return false;
		}
		return true;
	}
	
	public boolean isValidProductCode(String productCode){
		Pattern pattern = Pattern.compile(InstructionMessageConstants.ALPHANUM_REGEX);
		Matcher matcher = pattern.matcher(productCode);				
		return matcher.matches();
	}
	
	public boolean isValidQuantity(Integer quantity){
		return quantity > 0;
	}
	
	public boolean isValidUOM(Integer uom){
		return uom >=0 && uom < 256;
	}
	
	public boolean isValidTimestamp(Date timestamp){		
		return 0 < timestamp.getTime()? timestamp.getTime() < System.currentTimeMillis()?true:false:false;
	}
}
