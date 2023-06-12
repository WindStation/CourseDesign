package interfaces;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class Submenu_Statistics {

	protected Shell shell;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Submenu_Statistics window = new Submenu_Statistics();
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
		shell.setSize(1238, 763);
		shell.setText("统计报表");

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 21, SWT.NORMAL));
		label.setAlignment(SWT.CENTER);
		label.setBounds(444, 30, 312, 52);
		label.setText("统计报表");

		Label label_1 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_1.setBounds(388, 74, 428, 20);

		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 入库统计
				Statistics_EntryInfo entryInfoWin = new Statistics_EntryInfo();
				entryInfoWin.open();
			}
		});
		btnNewButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		btnNewButton.setBounds(468, 196, 272, 60);
		btnNewButton.setText("采购入库统计");

		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 出库统计
				Statistics_DeliverInfo deliverInfoWin = new Statistics_DeliverInfo();
				deliverInfoWin.open();
			}
		});
		btnNewButton_1.setText("出库统计");
		btnNewButton_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		btnNewButton_1.setBounds(468, 320, 272, 60);

		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 所有报表
				Statistics_All allWin = new Statistics_All();
				allWin.open();
			}
		});
		btnNewButton_2.setText("总览报表统计");
		btnNewButton_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		btnNewButton_2.setBounds(468, 447, 272, 60);

	}
}
