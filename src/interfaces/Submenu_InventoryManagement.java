package interfaces;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Submenu_InventoryManagement {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Submenu_InventoryManagement window = new Submenu_InventoryManagement();
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
		shell.setSize(866, 552);
		shell.setText("SWT Application");
		
		Button inventory_view = new Button(shell, SWT.NONE);
		inventory_view.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Inventory_View inventory_view=new Inventory_View();
				inventory_view.open();
			}
		});
		inventory_view.setBounds(103, 376, 180, 45);
		inventory_view.setText("库存盘点");
		
		Button inventory_ship = new Button(shell, SWT.NONE);
		inventory_ship.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Inventory_Ship inventory_ship=new Inventory_Ship();
				inventory_ship.open();
			}
		});
		inventory_ship.setText("库存调拨");
		inventory_ship.setBounds(513, 376, 180, 45);

	}

}
