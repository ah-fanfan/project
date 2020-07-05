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
		//��½���ڽ������
		if("����Ա".equals(LoginDialog.power)){
			//����Ա
			layout.addView(ManagerView.ID, layout.LEFT, 0.58f, layout.getEditorArea());
		}else if("��������Ա".equals(LoginDialog.power)){
			//��������Ա
			layout.addView(ManagerplusView.ID, IPageLayout.LEFT, 0.40f, layout.getEditorArea());
		}else  if("����".equals(LoginDialog.power)){
			//�û�
			layout.addView(UserView.ID, IPageLayout.LEFT, 0.39f, layout.getEditorArea());
		}
	}
}
