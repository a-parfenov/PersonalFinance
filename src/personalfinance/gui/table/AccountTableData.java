package personalfinance.gui.table;

import personalfinance.gui.table.model.AccountTableModel;
import personalfinance.settings.Style;

import javax.swing.*;

public class AccountTableData extends TableData{

    private static final String[] columns = new String[]{"TITLE", "AMOUNT"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_AMOUNT};

    public AccountTableData() {
        super(new AccountTableModel(columns), columns, icons);
    }
}
