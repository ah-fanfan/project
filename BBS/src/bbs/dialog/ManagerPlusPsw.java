package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;

import bbs.util.DbUtil;
import bbs.util.MessageUtil;
import org.eclipse.wb.swt.SWTResourceManager;

public class ManagerPlusPsw extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private DbUtil db=new DbUtil();

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ManagerPlusPsw(Shell parent, int style) {
		super(parent, style);
		setText("超级管理员密码修改");
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
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\u=309553779,79428312&fm=26&gp=0.jpg"));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5BC6\u7801.png"));
		shell.setSize(450, 328);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(71, 21, 61, 17);
		label.setText("\u8D26\u53F7\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u5BC6\u7801\uFF1A");
		label_1.setBounds(71, 64, 61, 17);
		
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u6821\u9A8C.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String code=text.getText().trim();
				String psw=text_1.getText().trim();
				List<Map<String,Object>> list=db.query("select * from managerpluslist where m_code=? and m_psw=? ", code,psw);
				if(list.size()>0){
					MessageUtil.showBox("身份校验通过，请继续操作", SWT.ICON_WARNING);
					
				}else{
					MessageUtil.showBox("身份校验失败，请重新操作", SWT.ICON_ERROR);
					return ;
				}
				
			}
		});
		button.setBounds(180, 102, 96, 27);
		button.setText("\u8EAB\u4EFD\u6821\u9A8C");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(71, 152, 80, 17);
		label_2.setText("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u8BF7\u786E\u8BA4\u4F60\u7684\u5BC6\u7801\uFF1A");
		label_3.setBounds(71, 193, 96, 17);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(180, 18, 73, 23);
		
		text_1 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_1.setBounds(180, 61, 73, 23);
		
		text_2 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_2.setBounds(180, 149, 73, 23);
		
		text_3 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_3.setBounds(180, 190, 73, 23);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FEE\u6539 (1).png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String psw1=text_2.getText().trim();
				String psw2=text_3.getText().trim();
				if(psw1.equals(psw2)){
					int res=db.update("update  managerpluslist set "
							+ "m_psw=? where m_code=?"
							 , psw1,text.getText().trim());
					if(res>0){
						MessageUtil.showBox("修改成功", SWT.ICON_WORKING);
					}else{
						MessageUtil.showBox("修改失败", SWT.ICON_ERROR);
					}
				}else{
					MessageUtil.showBox("密码输入不一致", SWT.ICON_ERROR);
					return ;
				}
			}
		});
		button_1.setBounds(180, 234, 96, 27);
		button_1.setText("\u4FEE\u6539");

	}

}
