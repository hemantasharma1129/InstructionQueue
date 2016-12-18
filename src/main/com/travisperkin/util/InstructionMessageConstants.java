/**
* The InstructionMessageConstants program is used maintaining constants for the application.
* @author  Hemanta Sharma
* @version 1.0
* @since   17-12-2016
*/
package main.com.travisperkin.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class InstructionMessageConstants {
	
	public static final String DATE_FORMAT = "yyyy­MM­dd'T'HH:mm:ss.SSS'Z'";
	public static final String ALPHANUM_REGEX = "[A-Z]{2}[0-9]{2}";
	public static final Charset ENCODING = StandardCharsets.UTF_8;
	public static final String HIGHEST_MESSAGE_PRIORITY = "A";
	public static final String FILE_LOCATION = "resources\\InstructionMessages.txt";	
	public static final String EMPTY_SPACE = " ";
}
