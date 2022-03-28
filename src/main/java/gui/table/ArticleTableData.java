package gui.table;

import javax.swing.ImageIcon;
import gui.handler.FunctionsHandler;
import gui.table.model.ArticleTableModel;
import settings.Style;

public class ArticleTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE};
    
    public ArticleTableData(FunctionsHandler handler) {
        super(new ArticleTableModel(columns), handler, columns, icons);
    }
    
}
