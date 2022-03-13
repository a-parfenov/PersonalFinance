package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.table.AccountTableData;
import personalfinance.gui.table.TransactionTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Settings;
import personalfinance.settings.Style;

public class AccountPanel extends RightPanel {

    public AccountPanel(MainFrame frame) {
        super(frame, new TransactionTableData(Settings.COUNT_OVERVIEW_ROWS),
                "ACCOUNTS", Style.ICON_PANEL_ACCOUNTS,
                new FunctionsToolBar());
    }
}
