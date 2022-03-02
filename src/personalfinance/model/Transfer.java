package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.Date;

public class Transfer extends Common{

    private Account fromAccount;
    private Account toAccount;
    private double fromAmount;
    private double toAmount;
    private String notice;
    private Date date;

    public Transfer() {}

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice, Date date) throws ModelException {
        if (fromAccount == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (toAccount == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (fromAmount < 0 || toAmount < 0) throw new ModelException(ModelException.AMOUNT_FORMAT);
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
        this.notice = notice;
        this.date = date;
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, String notice) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, notice, new Date());
    }

    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount, Date date) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, "", date);
    }
    public Transfer(Account fromAccount, Account toAccount, double fromAmount, double toAmount) throws ModelException {
        this(fromAccount, toAccount, fromAmount, toAmount, "", new Date());
    }

    @Override
    public String toString() {
        return "Transfer{" +
                "fromAccount=" + fromAccount +
                ", toAccount=" + toAccount +
                ", fromAmount=" + fromAmount +
                ", toAmount=" + toAmount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public void setToAccount(Account toAccount) {
        this.toAccount = toAccount;
    }

    public void setFromAmount(double fromAmount) {
        this.fromAmount = fromAmount;
    }

    public void setToAmount(double toAmount) {
        this.toAmount = toAmount;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public double getFromAmount() {
        return fromAmount;
    }

    public double getToAmount() {
        return toAmount;
    }

    public String getNotice() {
        return notice;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public void postAdd(SaveData sd) {
        setAmounts(sd);
    }

    public void postEdit(SaveData sd) {
        setAmounts(sd);
    }

    public void postRemove(SaveData sd) {
        setAmounts(sd);
    }

    private void setAmounts(SaveData sd) {
        for (Account a : sd.getAccountList())
            a.setAmountFromTransactionsAndTransfers(sd.getTransactionsList(), sd.getTransferList());
    }
}
