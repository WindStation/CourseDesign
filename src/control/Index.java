package control;

import configuration.DBOperation;
import interfaces.LoginWindow;
import model.Manager;
import model.Operator;

public class Index {
	public static Manager currentManager = null;
	public static Operator currentOperator = null;

	public static void main(String[] args) {
		DBOperation.init();
		LoginWindow loginWindow = new LoginWindow();
		loginWindow.open();
	}
}
