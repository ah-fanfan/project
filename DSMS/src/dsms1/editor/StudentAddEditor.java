package dsms1.editor;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;

import dsms1.util.MessageUtil;
import dsms1.util.DbUtil;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class StudentAddEditor extends EditorPart {

	public static final String ID = "dsms1.editor.StudentAddEditor"; //$NON-NLS-1$
	private Text text;
	private Text text_1;
	private Text text_2;
	private Text text_3;
	private DbUtil db=new DbUtil();
	

	public StudentAddEditor() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		Label label_1 = new Label(container, SWT.NONE);
		label_1.setText("\u59D3\u540D\uFF1A");
		label_1.setBounds(48, 37, 61, 17);
		
		Label label_2 = new Label(container, SWT.NONE);
		label_2.setText("\u6027\u522B\uFF1A");
		label_2.setBounds(293, 47, 61, 17);
		
		Label label_3 = new Label(container, SWT.NONE);
		label_3.setText("\u5E74\u9F84\uFF1A");
		label_3.setBounds(48, 101, 61, 17);
		
		Label label_4 = new Label(container, SWT.NONE);
		label_4.setText("\u5730\u5740\uFF1A");
		label_4.setBounds(48, 310, 61, 17);
		
		Label label_5 = new Label(container, SWT.NONE);
		label_5.setText("\u7535\u8BDD\uFF1A");
		label_5.setBounds(293, 101, 61, 17);
		
		Label label_6 = new Label(container, SWT.NONE);
		label_6.setText("\u62A5\u8003\u7C7B\u578B\uFF1A");
		label_6.setBounds(48, 174, 61, 17);
		
		Label label_7 = new Label(container, SWT.NONE);
		label_7.setText("\u7167\u7247\uFF1A");
		label_7.setBounds(293, 246, 61, 17);
		
		Label label_8 = new Label(container, SWT.NONE);
		label_8.setBounds(49, 246, 44, 17);
		label_8.setText("\u5BC6\u7801\uFF1A");
		
		Label label_9 = new Label(container, SWT.NONE);
		label_9.setBounds(293, 174, 61, 17);
		label_9.setText("\u79D1\u76EE\u9636\u6BB5\uFF1A");
		
		Label lblNewLabel = new Label(container, SWT.BORDER);
		lblNewLabel.setBounds(354, 245, 117, 149);
		
		text = new Text(container, SWT.BORDER);
		text.setBounds(111, 34, 73, 23);
		
		text_1 = new Text(container, SWT.BORDER);
		text_1.setBounds(111, 101, 73, 23);
		
		text_2 = new Text(container, SWT.BORDER);
		text_2.setBounds(111, 246, 73, 23);
		
		text_3 = new Text(container, SWT.BORDER);
		text_3.setBounds(360, 101, 73, 23);
		
		Button button = new Button(container, SWT.RADIO);
		button.setBounds(348, 47, 33, 17);
		button.setText("\u7537");
		
		Button button_1 = new Button(container, SWT.RADIO);
		button_1.setText("\u5973");
		button_1.setBounds(408, 47, 33, 17);
		
		Combo combo = new Combo(container, SWT.NONE);
		combo.setItems(new String[] {"\u79D1\u76EE\u4E00", "\u79D1\u76EE\u4E8C", "\u79D1\u76EE\u4E09", "\u79D1\u76EE\u56DB", "\u79D1\u76EE\u4E94"});
		combo.setBounds(360, 171, 88, 25);
		
		Combo combo_1 = new Combo(container, SWT.NONE);
		combo_1.setItems(new String[] {"A1", "A2", "B1", "B2", "C1", "C2"});
		combo_1.setBounds(107, 171, 88, 25);
		
		Combo combo_2 = new Combo(container, SWT.NONE);
		combo_2.setItems(new String[] {"\u56DB\u5DDD\u7701", "\u7518\u8083\u7701"});
		combo_2.setBounds(107, 302, 52, 25);
		
		Combo combo_3 = new Combo(container, SWT.NONE);
		combo_3.setItems(new String[] {"\u6210\u90FD", "\u7EF5\u9633", "\u7709\u5C71", "\u5170\u5DDE", "\u5E73\u51C9", "\u5929\u6C34"});
		combo_3.setBounds(165, 302, 52, 25);
		
		Combo combo_4 = new Combo(container, SWT.NONE);
		combo_4.setItems(new String[] {"\u6B66\u4FAF\u533A", "\u9752\u7F8A\u533A", "\u9AD8\u65B0\u533A", "\u6210\u534E\u533A", "\u5B89\u5B81\u533A", "\u57CE\u5173\u533A", "\u897F\u56FA\u533A"});
		combo_4.setBounds(223, 302, 52, 25);
		
		Button button_2 = new Button(container, SWT.NONE);
		button_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
				String name=text.getText().trim();
				String sex="";
				int age=Integer.parseInt(text_1.getText());
				String number=text_2.getText().trim();
				String psw=text_3.getText().trim();
				String type=combo.getText().trim();
				String stage=combo_1.getText().trim();
				String address=combo_2.getText().trim()+combo_3.getText().trim()+combo_4.getText().trim();
				String sql="insert into student "
						+ "(s_name,s_sex,s_age,s_pnum,s_address,s_type,s_stage,s_imag,s_paw,s_staus)"
						+ "values(?,?,?,?,?,?,?,?,?,?)";
				int res=db.update(sql, name,sex,age,number ,address,stage,type,psw,1);
				if(res>0){
					MessageUtil.showBox("添加成功", SWT.ICON_WORKING);
				}else{
					MessageUtil.showBox("添加失败", SWT.ICON_ERROR);
				}
			}
		});
		button_2.setBounds(259, 421, 80, 27);
		button_2.setText("\u4FDD\u5B58");

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
		this.setInput(input);
		this.setSite(site);
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
