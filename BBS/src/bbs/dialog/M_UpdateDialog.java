package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.intro.IntroContentDetector;

import bbs.util.DbUtil;
import bbs.util.ImageUtils;
import bbs.util.DateUtil;
import bbs.util.MessageUtil;
import bbs.util.RodomIdAndPsw;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseTrackAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class M_UpdateDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private Text text_4;
	private String image;
	private DbUtil db=new DbUtil();
	private String path;
	private Object id;
	private String file;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public M_UpdateDialog(Shell parent, int style) {
		super(parent, style);
		setText("管理员信息修改");
	}

	/**
	 * Open the dialog.
	 * @return the result
	 */
	public Object open(Object id) {
		this.id=id;
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
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FEE\u6539.png"));
		shell.setSize(671, 575);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(45, 46, 43, 17);
		label.setText("\u59D3\u540D\uFF1A");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(94, 46, 73, 23);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(306, 46, 43, 17);
		label_1.setText("\u6027\u522B\uFF1A");
		
		Button button = new Button(shell, SWT.RADIO);
		button.setBounds(355, 46, 43, 17);
		button.setText("\u7537");
		
		Button button_1 = new Button(shell, SWT.RADIO);
		button_1.setText("\u5973");
		button_1.setBounds(437, 46, 43, 17);
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(45, 132, 43, 17);
		label_2.setText("\u5E74\u9F84\uFF1A");
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(94, 129, 73, 23);
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(313, 132, 36, 17);
		label_3.setText("\u5730\u5740\uFF1A");
		Combo combo_2 = new Combo(shell, SWT.NONE);
		combo_2.setBounds(548, 124, 88, 25);
		Combo combo_1 = new Combo(shell, SWT.NONE);
		combo_1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
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
		combo_1.setBounds(454, 124, 88, 25);
		Combo combo = new Combo(shell, SWT.NONE);
		combo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
                combo.removeAll();
                combo_1.removeAll();
                combo_2.removeAll();
                display("select * from provice", "p_name", combo);
				//地址二级联动
				
			}
			@Override
			public void focusLost(FocusEvent e) {
				String p_Name=combo.getText().trim();
				//System.out.println(p_Name);
				if(p_Name==null){
					MessageUtil.showBox("未选中地址", SWT.ICON_ERROR);
					return ;
				}else{
					display("select * from city where p_id in (select p_id from provice where p_name= "+"'"+p_Name+"'"+")", "c_name", combo_1);
				}
			}
		});
		combo.setBounds(350, 124, 88, 25);

		Label lblZhaopian = new Label(shell, SWT.NONE);
		lblZhaopian.setBounds(45, 221, 61, 17);
		lblZhaopian.setText("\u7167\u7247\uFF1A");
		
		Label lblNewLabel = new Label(shell, SWT.BORDER);
		lblNewLabel.setBounds(88, 221, 143, 187);
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(321, 221, 43, 17);
		label_4.setText("\u8D26\u53F7\uFF1A");
		
		text_2 = new Text(shell, SWT.BORDER);
		text_2.setBounds(365, 221, 73, 23);
		
		Label label_5 = new Label(shell, SWT.NONE);
		label_5.setBounds(321, 301, 35, 17);
		label_5.setText("\u5BC6\u7801\uFF1A");
		
		text_3 = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		text_3.setBounds(365, 301, 73, 23);
		
		Label label_6 = new Label(shell, SWT.NONE);
		label_6.setBounds(316, 382, 48, 17);
		label_6.setText("\u529E\u7406\u4EBA\uFF1A");
		
		text_4 = new Text(shell, SWT.BORDER);
		text_4.setBounds(365, 379, 73, 23);
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u59D3\u540D.png"));
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//选择照片
				FileDialog fd = new FileDialog(shell, SWT.OPEN);
				image = fd.open();
				if(image!=null){
				ImageUtils.showImg(lblNewLabel, image);
				}
				if(image==null||image.equals("")){
					image="G://java//DSMS//upload//default.gif";
				}
			}
		});
		button_2.setBounds(110, 475, 80, 27);
		button_2.setText("\u9009\u62E9\u7167\u7247");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4FEE\u6539 (1).png"));
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if(image==null){
					String sql="select * from managerlist where m_id =?";
					List<Map<String, Object>> list =db.query(sql,id);
						image=list.get(0).get("m_image").toString();
					    path = image;
					}
				else{
					    path = ImageUtils.uploadImg(image, "upload");
					}
					String name=text.getText().trim();
					String sex="";
					if(button.getSelection()){
						sex="男";
					}else{
						sex="女";
					}
					String setName=text_4.getText().trim();
					int  age=Integer.parseInt(text_1.getText().trim());
					String code=text_2.getText().trim();
					String psw=text_3.getText().trim();
					String address=combo.getText().trim()+combo_1.getText().trim()+combo_2.getText().trim();
					int res=db.update("update  managerlist set "
							+ "m_name=?,m_sex=?,m_age=?,m_address=?,m_code=?,m_psw=?,m_image=?,m_staus=?,m_set=? where m_code=?"
							 , name,sex,age,address,code,psw,path,1,setName,code);
					if(res>0){
						MessageUtil.showBox("修改成功", SWT.ICON_WORKING);
						//sa.query();
					}else{
						MessageUtil.showBox("修改失败", SWT.ICON_ERROR);
					}
					
				
				
			}
		});
		button_3.setBounds(365, 475, 80, 27);
		button_3.setText("\u4FEE\u6539");
		List<Map<String , Object>> list=db.query("select * from managerlist where m_id=? ",id);
		text.setText(list.get(0).get("m_name").toString());
		if(list.get(0).get("m_sex").toString().equals("男")){
			button.setSelection(true);
		}else{
			button_1.setSelection(true);
		}
		text_1.setText(list.get(0).get("m_age").toString());
		String arr[]=list.get(0).get("m_address").toString().split("省");
		combo.setText(arr[0]+"省");
		String arr1[]=arr[1].split("市");
		combo_1.setText(arr1[0]+"市");
		combo_2.setText(arr1[1]);
		if(list.get(0).get("m_image").toString()==null){
			image = "G://java//DSMS//upload//default.gif";
		}else{
			image = list.get(0).get("m_image").toString();
		}
		file = ImageUtils.getTargetPath("upload");
		ImageUtils.showImg(lblNewLabel, file+image);
		text_2.setText(list.get(0).get("m_code").toString());
		text_3.setText(list.get(0).get("m_psw").toString());
		text_4.setText(LoginDialog.name);
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
