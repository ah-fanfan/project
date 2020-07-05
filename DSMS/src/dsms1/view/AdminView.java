package dsms1.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import dsms1.editor.StudentAddEditor;
import dsms1.util.MyInput;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class AdminView extends ViewPart {

	public static final String ID = "dsms1.view.AdminView"; //$NON-NLS-1$

	public AdminView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		
		Button button = new Button(container, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MyInput input=new MyInput();
				input.setName("学员信息添加");
				input.setToolTipTxt("学员信息添加");
				try {
					getSite().getWorkbenchWindow().getActivePage().openEditor(input, StudentAddEditor.ID);
				} catch (PartInitException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
			}
		});
		button.setBounds(67, 47, 80, 27);
		button.setText("\u5B66\u5458\u4FE1\u606F\u7BA1\u7406");
		
		Button button_1 = new Button(container, SWT.NONE);
		button_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		button_1.setBounds(67, 112, 80, 27);
		button_1.setText("\u6559\u7EC3\u4FE1\u606F\u7BA1\u7406");
		
		Button button_2 = new Button(container, SWT.NONE);
		button_2.setBounds(67, 180, 80, 27);
		button_2.setText("\u7F34\u8D39\u4FE1\u606F\u7BA1\u7406");
		
		Button button_3 = new Button(container, SWT.NONE);
		button_3.setBounds(67, 252, 80, 27);
		button_3.setText("\u7EA6\u8F66\u4FE1\u606F\u7BA1\u7406");
		
		Button button_4 = new Button(container, SWT.NONE);
		button_4.setBounds(67, 362, 80, 27);
		button_4.setText("\u90E8\u95E8\u4FE1\u606F\u7BA1\u7406");
		
		Button btnNewButton = new Button(container, SWT.NONE);
		btnNewButton.setBounds(67, 309, 80, 27);
		btnNewButton.setText("\u8003\u8BD5\u4FE1\u606F\u7BA1\u7406");

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
}
