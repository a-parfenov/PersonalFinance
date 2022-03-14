package personalfinance.gui.dialog;

import personalfinance.gui.MainFrame;
import personalfinance.settings.Text;

import javax.swing.*;

public class ConfirmDialog {
    public static int show(MainFrame frame, String text, String title) {
        String[] options = {Text.get("YES"), Text.get("NO")};
        int res = JOptionPane.showOptionDialog(frame, Text.get(text), Text.get(title),
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        return res;
    }
}
