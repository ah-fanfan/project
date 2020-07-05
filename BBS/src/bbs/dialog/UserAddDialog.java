package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;

import bbs.util.DbUtil;
import bbs.util.ImageUtils;
import bbs.util.MessageUtil;
import bbs.util.NameUtil;
import bbs.util.RodomIdAndPsw;

import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class UserAddDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private String image;
	private String file;
	private String path;
	private DbUtil db=new DbUtil();
	private Text text_3;
	private Text text_4;

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UserAddDialog(Shell parent, int style) {
		super(parent, style);
		setText("网友信息添加");
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
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\timg.jpg"));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u589E\u52A0.png"));
		shell.setSize(747, 538);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(43, 37, 61, 17);
		label.setText("\u59D3\u540D\uFF1A");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("\u6027\u522B\uFF1A");
		label_1.setBounds(370, 37, 61, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setText("\u51FA\u751F\u65E5\u671F\uFF1A");
		label_2.setBounds(43, 107, 61, 17);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setText("\u4F4F\u5740\uFF1A");
		label_3.setBounds(370, 107, 61, 17);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("\u7167\u7247\uFF1A");
		label_4.setBounds(43, 249, 61, 17);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setText("\u624B\u673A\u53F7\u7801\uFF1A");
		label_5.setBounds(43, 179, 61, 17);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setText("\u529E\u7406\u65F6\u95F4\uFF1A");
		label_6.setBounds(370, 267, 61, 17);
		
		Label label_7 = new Label(shell, SWT.NONE);
		label_7.setText("\u529E\u7406\u4EBA\uFF1A");
		label_7.setBounds(370, 358, 61, 17);
		
		Label label_8 = new Label(shell, SWT.BORDER);
		label_8.setBounds(125, 248, 115, 159);
		
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u59D3\u540D.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//选择照片
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				image = fd.open();
				if(image!=null){
				ImageUtils.showImg(label_8, image);
				}
				if(image==null||image.equals("")){
					image="G://java//DSMS//upload//default.gif";
				}
		
			}
		});
		button.setBounds(142, 439, 80, 27);
		button.setText("\u9009\u62E9\u7167\u7247");
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setBounds(646, 106, 88, 25);
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				//地址三级联动
			
					String c_Name=combo_1.getText().trim();
					if(c_Name==null){
						MessageUtil.showBox("未选中地址", SWT.ICON_ERROR);
						return ;
					}else{
						display("select * from street where c_id in (select c_id from city where c_name= "+"'"+c_Name+"'"+")", "s_name", combo_2);
					}
				
				
			
			}
		});
		combo_1.setBounds(552, 107, 88, 25);
		
		
		Combo combo = new Combo(shell, SWT.NONE);
		combo.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {

				//地址二级联动
				String p_Name=combo.getText().trim();
				if(p_Name==null){
					MessageUtil.showBox("未选中地址", SWT.ICON_ERROR);
					return ;
				}else{
					display("select * from city where p_id in (select p_id from provice where p_name= "+"'"+p_Name+"'"+")", "c_name", combo_1);
				}
			
			}
		});
		combo.setBounds(458, 107, 88, 25);
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(458, 267, 88, 24);
	
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER);
		dateTime_1.setBounds(125, 107, 88, 24);
		
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FDD\u5B58 (1).png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String name=text.getText().trim();
				String sex="";
				if(button.getSelection()){
					sex="男";
				}else{
					sex="女";
				}
				String date=dateTime_1.getYear()+"-"+(int)(dateTime_1.getMonth()+1)+"-"+dateTime_1.getDay();
				String address=combo.getText().trim()+combo_1.getText().trim()+combo_2.getText().trim();
				String num=text_1.getText().trim();
				String psw=text_3.getText().trim();
				String setName=text_2.getText().trim();
				String settime=dateTime.getYear()+"-"+(int)(dateTime.getMonth()+1)+"-"+dateTime.getDay();
				String code=text_4.getText().trim();
				if(image==null){
					image="G://java//DSMS//upload//default.gif";
				}
			     path = ImageUtils.uploadImg(image, "upload");
			     if(combo.getText().trim()==null||combo_1.getText().trim()==null||combo_2.getText().trim()==null){
			    	 MessageUtil.showBox("地址选项不能有空！", SWT.ICON_ERROR);
			    	 return ;
			     }
			     int res = db.update("insert into userlist " + "(u_name,u_sex,u_date,u_address,u_image,u_staus,u_code,u_psw,u_set,u_settime,u_num,u_chicek)"
									+ "values(?,?,?,?,?,?,?,?,?,?,?,?)",
							name, sex, date,  address,  path, 1,code,psw,LoginDialog.name,settime,num,"1级");
					if (res > 0) {
						MessageUtil.showBox("添加成功", SWT.ICON_WORKING);
					} else {
						MessageUtil.showBox("添加失败", SWT.ICON_ERROR);
					}
			}
		});
		button_1.setBounds(458, 439, 80, 27);
		button_1.setText("\u6DFB\u52A0");
		
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
		text.setBounds(125, 31, 73, 23);
		
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
		text_1.setBounds(125, 176, 107, 23);
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(458, 358, 73, 23);
		
		
		
		Button btnRadioButton = new Button(shell, SWT.RADIO);
		btnRadioButton.setBounds(449, 37, 33, 17);
		btnRadioButton.setText("\u7537");
		
		Button button_2 = new Button(shell, SWT.RADIO);
		button_2.setText("\u5973");
		button_2.setBounds(498, 37, 33, 17);
		
		Label label_9 = new Label(shell, SWT.NONE);
		label_9.setBounds(370, 194, 61, 17);
		label_9.setText("\u52A8\u6001\u5BC6\u7801\uFF1A");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(458, 191, 73, 23);
		Label label_10 = new Label(shell, SWT.NONE);
		  label_10.setBounds(370, 232, 61, 17);
		  label_10.setText("\u8D26\u53F7\uFF1A");
		  
		  text_4 = new Text(shell, SWT.BORDER);
		  text_4.setBounds(458, 232, 73, 23);
		  String code=RodomIdAndPsw.getId();
		  String psw=RodomIdAndPsw.getPsw();
		  text_4.setText(code);
		  text_3.setText(psw);
		  text_2.setText(LoginDialog.name);
		  display("select * from provice ", "p_name", combo);
		  
		  
	}
			//三级联动数据库查询方法
public void display(String sql, String s, Combo combo) {
				List<Map<String, Object>> list = db.query(sql);
				String str = "";
				String arr[] = null;
				for (Map<String, Object> map : list) {
					str += map.get(s).toString() + ",";
				}
				// str=str.substring(0,str.length()-1);
				arr = str.split(",");
				combo.setItems(arr);
			}
}
