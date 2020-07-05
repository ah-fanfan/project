package dsms1.util;
import org.eclipse.swt.widgets.DateTime;

public class DateUtil {
	public static String getDateTime(DateTime datetime){
		return datetime.getYear()+"-"+datetime.getMonth()+"-"+datetime.getDay();
		
	}


}
