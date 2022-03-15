package personalfinance.gui.handler;

import java.awt.event.ActionEvent;
import personalfinance.gui.MainFrame;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Settings;
import personalfinance.settings.Text;

public class MenuSettingsHandler extends Handler {
    
    public MenuSettingsHandler(MainFrame frame) {
        super(frame);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        switch (ae.getActionCommand()) {
            case HandlerCode.MENU_SETTINGS_LANGUAGE_RUSSIAN: {
                Settings.setLanguage("ru");
                break;
            }
            case HandlerCode.MENU_SETTINGS_LANGUAGE_ENGLISH: {
                Settings.setLanguage("en");
            }
        }
        Text.init();
        frame.getMenu().refresh();
        super.actionPerformed(ae);
    }
    
}
