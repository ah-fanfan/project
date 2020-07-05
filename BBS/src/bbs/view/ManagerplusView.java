package bbs.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.OpenAndLinkWithEditorHelper;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import bbs.Editor.M_inforManagerment;
import bbs.Editor.VipUserManagerment;
import bbs.dialog.ManagerPlusCountDialog;
import bbs.dialog.ManagerPlusPsw;
import bbs.util.MyInput;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class ManagerplusView extends ViewPart {

	public static final String ID = "bbs.view.ManagerplusView"; //$NON-NLS-1$
	
	public ManagerplusView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\u=3818164871,2762279717&fm=26&gp=0.jpg"));
		{
			Button button = new Button(container, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u7BA1\u7406\u5458.png"));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
						MyInput input =new MyInput();
						input.setName("管理员信息管理");
						input.setToolTipTxt("管理员信息管理");
						try {
							getSite().getWorkbenchWindow().getActivePage().openEditor(input, M_inforManagerment.ID);
						} catch (PartInitException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				}
			});
			button.setBounds(63, 55, 175, 50);
			button.setText("\u7BA1\u7406\u5458\u4FE1\u606F\u7BA1\u7406");
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u4F1A\u5458.png"));
			button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {

					MyInput input =new MyInput();
					input.setName("会员信息管理");
					input.setToolTipTxt("会员信息管理");
					try {
						getSite().getWorkbenchWindow().getActivePage().openEditor(input, VipUserManagerment.ID);
					} catch (PartInitException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			
					
					
					
				}
			});
			button.setBounds(63, 213, 175, 50);
			button.setText("\u4F1A\u5458\u4FE1\u606F\u7BA1\u7406");
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u5BC6\u7801\u4FEE\u6539.png"));
			button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ManagerPlusPsw mp=new ManagerPlusPsw(new Shell(), SWT.None);
					mp.open();
				}
			});
			button.setBounds(63, 510, 175, 50);
			button.setText("\u5BC6\u7801\u4FEE\u6539");
		}
		{
			Button btnNewButton = new Button(container, SWT.NONE);
			btnNewButton.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u7EDF\u8BA1 (1).png"));
			btnNewButton.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					ManagerPlusCountDialog pc=new ManagerPlusCountDialog(new Shell(), SWT.NONE);
					pc.open();
				}
			});
			btnNewButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			btnNewButton.setBounds(63, 370, 175, 50);
			btnNewButton.setText("\u7528\u6237\u7B49\u7EA7\u7EDF\u8BA1");
		}

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
