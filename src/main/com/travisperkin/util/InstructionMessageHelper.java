/**
* The InstructionMessagePriorityEnum program is used for providing utility methods.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class InstructionMessageHelper {
	
	/**
	 * The method convert a String to Date Object.
	 * @param inputDate - Date in String format
	 * @return Date - Date object   
	 */
	public static Date stringToDate(String inputDate){
		Date date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(InstructionMessageConstants.DATE_FORMAT, Locale.ENGLISH);
		try {
			date = dateFormat.parse(inputDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return date;
	}
	
	/**
	 * The method convert a Date object to String.
	 * @param inputDate - Date object
	 * @return String - Date in String format  
	 */
	public static String dateToString(Date inputDate){
		String date = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat(InstructionMessageConstants.DATE_FORMAT, Locale.ENGLISH);
		date = dateFormat.format(inputDate);		
		return date;
	}
}
