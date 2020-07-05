package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import bbs.util.DbUtil;
import bbs.util.MessageUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class ManagerPswDialog extends Dialog {

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
	public ManagerPswDialog(Shell parent, int style) {
		super(parent, style);
		setText("����Ա�����޸�");
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
		shell.setSize(450, 376);
		shell.setText(getText());
		//����͸��
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(51, 31, 36, 17);
		label.setText("\u8D26\u53F7\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u5BC6\u7801\uFF1A");
		label_1.setBounds(51, 78, 36, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		label_2.setBounds(51, 177, 84, 17);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u8BF7\u786E\u8BA4\u60A8\u7684\u65B0\u5BC6\u7801\uFF1A");
		label_3.setBounds(47, 229, 99, 17);
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(162, 31, 73, 23);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(162, 75, 73, 23);
		
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u6821\u9A8C.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String code=text.getText().trim();
				String psw=text_1.getText().trim();
				List<Map<String,Object>> list=db.query("select * from managerlist where m_code=? and m_psw=? ", code,psw);
				if(list.size()>0){
					MessageUtil.showBox("���У��ͨ�������������", SWT.ICON_WARNING);
					
				}else{
					MessageUtil.showBox("���У��ʧ�ܣ������²���", SWT.ICON_ERROR);
					return ;
				}
				
			
			}
		});
		button.setBounds(162, 122, 88, 27);
		button.setText("\u8EAB\u4EFD\u6821\u9A8C");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(162, 174, 73, 23);
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(162, 226, 73, 23);
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FEE\u6539 (1).png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				

				String psw1=text_2.getText().trim();
				String psw2=text_3.getText().trim();
				if(psw1.equals(psw2)){
					int res=db.update("update  managerlist set "
							+ "m_psw=? where m_code=?"
							 , psw1,text.getText().trim());
					if(res>0){
						MessageUtil.showBox("�޸ĳɹ�", SWT.ICON_WORKING);
					}else{
						MessageUtil.showBox("�޸�ʧ��", SWT.ICON_ERROR);
					}
				}else{
					MessageUtil.showBox("�������벻һ��", SWT.ICON_ERROR);
					return ;
				}
			
			}
		});
		button_1.setBounds(162, 288, 88, 27);
		button_1.setText("\u4FEE\u6539");

	}

}
