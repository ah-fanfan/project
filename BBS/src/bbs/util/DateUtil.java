package bbs.util;
import org.eclipse.swt.widgets.DateTime;
//���ڴ�����
public class DateUtil {
	public static String getDateTime(DateTime datetime){
		int month=datetime.getMonth()+1;
		return datetime.getYear()+"-"+ month +"-"+datetime.getDay();
		
	}


}
