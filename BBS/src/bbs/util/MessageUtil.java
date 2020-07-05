package bbs.util;

import javax.print.attribute.standard.RequestingUserName;
import javax.swing.Box;

import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
//系统提示函数
public class MessageUtil {
	public static int showBox(String msg,int style){
		MessageBox box=new MessageBox(new Shell(),style);
			box.setMessage(msg);
			box.setText("系统提示");
			return box.open();
	}

}
