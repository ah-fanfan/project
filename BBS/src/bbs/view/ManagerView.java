package bbs.view;

import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;
import org.eclipse.wb.swt.SWTResourceManager;

import bbs.Editor.UserManagerment;
import bbs.dialog.LoginDialog;
import bbs.dialog.ManagerCountDialog;
import bbs.dialog.ManagerPswDialog;
import bbs.dialog.NoticeManagerDialog;
import bbs.util.DbUtil;
import bbs.util.MessageUtil;
import bbs.util.MyInput;
import bbs.util.ValidateobjectIsNull;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;

public class ManagerView extends ViewPart {

	public static final String ID = "bbs.view.ManagerView"; //$NON-NLS-1$
	private Table table;
	private DbUtil db=new DbUtil();
	private int page = 1;//当前页
	private int pageSize=13;//每页显示的行数
	public ManagerView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
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

	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\u=1180161757,800033911&fm=26&gp=0.jpg"));
		
		Button button = new Button(container, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u6CE8\u518C (1).png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				MyInput input =new MyInput();
				input.setName("网友信息管理");
				input.setToolTipTxt("网友信息管理");
				try {
					getSite().getWorkbenchWindow().getActivePage().openEditor(input,UserManagerment.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			
				
				
			}
		});
		button.setBounds(53, 44, 112, 40);
		button.setText("\u7F51\u53CB\u4FE1\u606F\u7BA1\u7406");
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u516C\u544A (1).png"));
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				NoticeManagerDialog nd=new NoticeManagerDialog(new Shell(), SWT.NONE);
				nd.open();
			}
		});
		button_1.setBounds(237, 44, 112, 40);
		button_1.setText("\u53D1\u5E03\u516C\u544A");
		
		Button button_3 = new Button(container, SWT.NONE);
		button_3.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5BC6\u7801.png"));
		button_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ManagerPswDialog mp=new ManagerPswDialog(new Shell(), SWT.NONE);
				mp.open();
			}
		});
		button_3.setBounds(670, 44, 112, 40);
		button_3.setText("\u5BC6\u7801\u4FEE\u6539");
		
		table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(43, 140, 765, 323);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7F16\u53F7");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(80);
		tableColumn_5.setText("\u6807\u9898");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u53D1\u5E03\u4EBA");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u7C7B\u578B");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(200);
		tableColumn_3.setText("\u5185\u5BB9");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(180);
		tableColumn_4.setText("\u65E5\u671F");
		
		Menu menu = new Menu(table);
		table.setMenu(menu);
		
		MenuItem menuItem = new MenuItem(menu, SWT.NONE);
		menuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				queryAll();
			}
		});
		menuItem.setText("\u67E5\u8BE2");
		
		MenuItem menuItem_1 = new MenuItem(menu, SWT.NONE);
		menuItem_1.addSelectionListener(new SelectionAdapter() {
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
		menuItem_1.setText("\u5220\u9664");
		
		Button button_2 = new Button(container, SWT.NONE);
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
		button_2.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u9996\u9875-\u9009\u4E2D.png"));
		button_2.setBounds(69, 511, 80, 27);
		button_2.setText("\u9996\u9875");
		
		Button button_4 = new Button(container, SWT.NONE);
		button_4.addSelectionListener(new SelectionAdapter() {
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
		button_4.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5C3E\u9875.png"));
		button_4.setBounds(678, 511, 80, 27);
		button_4.setText("\u5C3E\u9875");
		
		Button button_5 = new Button(container, SWT.NONE);
		button_5.addSelectionListener(new SelectionAdapter() {
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
		button_5.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0A\u4E00\u9875 (1).png"));
		button_5.setBounds(269, 511, 80, 27);
		button_5.setText("\u4E0A\u4E00\u9875");
		
		Button button_6 = new Button(container, SWT.NONE);
		button_6.addSelectionListener(new SelectionAdapter() {
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
		button_6.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5206\u9875 \u4E0B\u4E00\u9875 (1).png"));
		button_6.setBounds(472, 511, 80, 27);
		button_6.setText("\u4E0B\u4E00\u9875");
		
		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u7EDF\u8BA1 (2).png"));
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				ManagerCountDialog mc=new ManagerCountDialog(new Shell(), SWT.NONE);
				mc.open();
			}
		});
		btnNewButton.setBounds(460, 44, 112, 40);
		btnNewButton.setText("\u70ED\u70B9\u52A8\u6001\u7EDF\u8BA1");

		createActions();
		initializeToolBar();
		initializeMenu();
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		IToolBarManager toolbarManager = getViewSite().getActionBars().getToolBarManager();
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		IMenuManager menuManager = getViewSite().getActionBars().getMenuManager();
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
	public void  queryAll() {
		table.removeAll();
		String sql="select * from notice where n_staus=1 and n_set=?";
		List<Map<String, Object>> list=db.query(sql+" limit "+(page-1)*pageSize+","+pageSize+"", LoginDialog.name);
		for (Map<String, Object> map:list) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			String[] arr={
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("n_id")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("n_head")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("n_set")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("n_type")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("n_body")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("n_date"))+"  "+
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("n_time")),
			};
			tableItem.setText(arr);
			//给当前的TableItem上绑定当前reader的id  删除和修改
			tableItem.setData(map.get("t_id"));
		}
		
	}
}
