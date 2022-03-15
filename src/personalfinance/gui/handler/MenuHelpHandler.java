package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import personalfinance.gui.MainFrame;
import personalfinance.gui.dialog.AboutDialog;
import personalfinance.settings.HandlerCode;

public class MenuHelpHandler extends Handler {
    
    public MenuHelpHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_HELP_ABOUT: {
                new AboutDialog().setVisible(true);
            }
        }
        super.actionPerformed(ae);
    }
    
}
