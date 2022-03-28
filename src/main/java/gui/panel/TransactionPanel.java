package gui.panel;

import javax.swing.JPanel;
import gui.MainFrame;
import gui.dialog.TransactionAddEditDialog;
import gui.handler.FunctionsHandler;
import gui.table.TransactionTableData;
import gui.toolbar.FunctionsToolBar;
import settings.Style;

public class TransactionPanel extends RightPanel {
    
    public TransactionPanel(MainFrame frame) {
        super(frame, new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))),
                "TRANSACTIONS", Style.ICON_PANEL_TRANSACTIONS,
                new JPanel[] {new FunctionsToolBar(new FunctionsHandler(frame, new TransactionAddEditDialog(frame))), new FilterPanel(frame)});
    }
}
