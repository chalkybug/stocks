package stock.gui.panel;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.PriorityQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import stock.BUS.StockBUS;
import stock.DTO.TradeOrder;
import stock.gui.GUI;

public class Panel extends BasePanel {
	private JTextField txt1, txt2, txt3;
	private JLabel lbTen, lbGia, lbSL, lbBM, lbBB, lbTB;
	private JButton btMua, btBan, btKL;
	private JTable tbMua, tbBan;
	private JScrollPane scrolPanel, scrolPanel1, scrolPanel2;
	private static final String MUA = "Mua";
	private static final String BAN = "Ban";
	private static final String KHOP_LENH = "Khop Lenh";
	private ActionListener action1;
	private JTextArea txtb;

	private DefaultTableModel dftb1, dftb2, dftb3;
	private static final String[] COLUM = { "Ten", "So Luong", "Gia" };
	private PriorityQueue<TradeOrder> dsMua1 = new PriorityQueue<TradeOrder>();

	@Override
	public void initComp() {
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		setSize(GUI.WIDTH_GUI, GUI.HEITH_GUI);
	}

	@Override
	public void addComp() {
		Font f = new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 14);
		FontMetrics metric = getFontMetrics(f);

		int hlb = metric.getHeight();

		txt1 = new JTextField();
		addtxt(txt1, 150, hlb + 10, 100, 20, f);
		add(txt1);

		lbTen = new JLabel();
		addlabel(lbTen, "Ten", 80, hlb + 10, txt1.getX() - 80, txt1.getY(), f);
		add(lbTen);

		lbGia = new JLabel();
		addlabel(lbGia, "Gia", 80, hlb + 10, lbTen.getX(), lbTen.getY() + hlb + 30, f);
		add(lbGia);
//
		txt2 = new JTextField();
		addtxt(txt2, 150, hlb + 10, txt1.getX(), lbGia.getY(), f);
		add(txt2);

		lbSL = new JLabel();

		addlabel(lbSL, "So Luong", 80, hlb + 10, lbTen.getX(), lbGia.getY() + hlb + 30, f);
		add(lbSL);

		txt3 = new JTextField();
		addtxt(txt3, 150, hlb + 10, txt1.getX(), lbSL.getY(), f);
		add(txt3);

		btMua = new JButton();
		addbutton(btMua, 70, hlb + 20, lbTen.getX(), lbSL.getY() + hlb + 30, "Mua", f);
		add(btMua);

		btBan = new JButton();
		addbutton(btBan, 70, btMua.getHeight(), btMua.getX() + 100, btMua.getY(), "Ban", f);
		add(btBan);

		tbMua = new JTable();
		scrolPanel1 = new JScrollPane(tbMua);
		scrolPanel1.setSize(250, 200);
		scrolPanel1.setLocation(txt1.getX() + txt1.getWidth() + 30, txt2.getY());
		add(scrolPanel1);
		//khoiTaoBangMua();

		lbBM = new JLabel();
		addlabel(lbBM, "Danh sach cho mua", 150, hlb + 10, scrolPanel1.getX(), txt1.getY(), f);
		add(lbBM);

		tbBan = new JTable();
		scrolPanel = new JScrollPane(tbBan);
		scrolPanel.setSize(250, 200);
		scrolPanel.setLocation(scrolPanel1.getX() + scrolPanel1.getWidth() + 10, txt2.getY());
		add(scrolPanel);
		//khoiTaoBangBan();

		lbBB = new JLabel();
		addlabel(lbBB, "Danh sach cho ban", 150, hlb + 10, scrolPanel.getX(), lbBM.getY(), f);
		add(lbBB);

		lbTB = new JLabel();
		addlabel(lbTB, "Thong bao", 120, hlb + 10, lbBM.getX(), tbBan.getY() + 300, f);
		add(lbTB);

		btKL = new JButton();
		addbutton(btKL, 150, btMua.getHeight(), lbTen.getX(), lbTB.getY(), "Khop Lenh", f);
		add(btKL);

		txtb = new JTextArea();
		txtb.setSize(300, 250);
		txtb.setLocation(lbTB.getX(), lbTB.getY() + hlb + 10);
		add(txtb);
	}

	@Override
	public void addEvent() {
//		action1 = new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				String name = ((JButton) e.getSource()).getName();
//				switch (name) {
//				case MUA:
//					String ten = txt1.getText();
//					String gia = txt2.getText();
//					String soLuong = txt3.getText();
//					TradeOrder tra1 = new TradeOrder(ten, Integer.parseInt(soLuong), Integer.parseInt(gia));
//					muaCP(tra1);
//					break;
//				case BAN:
//					String ten1 = txt1.getText();
//					String gia1 = txt2.getText();
//					String soLuong1 = txt3.getText();
//					TradeOrder tra2 = new TradeOrder(ten1, Integer.parseInt(soLuong1), Integer.parseInt(gia1));
//					banCP(tra2);
//					break;
//				case KHOP_LENH:
//					khoplenh();
//					break;
//				default:
//					break;
//				}
//			}
//
//		};
//		btMua.addActionListener(action1);
//		btBan.addActionListener(action1);
//		btKL.addActionListener(action1);
	}

	protected void khoplenh() {
//		StockBUS ql = new StockBUS();
//		ql.khoiTaoBan();
//		ql.khoiTaoMua();
//		String tb = ql.khopLenh();
//		txtb.setText(tb);
//		ql.updateBangMua();
//		ql.updateBangBan();
//		khoiTaoBangMua();
//		khoiTaoBangBan();

	}

//	protected void banCP(TradeOrder tra1) {
//		StockBUS ql = new StockBUS();
//		ql.themBan(tra1);
//		khoiTaoBangBan();
//	}
//
//	protected void muaCP(TradeOrder tra1) {
//		StockBUS ql = new StockBUS();
//		ql.themMua(tra1);
//		khoiTaoBangMua();
//	}

//	public void khoiTaoBangMua() {
//		StockBUS ql = new StockBUS();
//		dftb1 = new DefaultTableModel(COLUM, 0);
//		ql.khoiTaoMua();
//		if (!ql.getDsMua().isEmpty()) {
//
//			for (TradeOrder tra1 : ql.getDsMua()) {
//				String[] c = { tra1.getTen(), tra1.getSoLuong() + "", tra1.getGia() + "" };
//				dftb1.addRow(c);
//
//			}
//		}
//
//		tbMua.setModel(dftb1);
//
//	}

//	public void khoiTaoBangBan() {
//
//		StockBUS ql = new StockBUS();
//
//		dftb2 = new DefaultTableModel(COLUM, 0);
//		ql.khoiTaoBan();
//		if (!ql.getDsBan().isEmpty()) {
//
//			for (TradeOrder tra1 : ql.getDsBan()) {
//				String[] c = { tra1.getTen(), tra1.getSoLuong() + "", tra1.getGia() + "" };
//				dftb2.addRow(c);
//
//			}
//		}
//
//		tbBan.setModel(dftb2);
//
//	}

	private void addlabel(JLabel label, String name, int x, int y, int toaDoX, int toaDoY, Font f) {
		label.setText(name);
		label.setSize(x, y);
		label.setLocation(toaDoX, toaDoY);
		label.setFont(f);

	}

	private void addbutton(JButton ten, int x, int y, int toaDoX, int toaDoY, String name, Font f) {
		ten.setText(name);
		ten.setName(name);
		ten.setSize(x, y);
		ten.setLocation(toaDoX, toaDoY);
		ten.setFont(f);
	}

	private void addtxt(JTextField txt, int x, int y, int toaDoX, int toaDoY, Font f) {
		txt.setSize(x, y);
		txt.setLocation(toaDoX, toaDoY);
		txt.setFont(f);
	}
}
