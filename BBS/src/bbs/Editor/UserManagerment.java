package bbs.Editor;

import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.internal.handlers.WizardHandler.New;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.wb.swt.SWTResourceManager;

import bbs.dialog.LoginDialog;
import bbs.dialog.UserAddDialog;
import bbs.util.DbUtil;
import bbs.util.MessageUtil;
import bbs.util.ValidateobjectIsNull;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class UserManagerment extends EditorPart {

	public static final String ID = "bbs.Editor.UserManagerment"; //$NON-NLS-1$
	private Table table;
    private DbUtil db=new DbUtil();
    private int page = 1;//当前页
	private int pageSize=16;//每页显示的行数
	public UserManagerment() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	public int getTotalPage(){
		int totalPage=0;
		List<Map<String,Object>> list=db.query("select count(*) as num from userlist where u_staus = 1 and u_set="+"'"+LoginDialog.name+"'");
		int count=Integer.parseInt(list.get(0).get("num").toString());
		if(count % pageSize == 0){
			totalPage = count / pageSize;
		}else{
			totalPage = count / pageSize + 1;
		}
		return totalPage;
	}

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\timg (1).jpg"));
		//背景透明
		container.setBackgroundMode(SWT.DEFAULT);
		container.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 25, 632, 377);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(50);
		tblclmnNewColumn.setText("\u7F16\u53F7");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(80);
		tblclmnNewColumn_1.setText("\u59D3\u540D");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(50);
		tblclmnNewColumn_2.setText("\u6027\u522B");
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(80);
		tableColumn.setText("\u51FA\u751F\u65E5\u671F");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(180);
		tableColumn_1.setText("\u4F4F\u5740");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(80);
		tableColumn_2.setText("\u4F1A\u5458\u7B49\u7EA7");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(120);
		tableColumn_3.setText("\u529E\u7406\u65F6\u95F4");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserAddDialog ua=new UserAddDialog(new Shell(), SWT.None);
				ua.open();
			}
		});
		menuItem.setText("\u6DFB\u52A0");
		
		MenuItem menuItem_2 = new MenuItem(menu, SWT.NONE);
		menuItem_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] items = table.getSelection();
				if (items.length==0) {
					MessageUtil.showBox("请至少选中一条数据", SWT.ICON_WARNING);
					return ;
				}
				int result = MessageUtil.showBox("您确定要删除吗？", SWT.ICON_QUESTION| SWT.OK| SWT.ICON_CANCEL);
				if (result ==32 ) {
					String sql = "update userlist set u_staus = 0 where u_id in(";
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
		menuItem_2.setText("\u5220\u9664");
		
		MenuItem menuItem_3 = new MenuItem(menu, SWT.NONE);
		menuItem_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				queryAll();
			}
		});
		menuItem_3.setText("\u67E5\u8BE2");
		
		Button button = new Button(container, SWT.NONE);
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
		button.setBounds(10, 418, 80, 27);
		button.setText("\u9996\u9875");
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
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
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0A\u4E00\u9875 (1).png"));
		button_1.setBounds(187, 418, 80, 27);
		button_1.setText("\u4E0A\u4E00\u9875");
		
		Button button_2 = new Button(container, SWT.NONE);
		button_2.addSelectionListener(new SelectionAdapter() {
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
		button_2.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0B\u4E00\u9875 (1).png"));
		button_2.setBounds(368, 418, 80, 27);
		button_2.setText("\u4E0B\u4E00\u9875");
		
		Button button_3 = new Button(container, SWT.NONE);
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
		button_3.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5C3E\u9875.png"));
		button_3.setBounds(552, 418, 80, 27);
		button_3.setText("\u5C3E\u9875");

	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// Initialize the editor part
		this.setSite(site);
		this.setInput(input);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
	public void  queryAll() {
		table.removeAll();
		String sql="SELECT * FROM userlist WHERE u_staus=1 AND u_set=?";
		List<Map<String, Object>> list=db.query(sql+" limit "+(page-1)*pageSize+","+pageSize+"",LoginDialog.name);
		for (Map<String, Object> map:list) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			String[] arr={
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_id")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_name")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_sex")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_date")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_address")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_chicek")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("u_settime"))
			};
			tableItem.setText(arr);
			//给当前的TableItem上绑定当前reader的id  删除和修改
			tableItem.setData(map.get("u_id"));
		}
		
	}
}
