package bbs.dialog;

import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Dialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.swtchart.Chart;
import org.swtchart.ISeries;
import org.swtchart.ISeries.SeriesType;

import bbs.util.DbUtil;
import org.eclipse.wb.swt.SWTResourceManager;

public class ManagerPlusCountDialog extends Dialog {

	protected Object result;
	protected Shell shell;
	  private  double[] ySeries = null;//�����ϵ�ֵ

	    private String[] cagetorySeries = { "1��", "2��",
	            "3��", "4��", "5��" };//����
	    private DbUtil db=new DbUtil();

	/**
	 * Create the dialog.
	 * @param parent
	 * @param style
	 */
	public ManagerPlusCountDialog(Shell parent, int style) {
		super(parent, style);
		setText("�û���Ա�ȼ�ͳ��");
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
		shell.setSize(706, 550);
		shell.setText(getText());
		//1.����shell���ַ�ʽ
				shell.setLayout(new FillLayout());
				//2.��ѯ����
						List<Map<String, Object>> list1=db.query("SELECT u_chicek,COUNT(*) AS num FROM userlist WHERE u_chicek= '1��'  AND u_staus=1");
						List<Map<String, Object>> list2=db.query("SELECT u_chicek,COUNT(*) AS num FROM userlist WHERE u_chicek= '2��'  AND u_staus=1");
						List<Map<String, Object>> list3=db.query("SELECT u_chicek,COUNT(*) AS num FROM userlist WHERE u_chicek= '3��'  AND u_staus=1");
						List<Map<String, Object>> list4=db.query("SELECT u_chicek,COUNT(*) AS num FROM userlist WHERE u_chicek= '4��'  AND u_staus=1");
						List<Map<String, Object>> list5=db.query("SELECT u_chicek,COUNT(*) AS num FROM userlist WHERE u_chicek= '5��'  AND u_staus=1");
						ySeries=new double[5];
					    ySeries[0]=Double.parseDouble(list1.get(0).get("num").toString());
					    ySeries[1]=Double.parseDouble(list2.get(0).get("num").toString());
					    ySeries[2]=Double.parseDouble(list3.get(0).get("num").toString());
					    ySeries[3]=Double.parseDouble(list4.get(0).get("num").toString());
					    ySeries[4]=Double.parseDouble(list5.get(0).get("num").toString());
				//3.����ͼ����
					    createChart(shell);

	}
 public Chart createChart(Composite parent) {

        // create a chart
        Chart chart = new Chart(parent, SWT.NONE);
        chart.getTitle().setText("��Ա�ȼ�ͳ�Ʊ�");

        // set category
        chart.getAxisSet().getXAxis(0).enableCategory(true);
        chart.getAxisSet().getXAxis(0).setCategorySeries(cagetorySeries);
        chart.getAxisSet().getXAxis(0).getTick().setTickLabelAngle(90);
        chart.getAxisSet().getXAxis(0).getTitle().setText("�ȼ�����");
        chart.getAxisSet().getYAxis(0).getTitle().setText("����");
        // add bar series
        ISeries barSeries = chart.getSeriesSet().createSeries(SeriesType.BAR,
                "����");
        barSeries.setYSeries(ySeries);

        chart.getAxisSet().adjustRange();
        chart.setOrientation(SWT.HORIZONTAL);
        return chart;
    }

}
