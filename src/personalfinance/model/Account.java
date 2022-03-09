package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.List;
import java.util.Objects;

public class Account extends Common{

    private String title;
    private Currency currency;
    private double startAmount;
    private double amount;

    public Account() {}

    public Account(String title, Currency currency, double startAmount) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        if (currency == null) throw new ModelException(ModelException.CURRENCY_EMPTY);
        this.title = title;
        this.currency = currency;
        this.startAmount = startAmount;
    }

    public double getAmount() {
        return amount;
    }

    public String getTitle() {
        return title;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.title);
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
        final Account other = (Account) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }

    @Override
    public String getValueForComboBox() {
        return title;
    }

    public void setAmountFromTransactionsAndTransfers(List<Transactions> transactions, List<Transfer> transfers) {
        this.amount = startAmount;
        for (Transactions trans : transactions) {
            if (trans.getAccount().equals(this)) {
                this.amount += trans.getAmount();
            }
        }
        for (Transfer transfer : transfers) {
            if (transfer.getFromAccount().equals(this)) {
                this.amount -= transfer.getFromAmount();
            }
            if (transfer.getFromAccount().equals(this)) {
                this.amount += transfer.getToAmount();
            }
        }
    }

    @Override
    public void postAdd(SaveData sd) {
        setAmountFromTransactionsAndTransfers(sd.getTransactionsList(), sd.getFilterTransfers());
    }

    @Override
    public void postEdit(SaveData sd) {
        for (Transactions t : sd.getTransactionsList())
            if (sd.getAccountList().equals(sd.getOldCommon())) // сравниваем текущее значение с предыдущим
                t.setAccount(this);
        for (Transfer t : sd.getTransferList()) {
            if (t.getFromAccount().equals(sd.getOldCommon()))
                t.setFromAccount(this);
            if (t.getToAccount().equals(sd.getOldCommon()))
                t.setToAccount(this);
        }
        setAmountFromTransactionsAndTransfers(sd.getTransactionsList(), sd.getFilterTransfers());
    }

    @Override
    public String toString() {
        return "Account{" +
                "title='" + title + '\'' +
                ", currency=" + currency +
                ", startAmount=" + startAmount +
                ", amount=" + amount +
                '}';
    }
}
