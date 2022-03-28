package gui.panel;

import gui.MainFrame;
import gui.dialog.CurrencyAddEditDialog;
import gui.handler.FunctionsHandler;
import gui.table.CurrencyTableData;
import gui.toolbar.FunctionsToolBar;
import settings.Style;

public class CurrencyPanel extends RightPanel {
    
    public CurrencyPanel(MainFrame frame) {
        super(frame, new CurrencyTableData(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))),
                "CURRENCIES", Style.ICON_PANEL_CURRENCIES,
                new FunctionsToolBar(new FunctionsHandler(frame, new CurrencyAddEditDialog(frame))));
    }
    
}
