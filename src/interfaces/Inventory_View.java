package interfaces;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
//import org.eclipse.swt.widgets.List;
//import org.eclipse.swt.widgets.Combo;
//import org.eclipse.swt.widgets.Spinner;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;

public class Inventory_View {

	protected Shell shell;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Inventory_View window = new Inventory_View();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1017, 725);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label.setBounds(404, 10, 120, 47);
		label.setText("库存盘点");
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(41, 59, 76, 20);
		label_1.setText("从");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(175, 59, 28, 20);
		lblNewLabel.setText("至");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(22, 210, 884, 414);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("日期");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("货物名称");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(100);
		tblclmnNewColumn_2.setText("数量");
		
		TableColumn tblclmnNewColumn_3 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("采购单价");
		
		TableColumn tblclmnNewColumn_4 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_4.setWidth(100);
		tblclmnNewColumn_4.setText("校验员");
		
		TableColumn tblclmnNewColumn_5 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_5.setWidth(100);
		tblclmnNewColumn_5.setText("操作员");
		
		TableColumn tblclmnNewColumn_6 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_6.setWidth(100);
		tblclmnNewColumn_6.setText("New Column");
		
		TableColumn tblclmnNewColumn_7 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_7.setWidth(100);
		tblclmnNewColumn_7.setText("New Column");
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(61, 59, 110, 28);
		
		DateTime dateTime_1 = new DateTime(shell, SWT.BORDER);
		dateTime_1.setBounds(198, 59, 110, 28);
		
		Button button = new Button(shell, SWT.NONE);
		button.setBounds(760, 59, 98, 30);
		button.setText("查询");

	}
}
