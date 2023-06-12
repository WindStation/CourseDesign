package interfaces;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class EntryWindow {

	protected Shell shell;
	private Text inOrder;
	private Text GoodsAmount;
	private Text GoodsPrice;
	private Text Producer;
	private Text Note;
	private Text employer;
	private Text goodName;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			EntryWindow window = new EntryWindow();
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
		shell.setSize(1327, 747);
		shell.setText("进货入库");
		shell.setLayout(null);
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 15, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(505, 20, 182, 53);
		lblNewLabel.setText("进货入库");
		
		Label orderId = new Label(shell, SWT.NONE);
		orderId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		orderId.setBounds(50, 84, 91, 39);
		orderId.setText("单号：");
		
		Label date = new Label(shell, SWT.NONE);
		date.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		date.setBounds(353, 84, 91, 39);
		date.setText("日期：");
		
		Label goodsId = new Label(shell, SWT.NONE);
		goodsId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsId.setBounds(655, 83, 102, 40);
		goodsId.setText("商品编号：");
		
		Label goodsName = new Label(shell, SWT.NONE);
		goodsName.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsName.setBounds(973, 84, 102, 39);
		goodsName.setText("商品名称：");
		
		Label goodsCategory = new Label(shell, SWT.NONE);
		goodsCategory.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsCategory.setBounds(50, 157, 102, 39);
		goodsCategory.setText("商品类别：");
		
		Label goodsUnit = new Label(shell, SWT.NONE);
		goodsUnit.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsUnit.setBounds(353, 157, 91, 39);
		goodsUnit.setText("单位：");
		
		Label goodsAmount = new Label(shell, SWT.NONE);
		goodsAmount.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsAmount.setBounds(655, 157, 102, 39);
		goodsAmount.setText("入库数量：");
		
		Label goodsPrice = new Label(shell, SWT.NONE);
		goodsPrice.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsPrice.setBounds(973, 157, 102, 39);
		goodsPrice.setText("入库单价：");
		
		Label supplier = new Label(shell, SWT.NONE);
		supplier.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		supplier.setBounds(50, 236, 102, 39);
		supplier.setText("供货商：");
		
		Label warehouseId = new Label(shell, SWT.NONE);
		warehouseId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		warehouseId.setBounds(353, 236, 102, 39);
		warehouseId.setText("存放仓库：");
		
		Label producer = new Label(shell, SWT.NONE);
		producer.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		producer.setBounds(655, 236, 102, 39);
		producer.setText("生产厂商：");
		
		Label note = new Label(shell, SWT.NONE);
		note.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		note.setBounds(973, 236, 91, 39);
		note.setText("备注：");
		
		Label buyerId = new Label(shell, SWT.NONE);
		buyerId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		buyerId.setBounds(50, 321, 102, 39);
		buyerId.setText("采购员id：");
		
		Label QCId = new Label(shell, SWT.NONE);
		QCId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		QCId.setBounds(353, 321, 102, 39);
		QCId.setText("质检员id：");
		
		Label lblid_2 = new Label(shell, SWT.NONE);
		lblid_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblid_2.setBounds(655, 321, 102, 39);
		lblid_2.setText("操作员id：");
		
		Button add = new Button(shell, SWT.NONE);
		add.setBounds(410, 377, 114, 34);
		add.setText("添加商品");
		
		Button button_1 = new Button(shell, SWT.NONE);
		button_1.setBounds(590, 377, 114, 34);
		button_1.setText("取消");
		
		inOrder = new Text(shell, SWT.BORDER);
		inOrder.setBounds(158, 86, 150, 30);
		
		Combo GoodsCategory = new Combo(shell, SWT.NONE);
		GoodsCategory.setBounds(158, 157, 150, 32);
		
		Combo GoodUnit = new Combo(shell, SWT.NONE);
		GoodUnit.setBounds(461, 159, 160, 32);
		
		GoodsAmount = new Text(shell, SWT.BORDER);
		GoodsAmount.setBounds(778, 157, 150, 30);
		
		GoodsPrice = new Text(shell, SWT.BORDER);
		GoodsPrice.setBounds(1082, 157, 150, 30);
		
		Combo Supplier = new Combo(shell, SWT.NONE);
		Supplier.setBounds(158, 236, 150, 32);
		
		Combo WarehouseId = new Combo(shell, SWT.NONE);
		WarehouseId.setBounds(461, 236, 160, 32);
		
		Producer = new Text(shell, SWT.BORDER);
		Producer.setBounds(779, 236, 149, 30);
		
		Note = new Text(shell, SWT.BORDER);
		Note.setBounds(1082, 236, 150, 30);
		
		Combo BuyerId = new Combo(shell, SWT.NONE);
		BuyerId.setBounds(158, 321, 150, 32);
		
		Combo QcId = new Combo(shell, SWT.NONE);
		QcId.setBounds(461, 321, 160, 32);
		
		DateTime dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(461, 90, 160, 33);
		
		Combo goodsId_1 = new Combo(shell, SWT.NONE);
		goodsId_1.setBounds(778, 86, 150, 32);
		
		employer = new Text(shell, SWT.BORDER);
		employer.setEditable(false);
		employer.setBounds(778, 321, 150, 30);
		
		goodName = new Text(shell, SWT.BORDER);
		goodName.setEditable(false);
		goodName.setBounds(1078, 86, 154, 30);
		
		Button button = new Button(shell, SWT.NONE);
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDoubleClick(MouseEvent e) {
				//根据返回需要回到的页面 进行新建
				//例如：
				LoginWindow loginWindow = new LoginWindow();
				shell.close();
				loginWindow.open();
				
			}
		});
		button.setBounds(772, 377, 114, 34);
		button.setText("返回");

	}
}
