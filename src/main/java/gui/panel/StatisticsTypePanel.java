package gui.panel;

import gui.MainButton;
import gui.MainFrame;
import gui.handler.ChartHandler;
import settings.HandlerCode;
import settings.Text;

public final class StatisticsTypePanel extends AbstractPanel {

    private final String title;

    public StatisticsTypePanel(MainFrame frame, String title) {
        super(frame);
        this.title = Text.get(title);
        init();
    }

    @Override
    protected void init() {
        MainButton type = new MainButton(title, new ChartHandler(frame), HandlerCode.TYPE);
        add(type);
    }
}
