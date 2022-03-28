package gui.panel;

import javax.swing.JPanel;
import gui.MainFrame;
import gui.dialog.TransferAddEditDialog;
import gui.handler.FunctionsHandler;
import gui.table.TransferTableData;
import gui.toolbar.FunctionsToolBar;
import settings.Style;

public class TransferPanel extends RightPanel {
    
    public TransferPanel(MainFrame frame) {
        super(frame, new TransferTableData(new FunctionsHandler(frame, new TransferAddEditDialog(frame))),
                "TRANSFERS", Style.ICON_PANEL_TRANSFERS,
                new JPanel[] {new FunctionsToolBar(new FunctionsHandler(frame, new TransferAddEditDialog(frame))), new FilterPanel(frame)});
    }
}
