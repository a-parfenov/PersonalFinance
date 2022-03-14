package personalfinance.gui.table;

import personalfinance.gui.handler.FunctionsHandler;
import personalfinance.gui.table.model.ArticleTableModel;
import personalfinance.settings.Style;

import javax.swing.*;

public class ArticleTableData extends TableData {

    private static final String[] columns = new String[]{"TITLE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE};

    public ArticleTableData(FunctionsHandler handler) {
        super(new ArticleTableModel(columns), handler, columns, icons);
    }
}
