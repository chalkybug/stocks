package stock.gui.panel;

import javax.swing.JPanel;

import stock.gui.ICommon;

public abstract class BasePanel extends JPanel implements ICommon {
	public BasePanel() {
		initComp();
		addComp();
		addEvent();
	}

}
