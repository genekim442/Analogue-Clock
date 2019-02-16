package clockProject;

import java.util.Calendar;
import java.util.GregorianCalendar;

class SetClock {

	
	
	SetClock() {
		Calendar calendar = new GregorianCalendar();

		ClockHands.rawHour = calendar.get(Calendar.HOUR_OF_DAY);
		ClockHands.minute = calendar.get(Calendar.MINUTE);
		ClockHands.second = calendar.get(Calendar.SECOND);
	}
}