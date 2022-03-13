package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.TransferTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

import javax.swing.*;

public class TransferPanel extends RightPanel {

    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(),
                "TRANSFERS", Style.ICON_PANEL_TRANSFERS,
                new JPanel[] {new FunctionsToolBar(), new FilterPanel(frame)});
    }

}
