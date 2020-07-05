package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.jface.preference.StringButtonFieldEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import bbs.util.DbUtil;
import bbs.util.MessageUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class UserTReleaseDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
private DbUtil db=new DbUtil();
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UserTReleaseDialog(Shell parent, int style) {
		super(parent, style);
		setText("发布动态");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\timg (1).jpg"));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u52A8\u6001.png"));
		shell.setSize(646, 568);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(62, 99, 61, 17);
		label.setText("\u52A8\u6001\u7C7B\u578B\uFF1A");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"\u653F\u6CBB", "\u519B\u4E8B", "\u79D1\u6280", "\u6587\u5316", "\u751F\u6D3B"});
		combo.setBounds(129, 96, 88, 25);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(62, 31, 61, 17);
		label_1.setText("\u52A8\u6001\u6807\u9898\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String t=text.getText().trim();
				if(t==null){
					MessageUtil.showBox("标题不能为空!", SWT.ICON_ERROR);
					return ;
				}
			}
		});
		text.setBounds(129, 28, 208, 33);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(62, 163, 61, 17);
		lblNewLabel.setText("\u5185\u5BB9\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(129, 160, 222, 205);
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(129, 412, 88, 24);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(62, 412, 61, 17);
		label_2.setText("\u53D1\u5E03\u65F6\u95F4\uFF1A");
		
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.TIME);
		dateTime_1.setBounds(241, 412, 88, 24);
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u786E\u8BA4.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String head=text.getText().trim();
				String type=combo.getText().trim();
				String body=text_1.getText().trim();
				String date=dateTime.getYear()+"-"+(int)(dateTime.getMonth()+1)+"-"+dateTime.getDay();
				String time=dateTime_1.getHours()+":"+dateTime_1.getMinutes()+":"+dateTime_1.getSeconds();
				if(type==null){
					MessageUtil.showBox("类型选项不能为空!", SWT.ICON_ERROR);
					return ;
				}
				if(body==null){
					MessageUtil.showBox("发布内容不能为空!", SWT.ICON_ERROR);
					return ;
				}
			
				int res = db.update(
						"insert into text " + "(t_head,t_type,t_body,t_date,t_time,t_set)"
								+ "values(?,?,?,?,?,?)",
					head,type,body,date,time,LoginDialog.name);
				if (res > 0) {
					MessageUtil.showBox("发布成功", SWT.ICON_WORKING);
				} else {
					MessageUtil.showBox("发布失败", SWT.ICON_ERROR);
				}
			}
		});
		button.setBounds(129, 458, 82, 27);
		button.setText("\u786E\u8BA4\u53D1\u5E03");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.open();
			}
		});
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u53D6\u6D88 (1).png"));
		button_1.setBounds(263, 458, 88, 27);
		button_1.setText("\u53D6\u6D88\u53D1\u5E03");
		
		

	}

}
