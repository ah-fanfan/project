package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import bbs.util.DbUtil;
import bbs.util.ImageUtils;
import bbs.util.MessageUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class UserUpdateDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text_1;
	private Text text_3;
	private DbUtil db=new DbUtil();
	private String image;
	private String file;
	private String path;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UserUpdateDialog(Shell parent, int style) {
		super(parent, style);
		setText("个人信息修改");
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
		shell.setSize(645, 516);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(12, 26, 45, 17);
		label_1.setText("\u59D3\u540D\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(72, 26, 73, 23);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(9, 239, 61, 17);
		label_3.setText("\u7167\u7247\uFF1A");
		
		Label label_4 = new Label(shell, SWT.BORDER);
		label_4.setBounds(72, 238, 140, 179);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(333, 26, 61, 17);
		label_5.setText("\u6027\u522B\uFF1A");
		
		Button button = new Button(shell, SWT.RADIO);
		button.setBounds(435, 26, 33, 17);
		button.setText("\u7537");
		
		Button button_1 = new Button(shell, SWT.RADIO);
		button_1.setText("\u5973");
		button_1.setBounds(501, 26, 33, 17);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(72, 98, 88, 24);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(12, 98, 58, 17);
		label_6.setText("\u51FA\u751F\u65E5\u671F\uFF1A");
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setBounds(333, 105, 61, 17);
		label_7.setText("\u8054\u7CFB\u7535\u8BDD\uFF1A");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(430, 99, 100, 23);
		
		Label label_8 = new Label(shell, SWT.NONE);
		label_8.setBounds(333, 239, 61, 17);
		label_8.setText("\u5BB6\u5EAD\u4F4F\u5740\uFF1A");
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.setBounds(400, 236, 68, 25);
		
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.setBounds(474, 236, 68, 25);
		
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setBounds(548, 236, 73, 25);

		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER);
		dateTime_1.setBounds(414, 354, 88, 24);
		
		DateTime dateTime_2 = new DateTime(shell, SWT.BORDER | SWT.TIME);
		dateTime_2.setBounds(513, 354, 88, 24);
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FDD\u5B58 (1).png"));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(image==null){
					String sql="select * from userlist where u_code=?";
					List<Map<String, Object>> list =db.query(sql,LoginDialog.code);
						image=list.get(0).get("u_image").toString();
					    path = image;
					}
				else{
					    path = ImageUtils.uploadImg(image, "upload");
					}
					String name=text_1.getText().trim();
					String sex="";
					if(button.getSelection()){
						sex="男";
					}else{
						sex="女";
					}
					String date=dateTime.getYear()+"-"+(int)(dateTime.getMonth()+1)+"-"+dateTime.getDay();
					String num=text_3.getText().trim();
					String address=combo.getText().trim()+combo_1.getText().trim()+combo_2.getText().trim();
					String setTime=dateTime_1.getYear()+"-"+(int)(dateTime_1.getMonth()+1)+"-"+dateTime_1.getDay()+"  "+dateTime_2.getHours()+":"+dateTime_2.getMinutes()+":"+dateTime_2.getSeconds();
					int res=db.update("update  userlist set "
							+ "u_name=?,u_sex=?,u_date=?,u_num=?,u_address=?,u_image=?,u_staus=?,u_settime=? where u_code=?"
							 , name,sex,date,num,address,path,1,setTime,LoginDialog.code);
					if(res>0){
						MessageUtil.showBox("修改成功", SWT.ICON_WORKING);
					}else{
						MessageUtil.showBox("修改失败", SWT.ICON_ERROR);
					}
				
			}
		});
		button_2.setBounds(454, 458, 80, 27);
		button_2.setText("\u4FDD\u5B58");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(333, 364, 51, 17);
		label.setText("\u4FEE\u6539\u65F6\u95F4:");
		
		List<Map<String, Object>> list=db.query("select * from userlist where u_staus=1 and u_code=?",LoginDialog.code);
		text_1.setText(list.get(0).get("u_name").toString());
		if(list.get(0).get("u_sex").toString().equals("男")){
			button.setSelection(true);
		}else{
			button_1.setSelection(true);
		}
		String arr[]=list.get(0).get("u_date").toString().split("-");
		dateTime.setDate(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]),Integer.parseInt(arr[2]));
		text_3.setText(list.get(0).get("u_num").toString());
		String brr[]=list.get(0).get("u_address").toString().split("省");
		combo.setText(brr[0]+"省");
		String arr1[]=brr[1].split("市");
		combo_1.setText(arr1[0]+"市");
		combo_2.setText(arr1[1]);
		if(list.get(0).get("u_image").toString()==null){
			image = "G://java//DSMS//upload//default.gif";
		}else{
			image = list.get(0).get("u_image").toString();
		}
		file = ImageUtils.getTargetPath("upload");
		ImageUtils.showImg(label_4, file+image);
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u59D3\u540D.png"));
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				//选择照片
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				image = fd.open();
				if(image!=null){
				ImageUtils.showImg(label_4, image);
				}
				if(image==null||image.equals("")){
					image="G://java//DSMS//upload//default.gif";
				}
			
			}
		});
		button_3.setBounds(91, 458, 88, 27);
		button_3.setText("\u9009\u62E9\u7167\u7247");
		

	}
}
