package gui.table;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import gui.handler.FunctionsHandler;
import gui.table.model.CurrencyTableModel;
import gui.table.renderer.MainTableCellRenderer;
import model.Currency;
import settings.Style;
import settings.Text;

public class CurrencyTableData extends TableData {
    
    private static final String[] columns = new String[]{"TITLE", "CODE", "RATE", "ON", "BASE"};
    private static final ImageIcon[] icons = new ImageIcon[]{Style.ICON_TITLE, Style.ICON_CODE, Style.ICON_RATE, Style.ICON_ON, Style.ICON_BASE};
    
    public CurrencyTableData(FunctionsHandler handler) {
        super(new CurrencyTableModel(columns), handler, columns, icons);
        init();
    }
    
    @Override
    protected final void init() {
        for (String column : columns) {
            getColumn(Text.get(column)).setCellRenderer(new TableCellOnOffRenderer());
        }
    }
    
    private class TableCellOnOffRenderer extends MainTableCellRenderer {
        
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component renderer = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            if (((Currency) ((CurrencyTableModel) table.getModel()).getCommonByRow(row)).isOn())
                renderer.setForeground(Style.COLOR_ON);
            else renderer.setForeground(Style.COLOR_OFF);
            return renderer;
        }
    }
}
