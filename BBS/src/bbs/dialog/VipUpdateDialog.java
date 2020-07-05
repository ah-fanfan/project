package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import bbs.util.DateUtil;
import bbs.util.DbUtil;
import bbs.util.ImageUtils;
import bbs.util.MessageUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.wb.swt.SWTResourceManager;

public class VipUpdateDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
    private DbUtil db=new DbUtil();
    private String image;
    private String file;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public VipUpdateDialog(Shell parent, int style) {
		super(parent, style);
		setText("会员信息添加");
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
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FEE\u6539.png"));
		shell.setSize(643, 516);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(117, 20, 96, 17);
		label.setText("\u8BF7\u8F93\u5165\u4F1A\u5458\u8D26\u53F7\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(233, 17, 73, 23);
		Button button_1 = new Button(shell, SWT.RADIO);
		button_1.setBounds(319, 85, 38, 17);
		button_1.setText("\u7537");
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(103, 154, 88, 24);
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(319, 158, 88, 25);

		Combo combo_3 = new Combo(shell, SWT.NONE);
		combo_3.setItems(new String[] {"1\u7EA7", "2\u7EA7", "3\u7EA7", "4\u7EA7", "5\u7EA7"});
		combo_3.setBounds(319, 237, 88, 25);
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(411, 158, 88, 25);
		Label lblNewLabel = new Label(shell, SWT.BORDER);
		lblNewLabel.setBounds(86, 240, 127, 161);
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setBounds(505, 158, 88, 25);
		Button button_2 = new Button(shell, SWT.RADIO);
		button_2.setText("\u5973");
		button_2.setBounds(373, 85, 38, 17);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(319, 310, 73, 23);
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u67E5\u8BE2.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String code=text.getText().trim();
				List<Map<String,Object>> list=db.query("select * from userlist where u_staus=1 and u_code=?",code);
				if(list.size()<0){
					MessageUtil.showBox("没有该用户的信息", SWT.ICON_ERROR);
					return ;
				}else{
					text_1.setText(list.get(0).get("u_name").toString());
					if(list.get(0).get("u_sex").toString().equals("男")||list.get(0).get("u_sex").toString()==null){
						button_1.setSelection(true);
					}else{
						button_2.setSelection(true);
					}
					String arr[]=list.get(0).get("u_date").toString().split("-");
					dateTime.setDate(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Integer.parseInt(arr[2]));
					String ar[]=list.get(0).get("u_address").toString().split("省");
					combo.setText(ar[0]+"省");
					System.out.println(ar[1]);
					String arr1[]=ar[1].split("市");
					combo_1.setText(arr1[0]+"市");
					combo_2.setText(arr1[1]);
					if(list.get(0).get("u_image").toString()==null){
						image = "G://java//DSMS//upload//default.gif";
					}else{
						image = list.get(0).get("u_image").toString();
					}
					file = ImageUtils.getTargetPath("upload");
					ImageUtils.showImg(lblNewLabel, file+image);
					combo_3.setText(list.get(0).get("u_chicek").toString());
					text_2.setText(LoginDialog.name);
				}
			}
		});
		button.setBounds(342, 15, 80, 27);
		button.setText("\u67E5\u8BE2");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u59D3\u540D\uFF1A");
		label_2.setBounds(39, 72, 48, 17);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u6027\u522B\uFF1A");
		label_3.setBounds(264, 85, 38, 17);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("\u51FA\u751F\u65E5\u671F\uFF1A");
		label_4.setBounds(39, 161, 61, 17);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("\u7167\u7247\uFF1A");
		label_5.setBounds(39, 240, 36, 17);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("\u5730\u5740\uFF1A");
		label_6.setBounds(264, 161, 38, 17);
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(245, 240, 61, 17);
		label_7.setText("\u4F1A\u5458\u7B49\u7EA7\uFF1A");
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setText("\u529E\u7406\u4EBA\uFF1A");
		label_8.setBounds(245, 313, 61, 17);
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER);
		dateTime_1.setBounds(319, 386, 88, 24);
		
		DateTime dateTime_2 = new DateTime(shell, SWT.BORDER | SWT.TIME);
		dateTime_2.setBounds(421, 386, 88, 24);
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(103, 69, 73, 23);
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FEE\u6539 (1).png"));
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String chicek=combo_3.getText().trim();
				String setName=LoginDialog.name;
				String setTime=dateTime_1.getYear()+"-"+(int)(dateTime_1.getMonth()+1)+"-"+dateTime_1.getDay()+"  "+dateTime_2.getHours()+":"+dateTime_2.getMinutes()+":"+dateTime_2.getSeconds();
				int res=db.update("update  userlist set "
						+ "u_chicek=?,u_set=?,u_settime=?  where u_code=?"
						 , chicek,setName,setTime,text.getText().trim());
				if(res>0){
					MessageUtil.showBox("修改成功", SWT.ICON_WORKING);
				}else{
					MessageUtil.showBox("修改失败", SWT.ICON_ERROR);
				}
			}
		});
		button_3.setBounds(233, 450, 80, 27);
		button_3.setText("\u4FEE\u6539");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(245, 386, 61, 17);
		label_1.setText("\u529E\u7406\u65E5\u671F\uFF1A");
		
	

	}
}
