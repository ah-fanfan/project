package bbs.dialog;

import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import bbs.util.DbUtil;
import bbs.util.MessageUtil;
import bbs.util.ValidateobjectIsNull;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UserQueryDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table table;
	private DbUtil db=new DbUtil();
	private int page = 1;//当前页
	private int pageSize=12;//每页显示的行数


	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public int getTotalPage(){
		int totalPage=0;
		List<Map<String,Object>> list=db.query("select count(*) as num from text where t_staus = 1 and t_set= "+"'"+LoginDialog.name+"'");
		int count=Integer.parseInt(list.get(0).get("num").toString());
		if(count % pageSize == 0){
			totalPage = count / pageSize;
		}else{
			totalPage = count / pageSize + 1;
		}
		return totalPage;
	}

	public UserQueryDialog(Shell parent, int style) {
		super(parent, style);
		setText("历史查询");
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
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u67E5\u8BE2.png"));
		shell.setSize(606, 529);
		shell.setText(getText());
		//背景透明
		shell.setBackgroundMode(SWT.DEFAULT);
		shell.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(22, 75, 565, 331);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("\u7C7B\u578B");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(120);
		tableColumn_1.setText("\u6807\u9898");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u5185\u5BB9");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(150);
		tableColumn_3.setText("\u53D1\u5E03\u65F6\u95F4");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//管理员信息删除
					TableItem[] items = table.getSelection();
					if (items.length==0) {
						MessageUtil.showBox("请至少选中一条数据", SWT.ICON_WARNING);
						return ;
					}
					int result = MessageUtil.showBox("您确定要删除吗？", SWT.ICON_QUESTION| SWT.OK| SWT.ICON_CANCEL);
					if (result ==32 ) {
						String sql = "update text set t_staus = 0 where t_id in(";
						for (TableItem item :items) {
							Object id = item.getData();
							sql += id+",";
						}
						sql = sql.substring(0,sql.length()-1);
						sql+=")";
						int res = db.update(sql);
						if (res >0) {
							MessageUtil.showBox("删除成功", SWT.ICON_WORKING);
							//删除后自动查询
							queryAll();
						}else{
							MessageUtil.showBox("遇到了一些问题，删除失败", SWT.ICON_ERROR);
						}
					} 
				}
			
			
		});
		menuItem.setText("\u5220\u9664");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				queryAll();
			}
		});
		menuItem_1.setText("\u67E5\u8BE2");
		
		Button button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(page != 1){
					page =1;
					queryAll();
				}else{
					MessageUtil.showBox("已经是第一页了", SWT.ICON_WARNING);
				}
			
				
			}
		});
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u9996\u9875-\u9009\u4E2D.png"));
		button.setBounds(41, 443, 80, 27);
		button.setText("\u9996\u9875");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(page != getTotalPage()){
					page = getTotalPage();
					queryAll();
			}else{
					MessageUtil.showBox("已经是尾页了", SWT.ICON_WARNING);
			}
			
				
				
			}
		});
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5C3E\u9875.png"));
		button_1.setBounds(485, 443, 80, 27);
		button_1.setText("\u5C3E\u9875");
		
		Button button_2 = new Button(shell, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(page != 1){
					page =1;
					queryAll();
				}else{
					MessageUtil.showBox("已经是第一页了", SWT.ICON_WARNING);
				}
				
			}
		});
		button_2.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0A\u4E00\u9875 (1).png"));
		button_2.setBounds(187, 443, 80, 27);
		button_2.setText("\u4E0A\u4E00\u9875");
		
		Button button_3 = new Button(shell, SWT.NONE);
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(page != getTotalPage()){
					page = getTotalPage();
					queryAll();
			}else{
					MessageUtil.showBox("已经是尾页了", SWT.ICON_WARNING);
			}
			}
		});
		button_3.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0B\u4E00\u9875 (1).png"));
		button_3.setBounds(342, 443, 80, 27);
		button_3.setText("\u4E0B\u4E00\u9875");

	}
	public void  queryAll() {
		table.removeAll();
		String sql="select * from text where t_staus=1 and t_set=?";
		List<Map<String, Object>> list=db.query(sql+" limit "+(page-1)*pageSize+","+pageSize+"", LoginDialog.name);
		for (Map<String, Object> map:list) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			String[] arr={
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_id")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_type")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_head")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_body")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_date")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_time"))
			};
			tableItem.setText(arr);
			//给当前的TableItem上绑定当前reader的id  删除和修改
			tableItem.setData(map.get("t_id"));
		}
		
	}
}
