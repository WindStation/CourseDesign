package interfaces;

import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;
//import org.eclipse.wb.swt.SWTResourceManager;

import service.GoodsService;
import model.*;

public class Daily_Goods {

	protected Shell shell;
	private Text idText;
	private Text nameText;
	private Text amountText;
	private Text categoryText;
	private Text warehouseText;
	private Text priceText;
	private Text unitText;
	private Text producerText;
	private Text noteText;
	private Table table;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Daily_Goods window = new Daily_Goods();
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
		shell.setSize(1000, 650);
		shell.setText("SWT Application");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(365, 10, 104, 20);
		lblNewLabel.setText("商品信息管理");
		
		Label label = new Label(shell, SWT.NONE);
		label.setBounds(10, 51, 43, 20);
		label.setText("编号");
		
		Label lblNewLabel_1 = new Label(shell, SWT.NONE);
		lblNewLabel_1.setBounds(10, 93, 43, 20);
		lblNewLabel_1.setText("名称");
		
		Label lblNewLabel_2 = new Label(shell, SWT.NONE);
		lblNewLabel_2.setBounds(10, 136, 43, 20);
		lblNewLabel_2.setText("数量");
		
		Label lblNewLabel_3 = new Label(shell, SWT.NONE);
		lblNewLabel_3.setBounds(10, 181, 43, 20);
		lblNewLabel_3.setText("种类");
		
		Label lblNewLabel_4 = new Label(shell, SWT.NONE);
		lblNewLabel_4.setBounds(10, 227, 37, 20);
		lblNewLabel_4.setText("仓库");
		
		idText = new Text(shell, SWT.BORDER);
		idText.setBounds(68, 51, 183, 26);
		
		nameText = new Text(shell, SWT.BORDER);
		nameText.setBounds(68, 93, 183, 26);
		
		amountText = new Text(shell, SWT.BORDER);
		amountText.setBounds(68, 136, 183, 26);
		
		categoryText = new Text(shell, SWT.BORDER);
		categoryText.setBounds(68, 178, 183, 26);
		
		warehouseText = new Text(shell, SWT.BORDER);
		warehouseText.setBounds(68, 227, 183, 26);
		
		Label label_1 = new Label(shell, SWT.NONE);
		label_1.setBounds(303, 51, 43, 20);
		label_1.setText("单价");
		
		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setBounds(303, 93, 43, 20);
		label_2.setText("单位");
		
		Label label_3 = new Label(shell, SWT.NONE);
		label_3.setBounds(303, 136, 43, 20);
		label_3.setText("生产商");
		
		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setBounds(303, 181, 43, 20);
		label_4.setText("备注");
		
		priceText = new Text(shell, SWT.BORDER);
		priceText.setBounds(365, 51, 183, 26);
		
		unitText = new Text(shell, SWT.BORDER);
		unitText.setBounds(365, 93, 183, 26);
		
		producerText = new Text(shell, SWT.BORDER);
		producerText.setBounds(365, 136, 183, 26);
		
		noteText = new Text(shell, SWT.BORDER);
		noteText.setBounds(365, 181, 183, 26);
		
		Button find = new Button(shell, SWT.NONE);
		find.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				String id=idText.getText();
				
				if(id==null || id.trim().equals("")) {
					// 查找全部
					List<Goods> goodlist = GoodsService.findAll();
					table.removeAll();
					goodlist.forEach(goods->{
						TableItem item=new TableItem(table,SWT.NONE);
						item.setText(0, goods.getId());
			            item.setText(1, goods.getName());
			            item.setText(2, String.valueOf(goods.getAmount()));
			            item.setText(3, goods.getCategory());
			            item.setText(4, goods.getWarehouse());
			            item.setText(5, String.valueOf(goods.getPrice()));
			            item.setText(6, goods.getUnit());
			            item.setText(7, goods.getProducer());
			            item.setText(8,goods.getNote()==null?"":goods.getNote());
					});
					return;
				}
				
				Goods goods=GoodsService.find(id);
				table.removeAll();
				if(goods!=null) {
					TableItem item=new TableItem(table,SWT.NONE);
					item.setText(0, goods.getId());
		            item.setText(1, goods.getName());
		            item.setText(2, String.valueOf(goods.getAmount()));
		            item.setText(3, goods.getCategory());
		            item.setText(4, goods.getWarehouse());
		            item.setText(5, String.valueOf(goods.getPrice()));
		            item.setText(6, goods.getUnit());
		            item.setText(7, goods.getProducer());
		            item.setText(8,goods.getNote());
				}else {
					// 查询结果为空的处理逻辑
				    MessageBox messageBox = new MessageBox(shell, SWT.ICON_INFORMATION | SWT.OK);
				    messageBox.setMessage("管理员不存在");
				    messageBox.open();
				}
			}
		});
		find.setBounds(600, 41, 98, 30);
		find.setText("查询");
		
		Button add = new Button(shell, SWT.NONE);
		add.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取要新增的管理员信息
		        String id = idText.getText();
		        String name = nameText.getText();
		        int amount = Integer.parseInt(amountText.getText());
				String category=categoryText.getText();
				String warehouse=warehouseText.getText();
				float price=Float.parseFloat(priceText.getText());
				String unit=unitText.getText();
				String producer=producerText.getText();
				String note=noteText.getText();
				
		        Goods good=new Goods(id,name,amount,category,warehouse,price,unit,producer,note);
		        		
		        GoodsService.insert(good);		   
		    }
		});
		add.setText("新增");
		add.setBounds(748, 41, 98, 30);
		Button update = new Button(shell, SWT.NONE);
		update.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        
		    	String id = idText.getText();
		        String name = nameText.getText();
		        int amount =-1;
		        if(!amountText.getText().trim().equals("")) {
		        	amount=Integer.parseInt(amountText.getText());
		        }
		        
				String category=categoryText.getText();
				String warehouse=warehouseText.getText();
				
				float price=-1;
				if(!priceText.getText().trim().equals("")) {
					price = Float.parseFloat(priceText.getText());
				}
				String unit=unitText.getText();
				String producer=producerText.getText();
				String note=noteText.getText();
				
		        Goods good=new Goods(id,name,amount,category,warehouse,price,unit,producer,note);
		        		
		        GoodsService.update(good);
		    }
		});
		update.setText("修改");
		update.setBounds(600, 93, 98, 30);
		
		Button delete = new Button(shell, SWT.NONE);
		delete.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // 获取要删除的管理员ID
		        String id = idText.getText();
		        
		        GoodsService.delete(id);
		    }
		});
		delete.setText("删除");
		delete.setBounds(748, 89, 98, 30);
		
		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 270, 933, 295);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(100);
		tableColumn.setText("编号");
		
		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(100);
		tableColumn_1.setText("名称");
		
		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("数量");
		
		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("种类");
		
		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("仓库");
		
		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("单价");
		
		TableColumn tableColumn_6 = new TableColumn(table, SWT.NONE);
		tableColumn_6.setWidth(100);
		tableColumn_6.setText("单位");
		
		TableColumn tableColumn_7 = new TableColumn(table, SWT.NONE);
		tableColumn_7.setWidth(100);
		tableColumn_7.setText("生产商");
		
		TableColumn tableColumn_8 = new TableColumn(table, SWT.NONE);
		tableColumn_8.setWidth(100);
		tableColumn_8.setText("备注");

	}
}
