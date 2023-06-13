package interfaces;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.*;
import org.eclipse.wb.swt.SWTResourceManager;

import service.OperatorService;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import model.*;

public class Daily_Account {

	protected Shell shell;
	private Table table;
	private Text idText;
	private Text passwordText;
	private Text nameText;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Daily_Account window = new Daily_Account();
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
		shell.setSize(898, 592);
		shell.setText("SWT Application");
		
		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		label.setBounds(348, 10, 140, 35);
		label.setText("操作员账户管理");
		
		Button find = new Button(shell, SWT.NONE);
		find.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id=idText.getText();
				
				if(id==null || id.trim().equals("")) {
					// 查找全部
					List<Operator> operators = OperatorService.findAll();
					table.removeAll();
					operators.forEach(operator->{
						TableItem item=new TableItem(table,SWT.NONE);
						item.setText(0, operator.getId());
			            item.setText(1, operator.getName());
			            item.setText(2, operator.getPassword());
					});
					return;
				}
				
				Operator operator=OperatorService.find(id);
				table.removeAll();
				
				if(operator!=null) {
					TableItem item=new TableItem(table,SWT.NONE);
					item.setText(0, operator.getId());
		            item.setText(1, operator.getName());
		            item.setText(2, operator.getPassword());
				}else {
					// 查询结果为空的处理逻辑
				    MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				    messageBox.setMessage("管理员不存在");
				    messageBox.open();
				}
			}
		});
		find.setBounds(336, 51, 98, 30);
		find.setText("查询");
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(84, 199, 622, 271);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(171);
		tblclmnNewColumn.setText("Id");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(209);
		tblclmnNewColumn_1.setText("Name");
		
		TableColumn tblclmnNewColumn_2 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_2.setWidth(249);
		tblclmnNewColumn_2.setText("Password");
		
		Label lblId_1 = new Label(shell, SWT.NONE);
		lblId_1.setBounds(20, 56, 76, 20);
		lblId_1.setText("Id");
		
		Label lblPassword = new Label(shell, SWT.NONE);
		lblPassword.setBounds(20, 98, 76, 20);
		lblPassword.setText("Password");
		
		Label lblName = new Label(shell, SWT.NONE);
		lblName.setBounds(20, 145, 76, 20);
		lblName.setText("Name");
		
		idText = new Text(shell, SWT.BORDER);
		idText.setBounds(97, 55, 206, 26);
		
		passwordText = new Text(shell, SWT.BORDER);
		passwordText.setBounds(97, 95, 206, 26);
		
		nameText = new Text(shell, SWT.BORDER);
		nameText.setBounds(97, 139, 206, 26);
		
		Button insert = new Button(shell, SWT.NONE);
		insert.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取要新增的管理员信息
		        String id = idText.getText();
		        String name = nameText.getText();
		        String password = passwordText.getText();
		        Operator operator=new Operator(id,name,password);
		        		
		        OperatorService.insert(operator);		   
		    }
		});
		insert.setBounds(465, 51, 98, 30);
		insert.setText("新增");
		
		Button update = new Button(shell, SWT.NONE);
		update.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        
		        String id = idText.getText();
		        String name = nameText.getText();
		        String password = passwordText.getText();
		        Operator operator=new Operator(id,name,password);
		        
		        OperatorService.update(operator);
		        
		        // 更新表格中相应的行显示		      
		    }
		});
		update.setText("修改");
		update.setBounds(600, 51, 98, 30);
		
		Button delete = new Button(shell, SWT.NONE);
		delete.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取要删除的管理员ID
		        String id = idText.getText();
		        
		        // 调用OperatorService的删除方法
		        OperatorService.delete(id);
		    }
		});
		delete.setText("删除");
		delete.setBounds(743, 51, 98, 30);
		
		Button outputButton = new Button(shell, SWT.NONE);
		
		outputButton.setText("显示全部");
		outputButton.setBounds(336, 98, 98, 30);

	}
}
