package bbs.core;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;
import bbs.dialog.LoginDialog;
import bbs.view.ManagerView;
import bbs.view.ManagerplusView;
import bbs.view.UserView;
public class Perspective implements IPerspectiveFactory {
	public void createInitialLayout(IPageLayout layout) {
		//登陆窗口界面分类
		if("管理员".equals(LoginDialog.power)){
			//管理员
			layout.addView(ManagerView.ID, layout.LEFT, 0.58f, layout.getEditorArea());
		}else if("超级管理员".equals(LoginDialog.power)){
			//超级管理员
			layout.addView(ManagerplusView.ID, IPageLayout.LEFT, 0.40f, layout.getEditorArea());
		}else  if("网友".equals(LoginDialog.power)){
			//用户
			layout.addView(UserView.ID, IPageLayout.LEFT, 0.39f, layout.getEditorArea());
		}
	}
}
