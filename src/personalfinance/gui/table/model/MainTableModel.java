package personalfinance.gui.table.model;

import personalfinance.gui.Refresh;
import personalfinance.model.Common;
import personalfinance.settings.Text;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract public class MainTableModel extends AbstractTableModel implements Refresh {

    protected List<? extends Common> data;
    protected List<String> columns = new ArrayList<>();

    public MainTableModel(List data, String[] collums) {
        this.data = data;
        this.columns = new ArrayList(Arrays.asList(columns));
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columns.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return Text.get(columns.get(columnIndex));
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        Object obj = getValueAt(0, columnIndex);
        if (obj == null)
            return Object.class;
        return obj.getClass();
    }

    @Override
    public void refresh() {
        updateData();
        fireTableStructureChanged();
        fireTableDataChanged();
    }

    abstract protected void updateData();
}
