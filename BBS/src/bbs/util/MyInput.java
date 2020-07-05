package bbs.util;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IPersistableElement;

public class MyInput implements IEditorInput {
	public String name;
	public String age;
	
	public MyInput() {
		super();
	}
	public MyInput(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public void setToolTipTxt(String string) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public <T> T getAdapter(Class<T> adapter) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean exists() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public ImageDescriptor getImageDescriptor() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public IPersistableElement getPersistable() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getToolTipText() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
