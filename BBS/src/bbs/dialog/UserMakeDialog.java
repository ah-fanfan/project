package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import bbs.util.DbUtil;
import bbs.util.MessageUtil;
import bbs.util.NameUtil;
import bbs.util.RodomIdAndPsw;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class UserMakeDialog extends Dialog {

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
	public UserMakeDialog(Shell parent, int style) {
		super(parent, style);
		setText("新用户注册");
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
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4E0B\u8F7D (1).jpg"));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u6CE8\u518C (1).png"));
		shell.setSize(506, 415);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(126, 35, 61, 17);
		label.setText("\u59D3\u540D\uFF1A");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(126, 100, 61, 17);
		label_2.setText("\u624B\u673A\u53F7\u7801\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {

				String name=text.getText().trim();
				if(!NameUtil.validateName(name)){
					MessageUtil.showBox("输入的姓名不符合规范", SWT.ICON_ERROR);
					return ;
				}
			
			}
		});
		text.setBounds(222, 32, 115, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String number=text_1.getText().trim();
				if(!NameUtil.phoneTest(number)){
					MessageUtil.showBox("输入的电话号码不符合规范！！！", SWT.ICON_ERROR);
					return ;
				}
			
			}
		});
		text_1.setBounds(222, 97, 115, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u6CE8\u518C.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name=text.getText().trim();
				String num=text_1.getText().trim();
				if(name!=null &&num!=null){
					text_2.setText(RodomIdAndPsw.getId());
					text_3.setText(RodomIdAndPsw.getPsw());
					String code=text_2.getText().trim();
					String psw=text_3.getText().trim();
				int res = db.update(
						"insert into userlist " + "(u_name,u_staus,u_code,u_psw,u_num,u_chicek)"
								+ "values(?,?,?,?,?,?)",
						name,1,code,psw,num,"1级");
				if (res > 0) {
					MessageUtil.showBox("注册成功", SWT.ICON_WORKING);
				} else {
					MessageUtil.showBox("注册失败", SWT.ICON_ERROR);
					return ;
				}
			}
				else{
					MessageUtil.showBox("注册失败", SWT.ICON_ERROR);
					return ;
				}
			}
		
		});
		button.setBounds(237, 165, 88, 27);
		button.setText("\u6CE8\u518C");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(222, 226, 115, 23);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(222, 283, 115, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(126, 229, 61, 17);
		label_1.setText("\u8D26\u53F7:");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(126, 286, 61, 17);
		label_3.setText("\u5BC6\u7801:");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u767B\u9646.png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				LoginDialog l=new LoginDialog(new Shell(), SWT.NONE);
				l.open();
			}
		});
		button_1.setBounds(237, 349, 88, 27);
		button_1.setText("\u524D\u53BB\u767B\u5F55");

	}

}
