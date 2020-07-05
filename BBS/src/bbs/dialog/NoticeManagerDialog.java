package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Text;

import bbs.util.DbUtil;
import bbs.util.MessageUtil;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class NoticeManagerDialog extends Dialog {

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
	public NoticeManagerDialog(Shell parent, int style) {
		super(parent, style);
		setText("发布公告");
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
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\u=2421745658,2257366478&fm=26&gp=0.jpg"));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u516C\u544A (2).png"));
		shell.setSize(600, 486);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(39, 40, 61, 17);
		label.setText("\u516C\u544A\u6807\u9898\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u516C\u544A\u7C7B\u578B\uFF1A");
		label_1.setBounds(42, 114, 61, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u516C\u544A\u5185\u5BB9\uFF1A");
		label_2.setBounds(46, 203, 61, 17);
		text = new Text(shell, SWT.BORDER);
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String title=text.getText().trim();
				if(title==null){
					MessageUtil.showBox("公告标题不能为空!", SWT.ICON_ERROR);
					return ;
				}
			}
		});
		text.setBounds(121, 37, 73, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(120, 201, 348, 81);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(110, 306, 88, 24);
		
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER | SWT.TIME);
		dateTime_1.setBounds(219, 307, 88, 24);

		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u53D1\u5E03\u65F6\u95F4\uFF1A");
		label_3.setBounds(43, 312, 61, 17);
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"\u653F\u6CBB", "\u7ECF\u6D4E", "\u6587\u5316", "\u79D1\u6280", "\u751F\u6D3B"});
		combo.setBounds(124, 111, 88, 25);
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u786E\u8BA4.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String head=text.getText().trim();
				String type=combo.getText().trim();
				String body=text_1.getText().trim();
				//时间未写
				String date=dateTime.getYear()+"-"+(int)(dateTime.getMonth()+1)+"-"+dateTime.getDay();
				String time=dateTime_1.getHours()+":"+(int)(dateTime_1.getMonth()+1)+":"+dateTime_1.getSeconds();
				String setName=LoginDialog.name;
				if(type==null){
					MessageUtil.showBox("类型选项不能为空!", SWT.ICON_ERROR);
					return ;
				}
				if(body==null){
					MessageUtil.showBox("公告内容不能为空", SWT.ICON_ERROR);
					return ;
				}
				int res = db.update(
						"insert into notice " + "(n_head,n_type,n_body,n_date,n_time,n_set,n_staus)"
								+ "values(?,?,?,?,?,?,?)",
						head,type,body,date,time,LoginDialog.name,1);
				if (res > 0) {
					MessageUtil.showBox("发布成功", SWT.ICON_WORKING);
				} else {
					MessageUtil.showBox("发布失败", SWT.ICON_ERROR);
				}
			}
		});
		button.setBounds(83, 415, 88, 27);
		button.setText("\u786E\u8BA4\u53D1\u5E03");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u53D6\u6D88 (1).png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.open();
			}
		});
		button_1.setBounds(357, 415, 88, 27);
		button_1.setText("\u53D6\u6D88\u53D1\u5E03");
		
		
		
	
	}

}
