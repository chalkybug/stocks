package stock.gui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


import stock.gui.panel.Panel;

public class GUI extends JFrame implements ICommon {
	private static final long serialVersionUID = 1L;
	public static final int WIDTH_GUI = 800;
	public static final int HEITH_GUI = 600;
	private static final String TITLE = "Stocks";
	private Panel panel;

	public GUI() {
		initComp();
		addComp();
		addEvent();
	}

	@Override
	public void initComp() {
		setTitle(TITLE);
		setSize(WIDTH_GUI, HEITH_GUI);
		setLocationRelativeTo(null);
		setResizable(false);
		setLayout(null);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}

	@Override
	public void addComp() {
		panel = new Panel();
		add(panel);
	}

	@Override
	public void addEvent() {
		WindowListener wd = new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				int kq = JOptionPane.showConfirmDialog(null, "Ban co muon thoat khong");
				if (kq == JOptionPane.YES_OPTION) {
					dispose();
				} else if (JOptionPane.NO_OPTION == kq) {
				}
			}
		};
		addWindowListener(wd);
	}
}
