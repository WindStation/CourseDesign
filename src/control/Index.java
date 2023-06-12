package control;

import interfaces.LoginWindow;
import model.Manager;
import model.Operator;

public class Index {
//	private static DBOperation dbOperation;
	public static Manager currentManager = null;
	public static Operator currentOperator = null;

	public static void main(String[] args) {
		// TODO 最后改回来
//		DBOperation.init();
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.open();
	}

}
