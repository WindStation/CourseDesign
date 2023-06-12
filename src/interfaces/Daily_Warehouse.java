package interfaces;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import model.Operator;
import model.WarehouseInfo;
import service.OperatorService;
import service.WarehouseService;

import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Daily_Warehouse {

	protected Shell shell;
	private Text IdText;
	private Text nameText;
	private Text capText;
	private Text telText;
	private Table table;
	private Text noteText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Daily_Warehouse window = new Daily_Warehouse();
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
		shell.setSize(991, 676);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(403, 10, 113, 20);
		label.setText("仓库信息管理");
		
		Label lblId = new Label(shell, SWT.NONE);
		lblId.setBounds(10, 46, 76, 20);
		lblId.setText("编号");
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setBounds(10, 86, 76, 20);
		lblName.setText("名称");
		
		Label lblCap = new Label(shell, SWT.NONE);
		lblCap.setBounds(10, 125, 76, 20);
		lblCap.setText("容量");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 168, 92, 20);
		lblNewLabel.setText("联系人电话");
		
		IdText = new Text(shell, SWT.BORDER);
		IdText.setBounds(103, 46, 225, 26);
		
		nameText = new Text(shell, SWT.BORDER);
		nameText.setBounds(103, 86, 225, 26);
		
		capText = new Text(shell, SWT.BORDER);
		capText.setBounds(103, 125, 225, 26);
		
		telText = new Text(shell, SWT.BORDER);
		telText.setBounds(103, 168, 225, 26);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 250, 601, 274);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("编号");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("名称");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(88);
		tblclmnNewColumn_2.setText("容量");
		
		TableColumn tblclmnDirectortel = new TableColumn(table, SWT.NONE);
		tblclmnDirectortel.setWidth(141);
		tblclmnDirectortel.setText("联系人电话");
		
		TableColumn tblclmnNote = new TableColumn(table, SWT.NONE);
		tblclmnNote.setWidth(146);
		tblclmnNote.setText("备注");
		
		Button find = new Button(shell, SWT.NONE);
		find.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id=IdText.getText();
				
				WarehouseInfo warehouse=WarehouseService.find(id);
				
				if(warehouse!=null) {
					TableItem item=new TableItem(table,SWT.NONE);
					item.setText(0, warehouse.getId());
		            item.setText(1, warehouse.getName());
		            item.setText(2, String.valueOf(warehouse.getCapacity()));
		            item.setText(3,warehouse.getDirectorTel());
		            item.setText(4,warehouse.getNote());
				}else {
					// 查询结果为空的处理逻辑
				    MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				    messageBox.setMessage("仓库不存在");
				    messageBox.open();
				}
			}
		});
		find.setBounds(385, 42, 98, 30);
		find.setText("查询");
		
		Button insert = new Button(shell, SWT.NONE);
		insert.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取要新增的管理员信息
		        String id = IdText.getText();
		        String name = nameText.getText();
		        int capacity = Integer.valueOf(capText.getText());
		        String tel = telText.getText();
		        String note = noteText.getText();
		        WarehouseInfo warehouse=new WarehouseInfo(id,name,capacity,tel,note);
		        		
		        WarehouseService.insert(warehouse);		   
		    }
		});
		insert.setText("新增");
		insert.setBounds(513, 42, 98, 30);
		
		Button delete = new Button(shell, SWT.NONE);
		delete.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取要删除的管理员ID
		        String id = IdText.getText();
		        
		        // 调用OperatorService的删除方法
		        WarehouseService.delete(id);
		    }
		});
		delete.setText("删除");
		delete.setBounds(642, 42, 98, 30);
		
		Button update = new Button(shell, SWT.NONE);
		update.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id = IdText.getText();
		        String name = nameText.getText();
		        int capacity = Integer.valueOf(capText.getText());
		        String tel = telText.getText();
		        String note = noteText.getText();
		        WarehouseInfo warehouse=new WarehouseInfo(id,name,capacity,tel,note);
		        		
		        WarehouseService.update(warehouse);
			}
		});
		update.setText("修改");
		update.setBounds(767, 41, 98, 30);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(10, 211, 76, 20);
		label_1.setText("备注");
		
		noteText = new Text(shell, SWT.BORDER);
		noteText.setBounds(103, 211, 225, 26);

	}
}
