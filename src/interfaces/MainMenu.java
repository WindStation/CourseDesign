package interfaces;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class MainMenu {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainMenu window = new MainMenu();
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
		shell.setSize(1331, 829);
		shell.setText("SWT Application");
		
		Button entry_btn = new Button(shell, SWT.NONE);
		entry_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				EntryWindow window = new EntryWindow();
				window.open();
			}
		});
		entry_btn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		entry_btn.setBounds(605, 117, 138, 45);
		entry_btn.setText("货品入库");
		
		Button deliver_btn = new Button(shell, SWT.NONE);
		deliver_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				DeliverWindow window = new DeliverWindow();
				window.open();
			}
		});
		deliver_btn.setText("货品出库");
		deliver_btn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		deliver_btn.setBounds(605, 187, 138, 45);
		
		Button entrysttt_btn = new Button(shell, SWT.NONE);
		entrysttt_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Statistics_EntryInfo info = new Statistics_EntryInfo();
				info.open();
			}
		});
		entrysttt_btn.setText("入库报表统计");
		entrysttt_btn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		entrysttt_btn.setBounds(605, 293, 138, 45);
		
		Button deliversttt_btn = new Button(shell, SWT.NONE);
		deliversttt_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Statistics_DeliverInfo info = new Statistics_DeliverInfo();
				info.open();
			}
		});
		deliversttt_btn.setText("出库报表统计");
		deliversttt_btn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		deliversttt_btn.setBounds(605, 369, 138, 45);
		
		Label label = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setBounds(233, 238, 862, 25);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 22, SWT.NORMAL));
		label_1.setBounds(549, 10, 232, 38);
		label_1.setText("商品库存管理系统");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label_2.setBounds(434, 339, 80, 27);
		label_2.setText("统计报表");
		
		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(233, 448, 862, 25);
		
		Label label_2_1 = new Label(shell, SWT.NONE);
		label_2_1.setText("日常管理");
		label_2_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label_2_1.setBounds(434, 582, 80, 27);
		
		Button goodmana_btn = new Button(shell, SWT.NONE);
		goodmana_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Daily_Goods goods = new Daily_Goods();
				goods.open();
			}
		});
		goodmana_btn.setText("商品信息管理");
		goodmana_btn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		goodmana_btn.setBounds(605, 500, 138, 45);
		
		Button warehousemana_btn = new Button(shell, SWT.NONE);
		warehousemana_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Daily_Warehouse warehouse = new Daily_Warehouse();
				warehouse.open();
			}
		});
		warehousemana_btn.setText("仓库信息管理");
		warehousemana_btn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		warehousemana_btn.setBounds(605, 574, 138, 45);
		
		Button accountmana_btn = new Button(shell, SWT.NONE);
		accountmana_btn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Daily_Account account = new Daily_Account();
				account.open();
			}
		});
		accountmana_btn.setText("账户管理");
		accountmana_btn.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		accountmana_btn.setBounds(605, 648, 138, 45);
		
		Label label_2_2 = new Label(shell, SWT.NONE);
		label_2_2.setText("进出货");
		label_2_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label_2_2.setBounds(445, 154, 80, 27);

	}
}
