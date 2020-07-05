package bbs.dialog;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.wb.swt.SWTResourceManager;

import bbs.util.DbUtil;
import bbs.util.ValidateobjectIsNull;
import bbs.util.MessageUtil;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TourModeDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	private Table table;
	private DbUtil db=new DbUtil();
	private Composite composite;
	private int page = 1;//当前页
	private int pageSize=12;//每页显示的行数

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public TourModeDialog(Shell parent, int style) {
		super(parent, style);
		setText("游客模式");
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
		shell.setSize(495, 581);
		shell.setText(getText());
		
		composite = new Composite(shell, SWT.NONE);
		composite.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\u=1180161757,800033911&fm=26&gp=0.jpg"));
		composite.setBounds(0, -26, 489, 578);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		table.setBounds(34, 90, 405, 305);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("\u7C7B\u578B");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("\u6807\u9898");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("\u5185\u5BB9");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("\u53D1\u5E03\u65F6\u95F4");
		
		Button button = new Button(composite, SWT.NONE);
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
		button.setText("\u9996\u9875");
		button.setBounds(33, 427, 80, 27);
		
		Button button_1 = new Button(composite, SWT.NONE);
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
		button_1.setText("\u4E0A\u4E00\u9875");
		button_1.setBounds(157, 427, 80, 27);
		
		Button button_2 = new Button(composite, SWT.NONE);
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
		button_2.setText("\u4E0B\u4E00\u9875");
		button_2.setBounds(273, 427, 80, 27);
		
		Button button_3 = new Button(composite, SWT.NONE);
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
		button_3.setText("\u5C3E\u9875");
		button_3.setBounds(384, 427, 80, 27);
		
		Button button_4 = new Button(composite, SWT.NONE);
		button_4.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u67E5\u770B.png"));
		button_4.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				queryAll();
			}
		});
		button_4.setText("\u67E5\u770B\u8FD1\u671F\u70ED\u70B9");
		button_4.setBounds(174, 33, 112, 27);

	}
	public void  queryAll() {
		table.removeAll();
		String sql="SELECT * FROM text WHERE t_staus=1 ";
		List<Map<String, Object>> list=db.query(sql+" limit "+(page-1)*pageSize+","+pageSize+"");
		for (Map<String, Object> map:list) {
			TableItem tableItem = new TableItem(table, SWT.NONE);
			tableItem.setBackground(SWTResourceManager.getColor(SWT.COLOR_LIST_SELECTION));
			String[] arr={
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_type")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_head")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_body")),
					ValidateobjectIsNull.ValidateobjectIsNull(map.get("t_date"))
			
			};
			tableItem.setText(arr);
			//给当前的TableItem上绑定当前reader的id  删除和修改
			tableItem.setData(map.get("u_id"));
		}
		
	}
	 public int getTotalPage(){
			int totalPage=0;
			List<Map<String,Object>> list=db.query("select count(*) as num from text where t_staus = 1");
			int count=Integer.parseInt(list.get(0).get("num").toString());
			if(count % pageSize == 0){
				totalPage = count / pageSize;
			}else{
				totalPage = count / pageSize + 1;
			}
			return totalPage;
		}

}
