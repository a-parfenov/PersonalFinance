package gui.panel;

import gui.MainFrame;
import gui.dialog.AccountAddEditDialog;
import gui.handler.FunctionsHandler;
import gui.table.AccountTableData;
import gui.toolbar.FunctionsToolBar;
import settings.Style;

public class AccountPanel extends RightPanel {
    
    public AccountPanel(MainFrame frame) {
        super(frame, new AccountTableData(new FunctionsHandler(frame, new AccountAddEditDialog(frame))),
                "ACCOUNTS", Style.ICON_PANEL_ACCOUNTS,
                new FunctionsToolBar(new FunctionsHandler(frame, new AccountAddEditDialog(frame))));
    }
    
}
