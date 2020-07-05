package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;

import java.util.List;
import java.util.Map;

import javax.management.loading.PrivateClassLoader;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import bbs.util.RodomIdAndPsw;
import bbs.util.MessageUtil;
import bbs.util.NameUtil;
import bbs.util.DbUtil;
import bbs.util.ImageUtils;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;

public class M_AddDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private String image;
	private String code;
	private String psw;
    private DbUtil db=new DbUtil();
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public M_AddDialog(Shell parent, int style) {
		super(parent, style);
		setText("管理员添加");
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
		shell.setSize(646, 505);
		shell.setText(getText());
		//背景透明
	    shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(27, 23, 41, 17);
		lblNewLabel.setText("\u59D3\u540D\uFF1A");
		
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
		text.setBounds(89, 20, 73, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(283, 23, 33, 17);
		label.setText("\u6027\u522B\uFF1A");
		
		Button button = new Button(shell, SWT.RADIO);
		button.setBounds(347, 23, 33, 17);
		button.setText("\u7537");
		
		Button button_1 = new Button(shell, SWT.RADIO);
		button_1.setText("\u5973");
		button_1.setBounds(423, 23, 33, 17);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(20, 89, 61, 17);
		label_1.setText("\u5E74\u9F84\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				int age=Integer.parseInt(text_1.getText().trim());
				if(age<=18){
					MessageUtil.showBox("小于18周岁不能申请管理员",SWT.ICON_ERROR);
					return ;
				}else if(age>=60){
					MessageUtil.showBox("大于60周岁不能申请管理员", SWT.ICON_ERROR);
					return ;
				}
			}
		});
		text_1.setBounds(89, 83, 73, 23);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(283, 89, 33, 17);
		label_2.setText("\u5730\u5740\uFF1A");
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setBounds(514, 86, 88, 25);
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.addModifyListener(new ModifyListener() {
			//地址三级联动
			public void modifyText(ModifyEvent e) {
				String c_Name=combo_1.getText().trim();
				if(c_Name==null){
					MessageUtil.showBox("未选中地址", SWT.ICON_ERROR);
					return ;
				}else{
					display("select * from street where c_id in (select c_id from city where c_name= "+"'"+c_Name+"'"+")", "s_name", combo_2);
				}
			
			}
		});
		combo_1.setBounds(420, 86, 88, 25);
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
		combo.setBounds(322, 86, 88, 25);
		
		
		
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(20, 185, 33, 17);
		label_3.setText("\u7167\u7247\uFF1A");
		
		Label label_4 = new Label(shell, SWT.BORDER);
		label_4.setBounds(89, 185, 137, 179);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(289, 185, 41, 17);
		label_5.setText("\u8D26\u53F7\uFF1A");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(347, 185, 73, 23);
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(292, 267, 41, 17);
		lblNewLabel_1.setText("\u5BC6\u7801\uFF1A");
		
		text_3 = new Text(shell, SWT.BORDER);
		text_3.setBounds(347, 267, 73, 23);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(289, 352, 48, 17);
		label_6.setText("\u529E\u7406\u4EBA\uFF1A");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(347, 346, 73, 23);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FDD\u5B58 (1).png"));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//获取各项信息
				if(image==null){
					image="G://java//DSMS//upload//default.gif";
				}
				String path = ImageUtils.uploadImg(image, "upload");
				String name=text.getText().trim();
				String sex="";
				if(button.getSelection()){
					sex="男";
				}else{
					
					sex="女";
				}
				int age=Integer.parseInt(text_1.getText().trim());
				String address=combo.getText()+combo_1.getText()+combo_2.getText();
			     if(combo.getText().trim().equals(" ")||combo_1.getText().trim().equals(" ")||combo_2.getText().trim().equals(" ")){
			    	 MessageUtil.showBox("地址选项不能有空！", SWT.ICON_ERROR);
			    	 return ;
			     }
				int res = db.update(
						"insert into managerlist " + "(m_name,m_sex,m_age,m_address,m_image,m_staus,m_code,m_psw,m_set)"
								+ "values(?,?,?,?,?,?,?,?,?)",
						name, sex, age,  address,  path, 1,code,psw,LoginDialog.name);
				if (res > 0) {
					MessageUtil.showBox("添加成功", SWT.ICON_WORKING);
				} else {
					MessageUtil.showBox("添加失败", SWT.ICON_ERROR);
				}
				
			}
		});
		button_2.setBounds(340, 428, 80, 27);
		button_2.setText("\u4FDD\u5B58");
		
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
		button_3.setBounds(116, 428, 80, 27);
		button_3.setText("\u9009\u62E9\u7167\u7247");
		 code=RodomIdAndPsw.getId();
		 psw=RodomIdAndPsw.getPsw();
		text_2.setText(code);
		text_3.setText(psw);
		text_4.setText(LoginDialog.name);
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
