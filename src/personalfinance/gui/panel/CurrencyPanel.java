package personalfinance.gui.panel;

import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.CurrencyAddEditDialog;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.CurrencyTableData;
import personalfinance.gui.toolbar.FunctionsToolBar;
import personalfinance.settings.Style;

public class CurrencyPanel extends RightPanel {
    
    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))),
                "CURRENCIES", Style.ICON_PANEL_CURRENCIES,
                new FunctionsToolBar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))));
    }
    
}
