package gui.panel;

import gui.MainFrame;
import gui.dialog.TransactionAddEditDialog;
import gui.handler.FunctionsHandler;
import gui.table.TransactionTableData;
import settings.Settings;
import settings.Style;

public class OverviewPanel extends RightPanel {
    
    public OverviewPanel(MainFrame frame) {
        super(frame,
                new TransactionTableData(new FunctionsHandler(frame, new TransactionAddEditDialog(frame)), Settings.COUNT_OVERVIEW_ROWS),
                "LAST_TRANSACTIONS", Style.ICON_PANEL_OVERVIEW);
    }
    
}
