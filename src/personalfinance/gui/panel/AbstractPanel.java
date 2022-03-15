package personalfinance.gui.panel;

import javax.swing.JPanel;
import personalfinance.gui.MainFrame;
import personalfinance.gui.Refresh;

abstract public class AbstractPanel extends JPanel implements Refresh {

    protected final MainFrame frame;
    
    public AbstractPanel(MainFrame frame) {
        this.frame = frame;
    }
    
    @Override
    public void refresh() {
        removeAll();
        init();
    }

    abstract protected void init();

}
