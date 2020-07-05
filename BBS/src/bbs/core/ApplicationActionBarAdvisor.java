package bbs.core;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

import bbs.action.CloseAction;
import bbs.dialog.LoginDialog;
import bbs.view.ManagerView;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	private CloseAction ca;
    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	ca=new CloseAction();
    	ca.setText("Close¡­¡­¡­¡­¡­¡­");
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	IMenuManager f =new MenuManager("Ê×Ò³");
    	f.add(ca);
    	//menuBar.add(f);
    	if("1".equals(LoginDialog.power)){
			menuBar.add(f);
		}
    }
    
}