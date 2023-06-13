package interfaces;

import org.eclipse.swt.widgets.Display;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import control.Index;
import model.CheckerInfo;
import model.Goods;
import model.PurchaserInfo;
import model.ShipperInfo;
import model.SupplierInfo;
import model.WarehouseInfo;
import model.Entry;
import service.CheckerService;
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
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class EntryWindow {

	protected Shell shell;
	private Text GoodsAmount;
	private Text GoodsPrice;
	private Text Producer;
	private Text Note;
	private Text employer;
	private Text goodName;
	private Text goodsClass;
	private Text unit;
	private Combo goodsId_1;
	private Combo Supplier=null;
	private Combo warehouseCom = null;
	
	
	private Combo BuyerId = null;
	private Combo QcId = null;
	private DateTime dateTime =null;
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
		List<Goods> goods= GoodsService.findAll();
		List<WarehouseInfo> warehouses = WarehouseService.findAllWarehouses();
		List<CheckerInfo> checkerInfos =CheckerService.findAll();
		List<PurchaserInfo> buyers =PurchaserService.findAll(); 
		List<SupplierInfo> supps= SupplierService.findAll();
		
		
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(505, 20, 182, 53);
		lblNewLabel.setText("进货入库");
		
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
		lblid_2.setBounds(50, 84, 102, 39);
		lblid_2.setText("操作员id：");
		
		Button add = new Button(shell, SWT.NONE);
		add.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 获取选项框中的数据
				
		        try {
					String selectedGoodsId = goodsId_1.getText();
					String selectedGoodsName = goodName.getText();
					String selectedGoodsCategory = goodsClass.getText();
					String selectedGoodsUnit = unit.getText();
					String selectedGoodsAmount = GoodsAmount.getText();
					int goodsAmount = Integer.parseInt(selectedGoodsAmount);
					String selectedGoodsPrice = GoodsPrice.getText();
					float goodsPrice = Float.parseFloat(selectedGoodsPrice);
					String selectedSupplier = Supplier.getText();
					String selectedWarehouse = warehouseCom.getText();
					String selectedProducer = Producer.getText();
					String selectedNote = Note.getText();
					String selectedBuyerId = BuyerId.getText();
					String[] parts = selectedBuyerId.split("\\."); // 使用点号作为分隔符拆分字符串
					String selectedId = parts[0]; // 获取拆分后的第一部分，即 ID
					String selectedQcId = QcId.getText();
					String[] qcparts = selectedQcId.split("\\."); // 使用点号作为分隔符拆分字符串
					String qcselectedId = qcparts[0]; // 获取拆分后的第一部分，即 ID
					String selectedOperatorId = employer.getText();
					int year = dateTime.getYear();
					int month = dateTime.getMonth() + 1; // Month index starts from 0, so increment by 1
					int day = dateTime.getDay();
					int hour = dateTime.getHours();
					int minute = dateTime.getMinutes();

					LocalDateTime localDateTime = LocalDateTime.of(year, month, day, hour, minute);
					// 创建相应的类对象
					
					WarehouseInfo selectedWarehouseInfo = WarehouseService.find(selectedWarehouse);
					//selectedWarehouseInfo.set
					

					// 构建其他类对象，根据需要自行添加

					// 执行相应的操作，例如存储到数据库
					// 注意：以下代码只是示例，你需要根据具体情况自行修改
					// 添加商品
					
					// 入库操作
					Entry entry = new Entry(localDateTime,selectedGoodsId,goodsPrice,goodsAmount,qcselectedId,Index.currentOperator.getId(),
							selectedSupplier,selectedId,selectedNote);
					EntryService.insert(entry);
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("商品入库成功！");
					box.open();
					

					// 清空文本框
					goodsId_1.setText("");
					goodName.setText("");
					goodsClass.setText("");
					unit.setText("");
					GoodsAmount.setText("");
					GoodsPrice.setText("");
					Supplier.setText("");
					warehouseCom.setText("");
					Producer.setText("");
					Note.setText("");
					BuyerId.setText("");
					QcId.setText("");
					// 其他文本框清空，根据需要自行添加

					
					
				} catch (NumberFormatException e1) {
					// TODO 自动生成的 catch 块
					MessageBox box = new MessageBox(shell, SWT.NONE);
					box.setText("提示");
					box.setMessage("商品入库失败");
					box.open();
					goodsId_1.setText("");
					goodName.setText("");
					goodsClass.setText("");
					unit.setText("");
					GoodsAmount.setText("");
					GoodsPrice.setText("");
					Supplier.setText("");
					warehouseCom.setText("");
					Producer.setText("");
					Note.setText("");
					BuyerId.setText("");
					QcId.setText("");
				}
		        
				
				
				
			}
		});
		add.setBounds(554, 379, 114, 34);
		add.setText("添加商品");
		
		
		
		
		
		GoodsAmount = new Text(shell, SWT.BORDER);
		GoodsAmount.setBounds(778, 157, 150, 30);
		
		GoodsPrice = new Text(shell, SWT.BORDER);
		GoodsPrice.setBounds(1082, 157, 150, 30);
		
		Supplier = new Combo(shell, SWT.NONE);
		Supplier.setBounds(158, 236, 150, 32);
		for(SupplierInfo supp :supps) {
			Supplier.add(supp.getId());
		}
		
		warehouseCom = new Combo(shell, SWT.NONE);
		warehouseCom.setBounds(461, 236, 160, 32);
		for (WarehouseInfo warehouse : warehouses) {
		    warehouseCom.add(warehouse.getName());
		}
		
		Producer = new Text(shell, SWT.BORDER);
		Producer.setBounds(779, 236, 149, 30);
		
		Note = new Text(shell, SWT.BORDER);
		Note.setBounds(1082, 236, 150, 30);
		
		BuyerId = new Combo(shell, SWT.NONE);
		BuyerId.setBounds(158, 321, 150, 32);
		for(PurchaserInfo buy:buyers ) {
			BuyerId.add(buy.getId()+'.'+buy.getName());
		}
		
		//质检员
		QcId = new Combo(shell, SWT.NONE);
		QcId.setBounds(461, 321, 160, 32);
		for(CheckerInfo check:checkerInfos) {
			QcId.add(check.getId()+'.'+check.getName());
		}
		
		dateTime = new DateTime(shell, SWT.BORDER);
		dateTime.setBounds(461, 90, 160, 33);
		
		
		//商品编号
		goodsId_1 = new Combo(shell, SWT.NONE);
		goodsId_1.setBounds(778, 86, 150, 32);
		for (Goods good : goods) {
		    goodsId_1.add(good.getId());
		}
		// 设置默认选项
		goodsId_1.select(0); // 设置第一个选项为默认选项
		
		//操作员的静态数据
		employer = new Text(shell, SWT.BORDER);
		employer.setEditable(false);
		employer.setBounds(158, 86, 150, 30);
		//employer.setText(Index.currentOperator.getId());
		employer.setText(Index.currentOperator.getId());
		
		//商品名称
		goodName = new Text(shell, SWT.BORDER);
		goodName.setEditable(false);
		goodName.setBounds(1078, 86, 154, 30);
		// 商品编号列表框选择事件监听器
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
		            goodName.setText(selectedGood.getName());
		        }
		    }
		});
		
		//商品名称监听
		goodsClass = new Text(shell, SWT.BORDER);
		goodsClass.setEditable(false);
		goodsClass.setBounds(158, 166, 150, 30);
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
		            goodsClass.setText(selectedGood.getName());
		        }
		    }
		});

		
		
		unit = new Text(shell, SWT.BORDER);
		unit.setEditable(false);
		unit.setBounds(461, 166, 160, 30);
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
		            unit.setText(selectedGood.getName());
		        }
		    }
		});

	}
}
