package personalfinance.model;

import personalfinance.exception.ModelException;

public class Currency extends Common {
    private String title;
    private String code;
    private double rate;
    private boolean isOn;
    private boolean isBase;

    public Currency() {}

    public Currency(String title, String code, double rate, boolean isOn, boolean isBase) throws ModelException {
        if (title.length()  == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.isBase = isBase;
        this.isOn = isOn;
    }
}
