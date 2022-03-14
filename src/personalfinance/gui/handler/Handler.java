package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import personalfinance.gui.MainFrame;

public abstract class Handler implements ActionListener {

    protected final MainFrame frame;

    public Handler(MainFrame frame) {
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.refresh();
    }
}
