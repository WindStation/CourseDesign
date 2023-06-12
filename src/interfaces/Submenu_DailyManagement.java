package interfaces;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Submenu_DailyManagement {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Submenu_DailyManagement window = new Submenu_DailyManagement();
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
		shell.setSize(814, 556);
		shell.setText("SWT Application");
		
		Button daily_account = new Button(shell, SWT.NONE);
		daily_account.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Daily_Account daily_account=new Daily_Account();
				daily_account.open();
			}
		});
		daily_account.setBounds(63, 389, 164, 46);
		daily_account.setText("操作员账户管理");
		
		Button daily_warehouse = new Button(shell, SWT.NONE);
		daily_warehouse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Daily_Warehouse daily_warehouse=new Daily_Warehouse();
				daily_warehouse.open();
			}
		});
		daily_warehouse.setText("仓库信息管理");
		daily_warehouse.setBounds(298, 389, 164, 46);
		
		Button daily_goods = new Button(shell, SWT.NONE);
		daily_goods.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Daily_Goods daily_goods=new Daily_Goods();
				daily_goods.open();
			}
		});
		daily_goods.setText("商品信息管理");
		daily_goods.setBounds(541, 389, 164, 46);

	}
}
