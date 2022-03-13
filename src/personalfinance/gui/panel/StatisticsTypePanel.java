package personalfinance.gui.panel;

import personalfinance.gui.MainButton;
import personalfinance.gui.MainFrame;
import personalfinance.settings.HandlerCode;
import personalfinance.settings.Text;

public final class StatisticsTypePanel extends AbstractPanel {

    private final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = Text.get(title);
        init();
    }

    @Override
    protected void init() {
        MainButton type = new MainButton(title, null, HandlerCode.TYPE);
        add(type);
    }

}
