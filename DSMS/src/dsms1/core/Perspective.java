package dsms1.core;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

//import dsms1.dialog.LoginDialog;
import dsms1.view.AdminView;
import dsms1.view.NormalView;

public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
	/*	if("1".equals(LoginDialog.userPower)){
			layout.addView(AdminView.ID, IPageLayout.LEFT, 0.25f, layout.getEditorArea());
		}
		else if("2".equals(LoginDialog.userPower)){
			layout.addView(NormalView.ID, IPageLayout.LEFT, 0.25f, layout.getEditorArea());
		}*/
	}
}
