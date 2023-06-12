package interfaces;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

import model.Entry;
import model.Goods;
import service.EntryService;
import service.GoodsService;

public class Statistics_EntryInfo {

	protected Shell shell;
	protected DateTime startDate;
	protected DateTime terminateDate;
	private Button queryBtn;
	private Button queryAllBtn;
	private Combo supplierSelector;
	private Label label;
	private Label label_1;
	private Table table;
	private Button selectByTime;
	private Text entryId_text;
	private Text goodname_text;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Statistics_EntryInfo window = new Statistics_EntryInfo();
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
		shell.setText("入库报表");

		startDate = new DateTime(shell, SWT.BORDER);
		startDate.setBounds(422, 223, 135, 33);

		terminateDate = new DateTime(shell, SWT.BORDER);
		terminateDate.setBounds(608, 223, 135, 33);

		queryBtn = new Button(shell, SWT.NONE);
		queryBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				// 进行查询
				List<String> criteria = new ArrayList<>();
				// 如果有时间筛选条件
				if (selectByTime.getSelection()) {
					LocalDateTime queryStart = LocalDateTime.of(startDate.getYear(), startDate.getMonth() + 1,
							startDate.getDay(), 0, 0, 0);
					LocalDateTime queryEnd = LocalDateTime.of(terminateDate.getYear(), terminateDate.getMonth() + 1,
							terminateDate.getDay(), 23, 59, 59);
					if (!queryStart.isBefore(queryEnd)) {
						MessageBox messageBox = new MessageBox(shell);
						messageBox.setText("提示");
						messageBox.setMessage("输入的查询时间不合法，请检查后重新选择时间范围！");
						messageBox.open();
						return;
					}
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					String sql = "`entryDate` between '" + queryStart.format(formatter) + "' and '"
							+ queryEnd.format(formatter) + "'";
					criteria.add(sql);
				}
				// 如果有单号筛选条件
				if (entryId_text.getText() != null && !entryId_text.getText().trim().equals("")) {
					criteria.add("`id` = '" + entryId_text.getText() + "'");
				}
				// 如果有货品名称筛选条件
				if (goodname_text.getText() != null && !goodname_text.getText().trim().equals("")) {
					List<Goods> candidateGoods = GoodsService.findByName(goodname_text.getText());
					List<String> subCriteria = new ArrayList<>();
					candidateGoods.forEach(good -> {
						subCriteria.add("`good_id` = '" + good.getId() + "'");
					});
					if (subCriteria.size() > 0) {
						criteria.add(subCriteria.stream().collect(Collectors.joining(" or ")));
					}

				}

				// TODO 供货商选项框
				if (supplierSelector.getText() != null && !supplierSelector.getText().trim().equals("")) {

				}

				// 总的筛选条件
				String totalCriteria = criteria.stream().collect(Collectors.joining(" and "));
				// 为了防止条件全为空，需要在这里判断一下，如果有条件直接在头上加上where
				if (totalCriteria.length() > 0) {
					totalCriteria = " where " + totalCriteria;
				}

				System.out.println(totalCriteria);
				List<Entry> entries = EntryService.find(totalCriteria);

				table.removeAll();
				// TODO 等到校验员等类写好了再完善此处的属性
				entries.forEach(en -> {
					TableItem item = new TableItem(table, SWT.NONE);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					item.setText(new String[] { String.valueOf(en.getId()), en.getDate().format(formatter),
							en.getGoodId(), String.valueOf(en.getAmount()), String.valueOf(en.getPrice()), null,
							en.getOperatorId(), null, null, en.getNote() });
				});

			}
		});
		queryBtn.setBounds(837, 223, 83, 33);
		queryBtn.setText("查询");

		label = new Label(shell, SWT.NONE);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label.setBounds(394, 223, 22, 30);
		label.setText("从");

		label_1 = new Label(shell, SWT.NONE);
		label_1.setText("至");
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label_1.setBounds(566, 223, 22, 30);

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(71, 316, 1083, 397);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);

		TableColumn tableColumn_7 = new TableColumn(table, SWT.NONE);
		tableColumn_7.setWidth(100);
		tableColumn_7.setText("入库单号");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(113);
		tblclmnNewColumn.setText("日期");

		TableColumn tableColumn = new TableColumn(table, SWT.NONE);
		tableColumn.setWidth(122);
		tableColumn.setText("货物名称");

		TableColumn tableColumn_1 = new TableColumn(table, SWT.NONE);
		tableColumn_1.setWidth(85);
		tableColumn_1.setText("数量");

		TableColumn tableColumn_2 = new TableColumn(table, SWT.NONE);
		tableColumn_2.setWidth(100);
		tableColumn_2.setText("采购单价");

		TableColumn tableColumn_3 = new TableColumn(table, SWT.NONE);
		tableColumn_3.setWidth(100);
		tableColumn_3.setText("校验员");

		TableColumn tableColumn_4 = new TableColumn(table, SWT.NONE);
		tableColumn_4.setWidth(100);
		tableColumn_4.setText("操作员");

		TableColumn tableColumn_5 = new TableColumn(table, SWT.NONE);
		tableColumn_5.setWidth(100);
		tableColumn_5.setText("供货商");

		TableColumn tableColumn_6 = new TableColumn(table, SWT.NONE);
		tableColumn_6.setWidth(96);
		tableColumn_6.setText("采购员");

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(150);
		tblclmnNewColumn_1.setText("备注");

		selectByTime = new Button(shell, SWT.CHECK);
		selectByTime.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		selectByTime.setBounds(229, 223, 157, 33);
		selectByTime.setText("按时间筛选：");

		Label label_2 = new Label(shell, SWT.NONE);
		label_2.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.NORMAL));
		label_2.setBounds(532, 10, 240, 52);
		label_2.setText("入库记录查询");

		Label label_3 = new Label(shell, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_3.setBounds(309, 68, 616, 30);

		entryId_text = new Text(shell, SWT.BORDER);
		entryId_text.setBounds(329, 124, 135, 30);

		Label label_4 = new Label(shell, SWT.NONE);
		label_4.setText("入库单号");
		label_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label_4.setBounds(229, 122, 88, 30);

		Label label_4_1 = new Label(shell, SWT.NONE);
		label_4_1.setText("货物名称");
		label_4_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label_4_1.setBounds(524, 124, 88, 30);

		goodname_text = new Text(shell, SWT.BORDER);
		goodname_text.setBounds(626, 124, 135, 30);

		Label label_4_1_1 = new Label(shell, SWT.NONE);
		label_4_1_1.setText("供货商");
		label_4_1_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 11, SWT.NORMAL));
		label_4_1_1.setBounds(816, 124, 88, 30);

		supplierSelector = new Combo(shell, SWT.NONE);
		supplierSelector.setBounds(910, 124, 111, 32);

		queryAllBtn = new Button(shell, SWT.NONE);
		queryAllBtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				table.removeAll();
				// 查询全部
				// TODO 等到校验员等类写好了再完善此处的属性
				List<Entry> entries = EntryService.findAll();
				entries.forEach(en -> {
					TableItem item = new TableItem(table, SWT.NONE);
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
					item.setText(new String[] { String.valueOf(en.getId()), en.getDate().format(formatter),
							en.getGoodId(), String.valueOf(en.getAmount()), String.valueOf(en.getPrice()), null,
							en.getOperatorId(), null, null, en.getNote() });
				});
			}
		});
		queryAllBtn.setBounds(954, 223, 114, 34);
		queryAllBtn.setText("查询全部");

	}
}
