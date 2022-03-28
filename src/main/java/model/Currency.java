package model;

import java.util.Objects;
import exception.ModelException;
import saveload.SaveData;

public class Currency extends Common {
    
    private String title;
    private String code;
    private double rate;
    private boolean on;
    private boolean base;
    
    public Currency() {}

    public Currency(String title, String code, double rate, boolean on, boolean base) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (code.length() == 0) throw new ModelException(ModelException.CODE_EMPTY);
        if (rate <= 0) throw new ModelException(ModelException.RATE_INCORRECT);
        
        this.title = title;
        this.code = code;
        this.rate = rate;
        this.on = on;
        this.base = base;
        if (this.base) this.on = true;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isBase() {
        return base;
    }

    public void setBase(boolean base) {
        this.base = base;
    }

    @Override
    public String toString() {
        return "Currency{" + "title=" + title
                + ", code=" + code
                + ", rate=" + rate
                + ", isOn=" + on
                + ", isBase=" + base + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Currency other = (Currency) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String getValueForComboBox() {
        return title;
    }
    
    public double getRateByCurrency(Currency currency) {
        return rate / currency.rate;
    }
    
    @Override
    public void postAdd(SaveData sd) {
        clearBase(sd);
    }
    
    @Override
    public void postEdit(SaveData sd) {
        clearBase(sd);
        for (Currency c : sd.getCurrencies()) {
            for (Account a : sd.getAccounts()) {
                if (a.getCurrency().equals(c)) a.setCurrency(c);
            }
            for (Transaction t : sd.getTransactions())
                if (t.getAccount().getCurrency().equals(c)) t.getAccount().setCurrency(c);
            for (Transfer t : sd.getTransfers()) {
                if (t.getFromAccount().getCurrency().equals(c)) t.getFromAccount().setCurrency(c);
                if (t.getToAccount().getCurrency().equals(c)) t.getToAccount().setCurrency(c);
            }
        }
        
    }

    private void clearBase(SaveData sd) {
        if (base) {
            rate = 1;
            Currency old = (Currency) sd.getOldCommon();
            for (Currency c : sd.getCurrencies()) {
                if (!this.equals(c)) {
                    c.setBase(false);
                    if (old != null) c.setRate(c.rate / old.rate);
                }
            }
        }
    }

}
