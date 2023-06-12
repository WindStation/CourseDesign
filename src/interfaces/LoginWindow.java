package interfaces;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import control.Index;
import model.Manager;
import model.Operator;
import service.ManagerService;
import service.OperatorService;

public class LoginWindow {

	protected Shell shell;
	private Text loginId_text;
	private Text loginPW_text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LoginWindow window = new LoginWindow();
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
		shell.setSize(1321, 794);
		shell.setText("商品库存管理系统");

		loginId_text = new Text(shell, SWT.BORDER);
		loginId_text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		loginId_text.setBounds(526, 318, 305, 42);

		loginPW_text = new Text(shell, SWT.BORDER | SWT.PASSWORD);
		loginPW_text.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		loginPW_text.setBounds(524, 407, 307, 42);

		Label label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label.setBounds(372, 319, 90, 42);
		label.setText("用户名");

		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setText("密码");
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		label_1.setBounds(390, 408, 72, 42);

		Button login_operator = new Button(shell, SWT.NONE);
		login_operator.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 操作员登录按钮事件
				String loginId = loginId_text.getText();
				if (OperatorService.find(loginId) == null) {
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("该操作员不存在，请检查后重新输入！");
					box.open();
					loginId_text.setText("");
					loginPW_text.setText("");
					return;
				}
				Operator operator = OperatorService.find(loginId);
				String pw = loginPW_text.getText();
				if (!pw.equals(operator.getPassword())) {
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("密码错误，请重新输入！");
					box.open();
					loginPW_text.setText("");
					return;
				}

				// 登录成功
				Index.currentOperator = operator;
				MainMenu mainMenu = new MainMenu();
				shell.close();
				mainMenu.open();

			}
		});
		login_operator.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		login_operator.setBounds(574, 548, 171, 52);
		login_operator.setText("操作员登录");

		Button login_manager = new Button(shell, SWT.NONE);
		login_manager.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 管理员登录按钮事件
				String loginId = loginId_text.getText();
				if (ManagerService.find(loginId) == null) {
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("该管理员不存在，请检查后重新输入！");
					box.open();
					loginId_text.setText("");
					loginPW_text.setText("");
					return;
				}
				Manager manager = ManagerService.find(loginId);
				String pw = loginPW_text.getText();
				if (!pw.equals(manager.getPassword())) {
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("密码错误，请重新输入！");
					box.open();
					loginPW_text.setText("");
					return;
				}

				// 登录成功
				Index.currentManager = manager;
				MainMenu mainMenu = new MainMenu();
				shell.close();
				mainMenu.open();

			}
		});
		login_manager.setText("管理员登录");
		login_manager.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 13, SWT.NORMAL));
		login_manager.setBounds(799, 548, 171, 52);

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 30, SWT.NORMAL));
		label_2.setBounds(401, 124, 485, 71);
		label_2.setText("商品库存管理系统 - 欢迎");

	}
}
