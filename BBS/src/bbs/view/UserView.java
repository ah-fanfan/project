package bbs.view;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.part.ViewPart;

import bbs.dialog.UserCountDialog;
import bbs.dialog.UserFriendsDialog;
import bbs.dialog.UserQueryDialog;
import bbs.dialog.UserTReleaseDialog;
import bbs.dialog.UserUpdateDialog;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;

public class UserView extends ViewPart {

	public static final String ID = "bbs.view.UserView"; //$NON-NLS-1$

	public UserView() {
	}

	/**
	 * Create contents of the view part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setBackgroundImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\u=3870427117,1873941938&fm=26&gp=0.jpg"));
		{
			Button button = new Button(container, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u7528\u6237\u4FEE\u6539\u4FE1\u606F.png"));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					UserUpdateDialog ud=new UserUpdateDialog(new Shell(), SWT.NONE);
					ud.open();
				}
			});
			button.setBounds(388, 35, 175, 50);
			button.setText("\u4FEE\u6539\u4FE1\u606F");
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u53D1\u5E03\u52A8\u6001.png"));
			button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					UserTReleaseDialog ur=new UserTReleaseDialog(new Shell(), SWT.NONE);
					ur.open();
				}
			});
			button.setBounds(388, 137, 175, 50);
			button.setText("\u53D1\u5E03\u52A8\u6001");
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u67E5\u8BE2\u5386\u53F2\u6E05\u7B97.png"));
			button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					UserQueryDialog uq=new UserQueryDialog(new Shell(), SWT.NONE);
					uq.open();
				}
			});
			button.setBounds(388, 244, 175, 50);
			button.setText("\u67E5\u8BE2\u5386\u53F2");
		}
		{
			Button button = new Button(container, SWT.NONE);
			button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
			button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u670B\u53CB.png"));
			button.addSelectionListener(new SelectionAdapter() {
				@Override
				public void widgetSelected(SelectionEvent e) {
					UserFriendsDialog uf=new UserFriendsDialog(new Shell(), SWT.None);
					uf.open();
				}
			});
			button.setBounds(388, 350, 175, 50);
			button.setText("\u8BA4\u8BC6\u670B\u53CB");
		}
		
		Button button = new Button(container, SWT.NONE);
		button.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u7EDF\u8BA1 (1).png"));
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserCountDialog uc=new UserCountDialog(new Shell(), SWT.NONE);
				uc.open();
			}
		});
		button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		button.setBounds(388, 460, 175, 50);
		button.setText("\u52A8\u6001\u7EDF\u8BA1");

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
