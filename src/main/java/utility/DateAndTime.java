package utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTime {
	public static String getDateAndTime(){
	LocalDateTime date=LocalDateTime.now();
	DateTimeFormatter pattern=DateTimeFormatter.ofPattern("yyyy-MM-dd HH-MM-SS");
	String dateAndTime=date.format(pattern);
	return dateAndTime;
	}
}
