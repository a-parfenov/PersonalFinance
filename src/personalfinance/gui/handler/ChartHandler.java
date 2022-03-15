package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import personalfinance.gui.MainFrame;
import personalfinance.gui.panel.StatisticsPanel;
import personalfinance.settings.HandlerCode;

public class ChartHandler extends Handler {

    public ChartHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.TYPE: {
                ((StatisticsPanel) frame.getRightPanel()).nextType();
            }
        }
        super.actionPerformed(ae);
    }
}
