package personalfinance.model;

import personalfinance.exception.ModelException;

import java.util.Objects;

public class Currency extends Common {
    private String title;
    private String code;
    private double rate;
    private boolean On;
    private boolean Base;

    public Currency() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setOn(boolean on) {
        this.On = on;
    }

    public void setBase(boolean base) {
        this.Base = base;
    }

    public String getTitle() {
        return title;
    }

    public String getCode() {
        return code;
    }

    public double getRate() {
        return rate;
    }

    public boolean isOn() {
        return On;
    }

    public boolean isBase() {
        return Base;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "title='" + title + '\'' +
                ", code='" + code + '\'' +
                ", rate=" + rate +
                ", isOn=" + On +
                ", isBase=" + Base +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Currency currency = (Currency) o;

        return code.equals(currency.code);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 25 * hash + Objects.hashCode(this.code);
        return hash;
    }

    public Currency(String title, String code, double rate, boolean isOn, boolean isBase) throws ModelException {
        if (title.length()  == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (code.length()  == 0) throw new ModelException(ModelException.CODE_EMPTY);
        if (rate  <= 0) throw new ModelException(ModelException.RATE_INCORRECT);

        this.title = title;
        this.code = code;
        this.rate = rate;
        this.Base = isBase;
        this.On = isOn;
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    public double getRateByCurrency(Currency currency) {
        return rate / currency.rate;
    }
}
