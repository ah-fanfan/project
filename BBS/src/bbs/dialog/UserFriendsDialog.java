package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IFileEditorMapping;
import org.eclipse.ui.PerspectiveAdapter;
import org.eclipse.wb.swt.SWTResourceManager;

import bbs.util.DbUtil;
import bbs.util.ImageUtils;
import bbs.util.MessageUtil;
import bbs.util.ValidateobjectIsNull;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UserFriendsDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Text text;
	private Table table_1;
	private DbUtil db=new DbUtil();
	private String image;
	private String file;
	private int page = 1;//当前页
	private int pageSize=15;//每页显示的行数
	private String remarks;
	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UserFriendsDialog(Shell parent, int style) {
		super(parent, style);
		setText("认识朋友");
	}
	public int getTotalPage(){
		int totalPage=0;
		List<Map<String,Object>> list=db.query("select count(*) as num from userlist where u_staus = 1");
		int count=Integer.parseInt(list.get(0).get("num").toString());
		if(count % pageSize == 0){
			totalPage = count / pageSize;
		}else{
			totalPage = count / pageSize + 1;
		}
		return totalPage;
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
		shell.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\timg (1).jpg"));
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4EA4\u53CB.png"));
		shell.setSize(632, 567);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		text = new Text(shell, SWT.BORDER);
		text.setBounds(210, 41, 129, 23);
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(80, 44, 72, 17);
		label.setText("\u5173\u952E\u5B57\u67E5\u8BE2\uFF1A");
		
		Button button = new Button(shell, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u67E5\u8BE2.png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				String str=text.getText().trim();
				if(str==null){
					MessageUtil.showBox("查询关键字不能为空", SWT.ICON_ERROR);
					return ;
				}else{
					String sql="select * from userlist where (u_id like '%"+str+"%' or u_name like '%"+str+"%' or u_sex like '%"+str +"%' or u_address like '%"+str+"%' or u_chicek like '%"+str+"%' ) and u_staus=1";
					querySome(sql);
				}
			  
			
			}
		});
		button.setBounds(428, 41, 80, 27);
		button.setText("\u67E5\u8BE2");
		
		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table_1.setBounds(31, 95, 435, 383);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);
		
		TableColumn tableColumn_1 = new TableColumn(table_1, SWT.NONE);
		tableColumn_1.setWidth(50);
		tableColumn_1.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_4 = new TableColumn(table_1, SWT.NONE);
		tableColumn_4.setWidth(50);
		tableColumn_4.setText("\u59D3\u540D");
		
		TableColumn tableColumn_5 = new TableColumn(table_1, SWT.NONE);
		tableColumn_5.setWidth(50);
		tableColumn_5.setText("\u6027\u522B");
		
		TableColumn tableColumn_6 = new TableColumn(table_1, SWT.NONE);
		tableColumn_6.setText("\u51FA\u751F\u65E5\u671F");
		tableColumn_6.setWidth(100);
		
		TableColumn tableColumn_9 = new TableColumn(table_1, SWT.NONE);
		tableColumn_9.setWidth(100);
		tableColumn_9.setText("\u4F1A\u5458\u7B49\u7EA7");
		
		Menu menu = new Menu(table_1);
		table_1.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = table_1.getSelection();
				if (items.length==0) {
					MessageUtil.showBox("请至少选中一条数据", SWT.ICON_WARNING);
					return ;
				}
				Object id = items[0].getData();
				System.out.println(id);
				List<Map<String,Object>> list=db.query("select * from userlist where u_id=?", id);
				System.out.println(list);
				int result = MessageUtil.showBox("您确定要关注她（他）吗？", SWT.ICON_QUESTION| SWT.OK| SWT.ICON_CANCEL);
				if (result ==32 ) {
					List<Map<String,Object>> list1=db.query("select * from userlist where u_code=?",LoginDialog.code);
					System.out.println(list1.get(0).get("u_remarks").toString());
					if(list1.get(0).get("u_remarks").toString().equals("1")){
						remarks="";
					}else{
						System.out.println(list.get(0).get("u_name").toString());
						remarks=remarks+","+list.get(0).get("u_name").toString();
					}
					
					int res = db.update("update  userlist set u_remarks=? where u_code=?",
							remarks,LoginDialog.code);
					MessageUtil.showBox("关注成功！", SWT.ICON_WORKING);
			
				} else{
					MessageUtil.showBox("关注失败！", SWT.ICON_ERROR);
					return ;
				}
			}
		});
		Label label_1 = new Label(shell, SWT.BORDER);
		label_1.setBounds(487, 129, 129, 159);
		menuItem.setText("\u5173\u6CE8\u4ED6\uFF08\u5979\uFF09");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = table_1.getSelection();
				if (items.length==0) {
					MessageUtil.showBox("请选中一条数据", SWT.ICON_WARNING);
					return ;
				}
				Object id = items[0].getData();
				List<Map<String,Object>> list=db.query("select * from userlist where u_id=?", id);
				if(list.get(0).get("u_image").toString()==null){
					MessageUtil.showBox("该用户未上传照片", SWT.ICON_ERROR);
					return ;
				}else{
					image = list.get(0).get("u_image").toString();
					file = ImageUtils.getTargetPath("upload");
					ImageUtils.showImg(label_1, file+image);
				}
				
			}
		});
		menuItem_1.setText("\u67E5\u770B\u7167\u7247");
		
		TableColumn tableColumn = new TableColumn(table_1, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u5173\u6CE8\u597D\u53CB");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if(page != 1){
					page =1;
					querySome("select * from userlist where u_staus=1 ");
				}else{
					MessageUtil.showBox("已经是第一页了", SWT.ICON_WARNING);
				}
			
			}
		});
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u9996\u9875-\u9009\u4E2D.png"));
		button_1.setBounds(31, 501, 80, 27);
		button_1.setText("\u9996\u9875");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if(page != 1){
					page =1;
					querySome("select * from userlist where u_staus=1 ");
				}else{
					MessageUtil.showBox("已经是第一页了", SWT.ICON_WARNING);
				}
				
				
			}
		});
		button_2.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0A\u4E00\u9875 (1).png"));
		button_2.setBounds(159, 501, 80, 27);
		button_2.setText("\u4E0A\u4E00\u9875");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				if(page != getTotalPage()){
					page = getTotalPage();
					querySome("select * from userlist where u_staus=1 ");
			}else{
					MessageUtil.showBox("已经是尾页了", SWT.ICON_WARNING);
			}

				
			}
		});
		button_3.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0B\u4E00\u9875 (1).png"));
		button_3.setBounds(293, 501, 80, 27);
		button_3.setText("\u4E0B\u4E00\u9875");
		
		Button button_4 = new Button(shell, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(page != getTotalPage()){
					page = getTotalPage();
					querySome("select * from userlist where u_staus=1 ");
			}else{
					MessageUtil.showBox("已经是尾页了", SWT.ICON_WARNING);
			}
			
			}
		});
		button_4.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5C3E\u9875.png"));
		button_4.setBounds(428, 501, 80, 27);
		button_4.setText("\u5C3E\u9875");
		
		
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(487, 106, 113, 17);
		label_2.setText("\u67E5\u770B\u4ED6\uFF08\u5979\uFF09\u7684\u7167\u7247\uFF1A");

	}
	public void  querySome(String sql){
        table_1.removeAll();
 		List<Map<String, Object>> list=db.query(sql+" limit "+(page-1)*pageSize+","+pageSize+"");

		if(list.size()==0){
			MessageUtil.showBox("查询结果为空！！！", SWT.ICON_ERROR);
			return ;
		}
		for (Map<String, Object> map:list) {
			TableItem tableItem = new TableItem(table_1, SWT.NONE);
			tableItem.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
		String[] arr={
				ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_id")),
				ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_name")),
				ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_sex")),
				ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_date")),
				ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_chicek")),
				ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_remarks"))
			
		};
		tableItem.setText(arr);
		//给当前的TableItem上绑定当前reader的id  删除和修改
		tableItem.setData(map.get("u_id"));
	

}
	}
}
