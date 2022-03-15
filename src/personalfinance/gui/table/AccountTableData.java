package personalfinance.gui.table;

import javax.swing.ImageIcon;
import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.AccountTableModel;
import personalfinance.settings.Style;

public class AccountTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE", "AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_AMOUNT};
    
    public AccountTableData(FunctionsHandler handler) {
        super(new AccountTableModel(columns), handler, columns, icons);
    }
}
