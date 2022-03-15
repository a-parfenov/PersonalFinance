package personalfinance.gui.dialog;

import javax.swing.JOptionPane;
import personalfinance.gui.MainFrame;
import personalfinance.settings.Text;

public class ErrorDialog {
    
    public static void show(MainFrame frame, String text) {
        JOptionPane.showMessageDialog(frame, Text.get(text), Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);
    }
}
