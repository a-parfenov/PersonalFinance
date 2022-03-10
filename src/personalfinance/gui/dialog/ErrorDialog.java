package personalfinance.gui.dialog;

import personalfinance.gui.MainFrame;
import personalfinance.settings.Text;

import javax.swing.*;

public class ErrorDialog {

    public static void show(MainFrame frame, String text) {
        JOptionPane.showMessageDialog(frame, text, Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);
    }
}
