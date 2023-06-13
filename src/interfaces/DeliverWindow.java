package interfaces;

import java.time.LocalDateTime;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.wb.swt.SWTResourceManager;

import control.Index;
import model.CheckerInfo;
import model.CustomerInfo;
import model.Entry;
import model.Goods;
import model.PurchaserInfo;
import model.ShipperInfo;
import model.SupplierInfo;
import model.WarehouseInfo;
import model.Deliver;
import service.CheckerService;
import service.CustomerService;
import service.DeliverService;
import service.EntryService;
import service.GoodsService;
import service.PurchaserService;
import service.ShipperService;
import service.SupplierService;
import service.WarehouseService;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class DeliverWindow {

	protected Shell shell;
	private Text GoodsAmount;
	private Text operator_id;
	private Text goodsClass;
	private Text unit;
	private Combo goodsId_1;
	private Text GoodsPrice;
	private Text note_1;
	private Text goodsname;
	private Combo warehouseCom;
	private Combo QcId;
	private DateTime dateTime;
	private	Combo customer;
	private Combo shipper;
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			DeliverWindow window = new DeliverWindow();
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
		shell.setSize(1252, 786);
		shell.setText("出库报表");
		List<Goods> goods= GoodsService.findAll();
		List<WarehouseInfo> warehouses = WarehouseService.findAllWarehouses();
		List<CheckerInfo> checkerInfos =CheckerService.findAll();
		List<SupplierInfo> supps= SupplierService.findAll();
		List<CustomerInfo> customers = CustomerService.findAll();
		List<ShipperInfo> shippers=ShipperService.findAll();
		
		Label label = new Label(shell, SWT.NONE);
		label.setAlignment(SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		label.setBounds(479, 25, 220, 75);
		label.setText("出库操作");
		
		Label date = new Label(shell, SWT.NONE);
		date.setText("日期：");
		date.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		date.setBounds(338, 107, 91, 39);
		
		Label goodsId = new Label(shell, SWT.NONE);
		goodsId.setText("商品编号：");
		goodsId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsId.setBounds(640, 106, 102, 40);
		
		Label goodsName = new Label(shell, SWT.NONE);
		goodsName.setText("商品名称：");
		goodsName.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsName.setBounds(958, 107, 102, 39);
		
		Label goodsCategory = new Label(shell, SWT.NONE);
		goodsCategory.setText("商品类别：");
		goodsCategory.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsCategory.setBounds(35, 180, 102, 39);
		
		Label goodsUnit = new Label(shell, SWT.NONE);
		goodsUnit.setText("单位：");
		goodsUnit.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsUnit.setBounds(338, 180, 91, 39);
		
		Label goodsAmount = new Label(shell, SWT.NONE);
		goodsAmount.setText("出库数量：");
		goodsAmount.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsAmount.setBounds(640, 180, 102, 39);
		
		Label goodsPrice = new Label(shell, SWT.NONE);
		goodsPrice.setText("出库单价：");
		goodsPrice.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		goodsPrice.setBounds(958, 180, 102, 39);
		
		Label warehouseId = new Label(shell, SWT.NONE);
		warehouseId.setText("存放仓库：");
		warehouseId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		warehouseId.setBounds(338, 259, 102, 39);
		
		Label note = new Label(shell, SWT.NONE);
		note.setText("备注：");
		note.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		note.setBounds(958, 259, 91, 39);
		
		Label QCId = new Label(shell, SWT.NONE);
		QCId.setText("质检员id：");
		QCId.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		QCId.setBounds(35, 342, 102, 39);
		
		Label lblid_2 = new Label(shell, SWT.NONE);
		lblid_2.setText("操作员id：");
		lblid_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		lblid_2.setBounds(35, 107, 102, 39);
		
		Button add = new Button(shell, SWT.NONE);
		add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				try {
					// 获取选项框中的数据
					String selectedGoodsId = goodsId_1.getText();
					String selectedGoodsAmount = GoodsAmount.getText();
					int goodsAmount = Integer.parseInt(selectedGoodsAmount);
					String selectedGoodsPrice = GoodsPrice.getText();
					float goodsPrice = Float.parseFloat(selectedGoodsPrice);
      
					String selectedWarehouse = warehouseCom.getText();
      
					String selectedNote = note_1.getText();
     
      
					String selectedQcId = QcId.getText();
					String[] qcparts = selectedQcId.split("\\."); // 使用点号作为分隔符拆分字符串
					String qcselectedId = qcparts[0]; // 获取拆分后的第一部分，即 ID
					
					String customernow = customer.getText();
					String[] csutomere = customernow.split("\\."); // 使用点号作为分隔符拆分字符串
					String customerId = csutomere[0]; // 获取拆分后的第一部分，即 ID
					
					
					String shippers = shipper.getText();
					String[] shipperId = shippers.split("\\."); // 使用点号作为分隔符拆分字符串
					String shipperid = shipperId[0]; // 获取拆分后的第一部分，即 ID
					
					int year = dateTime.getYear();
					int month = dateTime.getMonth() + 1; // Month index starts from 0, so increment by 1
					int day = dateTime.getDay();
					int hour = dateTime.getHours();
					int minute = dateTime.getMinutes();

					LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
					// 入库操作
					Deliver deliver = new Deliver( localDateTime,selectedGoodsId,goodsPrice,goodsAmount,qcselectedId,Index.currentOperator.getId(),
							customerId,shipperid,selectedNote);
					DeliverService.insert(deliver);
					
					// 清空文本框
					goodsId_1.setText("");
					goodsname.setText("");
					goodsClass.setText("");
					unit.setText("");
					GoodsAmount.setText("");
					GoodsPrice.setText("");
     
					warehouseCom.setText("");
					
					note_1.setText("");
					
					QcId.setText("");
					
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("商品出库成功");
					box.open();
				} catch (NumberFormatException e1) {
					goodsId_1.setText("");
					goodsname.setText("");
					goodsClass.setText("");
					unit.setText("");
					GoodsAmount.setText("");
					GoodsPrice.setText("");
					warehouseCom.setText("");
					note_1.setText("");
					QcId.setText("");
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("商品出库失败");
					box.open();
				}
		      
		       
				
			}
		});
		add.setText("确认出库");
		add.setBounds(527, 400, 114, 34);
		
		GoodsAmount = new Text(shell, SWT.BORDER);
		GoodsAmount.setBounds(763, 180, 160, 30);
		
		
		warehouseCom = new Combo(shell, SWT.NONE);
		warehouseCom.setBounds(446, 259, 160, 32);
		warehouseCom.select(0);
		for (WarehouseInfo warehouse : warehouses) {
		    warehouseCom.add(warehouse.getName());
		}
		// 设置默认选项
		
		
		QcId = new Combo(shell, SWT.NONE);
		QcId.setBounds(143, 344, 160, 32);
		for(CheckerInfo qc:checkerInfos) {
			QcId.add(qc.getId()+'.'+qc.getName());
		}
		
		dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(446, 108, 160, 33);
		
		//商品编号：
		goodsId_1 = new Combo(shell, SWT.NONE);
		goodsId_1.setBounds(763, 109, 160, 32);
		goodsId_1.select(0);
		for (Goods good : goods) {
		    goodsId_1.add(good.getId());
		}
		// 设置默认选项
		goodsId_1.select(0); // 设置第一个选项为默认选项
		
		
		operator_id = new Text(shell, SWT.BORDER);
		operator_id.setEditable(false);
		operator_id.setBounds(143, 109, 150, 30);
		operator_id.setText(Index.currentOperator.getId());
		
		//商品类别：
		goodsClass = new Text(shell, SWT.BORDER);
		goodsClass.setEditable(false);
		goodsClass.setBounds(143, 182, 150, 30);
		goodsId_1.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取当前选择的商品分类
		        int selectedIndex = goodsId_1.getSelectionIndex();
		        if (selectedIndex != -1) {
		            String selectedClass = goodsId_1.getItem(selectedIndex);
		            
		            // 根据选择的商品分类查询商品信息
		            Goods selectedGood = GoodsService.find(selectedClass);
		            
		            // 更新商品名称文本框的值
		            goodsClass.setText(selectedGood.getCategory());
		        }
		    }
		});
		
		//商品单位：
		unit = new Text(shell, SWT.BORDER);
		unit.setEditable(false);
		unit.setBounds(446, 182, 160, 30);
		goodsId_1.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取当前选择的商品分类
		        int selectedIndex = goodsId_1.getSelectionIndex();
		        if (selectedIndex != -1) {
		            String selectedClass = goodsId_1.getItem(selectedIndex);
		            
		            // 根据选择的商品分类查询商品信息
		            Goods selectedGood = GoodsService.find(selectedClass);
		            
		            // 更新商品名称文本框的值
		            unit.setText(selectedGood.getUnit());
		        }
		    }
		});
		
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label_1.setBounds(640, 259, 90, 39);
		label_1.setText("客户：");
		
		GoodsPrice = new Text(shell, SWT.BORDER);
		GoodsPrice.setBounds(1070, 178, 150, 30);
		
		note_1 = new Text(shell, SWT.BORDER);
		note_1.setBounds(1070, 257, 150, 30);
		
		
		//商品名称
		goodsname = new Text(shell, SWT.BORDER);
		goodsname.setEditable(false);
		goodsname.setBounds(1066, 107, 154, 30);
		goodsId_1.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取当前选择的商品编号
		        int selectedIndex = goodsId_1.getSelectionIndex();
		        if (selectedIndex != -1) {
		            String selectedId = goodsId_1.getItem(selectedIndex);
		            
		            // 根据选择的商品编号查询商品信息
		            Goods selectedGood = GoodsService.find(selectedId);
		            
		            // 更新商品名称文本框的值
		            goodsname.setText(selectedGood.getName());
		        }
		    }
		});
		
		customer = new Combo(shell, SWT.NONE);
		customer.setBounds(763, 259, 160, 32);
		for(CustomerInfo cust:customers) {
			customer.add(cust.getId()+'.'+cust.getName());
		}
		
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label_2.setBounds(35, 259, 91, 39);
		label_2.setText("出货员：");
		
		shipper = new Combo(shell, SWT.NONE);
		shipper.setBounds(143, 261, 160, 32);
		for(ShipperInfo shipper1:shippers) {
			shipper.add(shipper1.getId()+'.'+shipper1.getName());
		}
		
	}
}
