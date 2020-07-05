package bbs.dialog;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.ISeries;
import org.swtchart.ISeries.SeriesType;

import bbs.util.DbUtil;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.wb.swt.SWTResourceManager;

public class UserCountDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	 private double[] ySeries =null;//纵轴上的值

	    private String[] cagetorySeries = { "政治", "军事",
	            "文化", "科技", "生活" };//横轴
	    private DbUtil db=new DbUtil();


	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public UserCountDialog(Shell parent, int style) {
		super(parent, style);
		setText("用户动态类型统计");
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
		shell.setImage(SWTResourceManager.getImage("C:\\Users\\\u51E1CC\\Desktop\\\u8BBA\u575B\\image\\\u7EDF\u8BA1.png"));
		shell.setSize(796, 472);
		shell.setText(getText());
		//1.设置shell布局方式
		shell.setLayout(new FillLayout());
		//2.查询数据
				List<Map<String, Object>> list1=db.query("SELECT t_type,COUNT(*) AS num FROM text WHERE t_set="+"'"+LoginDialog.name+"'"+
						" AND t_type='政治' AND t_staus=1");
				List<Map<String, Object>> list2=db.query("SELECT t_type,COUNT(*) AS num FROM text WHERE t_set="+"'"+LoginDialog.name+"'"+
						" AND t_type='军事' AND t_staus=1");
				List<Map<String, Object>> list3=db.query("SELECT t_type,COUNT(*) AS num FROM text WHERE t_set="+"'"+LoginDialog.name+"'"+
						" AND t_type='文化' AND t_staus=1");
				List<Map<String, Object>> list4=db.query("SELECT t_type,COUNT(*) AS num FROM text WHERE t_set="+"'"+LoginDialog.name+"'"+
						" AND t_type='科技' AND t_staus=1");
				List<Map<String, Object>> list5=db.query("SELECT t_type,COUNT(*) AS num FROM text WHERE t_set="+"'"+LoginDialog.name+"'"+
						" AND t_type='生活' AND t_staus=1");
				ySeries=new double[5];
			    ySeries[0]=Double.parseDouble(list1.get(0).get("num").toString());
			    ySeries[1]=Double.parseDouble(list2.get(0).get("num").toString());
			    ySeries[2]=Double.parseDouble(list3.get(0).get("num").toString());
			    ySeries[3]=Double.parseDouble(list4.get(0).get("num").toString());
			    ySeries[4]=Double.parseDouble(list5.get(0).get("num").toString());
		//3.调用图表方法
			    createChart(shell);
		
	}
	public Chart createChart(Composite parent) {

	        // create a chart
	        Chart chart = new Chart(parent, SWT.NONE);
	        chart.getTitle().setText("尊敬的"+LoginDialog.name+"用户，您的动态类型统计表如下");

	        // set category
	        chart.getAxisSet().getXAxis(0).enableCategory(true);
	        chart.getAxisSet().getXAxis(0).setCategorySeries(cagetorySeries);
	        chart.getAxisSet().getXAxis(0).getTick().setTickLabelAngle(90);
	        chart.getAxisSet().getXAxis(0).getTitle().setText("类型");
	        chart.getAxisSet().getYAxis(0).getTitle().setText("数量");
	        // add bar series
	        ISeries barSeries = chart.getSeriesSet().createSeries(SeriesType.BAR,
	                "数量");
	        barSeries.setYSeries(ySeries);

	        chart.getAxisSet().adjustRange();
	        chart.setOrientation(SWT.HORIZONTAL);
	        return chart;
	    }

}
