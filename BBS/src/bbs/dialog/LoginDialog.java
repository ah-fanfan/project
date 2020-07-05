package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import org.omg.PortableServer.ServantActivator;

import bbs.util.DbUtil;
import bbs.util.MessageUtil;
import bbs.view.ManagerView;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.graphics.Point;

public class LoginDialog extends Dialog {

	protected boolean result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private DbUtil db=new DbUtil();
	public  static String power ;
	public  static String code ;
	public  static String psw ;
	public  static String name;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public LoginDialog(Shell parent, int style) {
		super(parent, style);
		setText("登陆");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public boolean open() {
		createContents();
		shell.open();
		shell.layout();
		Display display = getParent().getDisplay();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		return  result;
	}

	/**
	 * Create contents of the dialog.
	 */
	private void createContents() {
		shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.MIN | SWT.MAX);
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4E0B\u8F7D.jpg"));
		shell.setLocation(new Point(100, 100));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u767B\u9646.png"));
		shell.setSize(449, 312);
		shell.setText("\u767B\u5F55");
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));

		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 33, 48, 24);
		label.setText("   \u7528\u6237\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setText("1111");
		text.setBounds(85, 30, 73, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("   \u5BC6\u7801\uFF1A");
		label_1.setBounds(10, 108, 48, 24);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setText("111111");
		text_1.setBounds(85, 105, 73, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("  \u767B\u5F55\u6743\u9650\uFF1A");
		label_2.setBounds(10, 184, 68, 24);
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setItems(new String[] {"\u7F51\u53CB", "\u7BA1\u7406\u5458", "\u8D85\u7EA7\u7BA1\u7406\u5458"});
		combo.setBounds(85, 184, 88, 25);
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			//用户登陆权限处理
			public void widgetSelected(SelectionEvent e) {
				 code=text.getText().trim();
				 psw=text_1.getText().trim();
				 power = combo.getText().trim();
				if("管理员".equals(power)){
					List<Map<String, Object>> list=db.query("select * from managerlist where m_staus=1 and m_code=? and m_psw=?",code,psw);
					
					if(list.size()>0){
						name=list.get(0).get("m_name").toString();
						MessageUtil.showBox("登录成功！", SWT.ICON_WORKING);
						result=true;
						shell.close();
					}else{
						MessageUtil.showBox("用户名或密码错误！", SWT.ICON_ERROR);
						result=false;
					}
				}
				else if("网友".equals(power)){
				   List<Map<String ,Object>> list1=db.query("select * from userlist where u_staus=1 and u_code=? and u_psw=?",code,psw);
				   if(list1.size()>0){
					   name=list1.get(0).get("u_name").toString();
						MessageUtil.showBox("登录成功！", SWT.ICON_WORKING);
						result=true;
						shell.close();
					}else{
						MessageUtil.showBox("用户名或密码错误！", SWT.ICON_ERROR);
						result=false;
					}
				}
				else if("超级管理员".equals(power)){
					   List<Map<String ,Object>> list2=db.query("select * from managerpluslist where m_code=? and m_psw=?",code,psw);
					   if(list2.size()>0){
						    name=list2.get(0).get("m_name").toString();
							MessageUtil.showBox("登录成功！", SWT.ICON_WORKING);
							result=true;
							shell.close();
						}else{
							MessageUtil.showBox("用户名或密码错误！", SWT.ICON_ERROR);
							result=false;
						}
					}
			}
		});
		button.setBounds(41, 234, 80, 27);
		button.setText("\u767B\u5F55");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(214, 234, 80, 27);
		button_1.setText("\u53D6\u6D88");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserMakeDialog um=new UserMakeDialog(new Shell(), SWT.None);
				um.open();
			}
		});
		button_2.setBounds(353, 28, 80, 27);
		button_2.setText("\u6CE8\u518C\u8D26\u53F7");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TourModeDialog td=new TourModeDialog(new Shell(), SWT.None);
				td.open();
			}
		});
		button_3.setBounds(353, 103, 80, 27);
		button_3.setText("\u6E38\u5BA2\u6A21\u5F0F");

	}
}
