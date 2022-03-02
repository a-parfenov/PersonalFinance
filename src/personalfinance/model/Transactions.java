package personalfinance.model;

import personalfinance.exception.ModelException;
import personalfinance.saveload.SaveData;

import java.util.Date;

public class Transactions extends Common {

    private Account account;
    private Article article;
    private double amount;
    private String notice;
    private Date date;

    public Transactions() {}

    public Transactions(Account account, Article article, double amount, String notice, Date date) throws ModelException {
        if (account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notice = notice;
        this.date = date;
    }

    public Transactions(Account account, Article article, double amount) throws ModelException {
        if (account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notice = "";
        this.date = new Date();
    }

    public Transactions(Account account, Article article, double amount, String notice) throws ModelException {
        if (account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notice = notice;
        this.date = new Date();
    }

    public Transactions(Account account, Article article, double amount, Date date) throws ModelException {
        if (account == null) throw new ModelException(ModelException.ACCOUNT_EMPTY);
        if (article == null) throw new ModelException(ModelException.ARTICLE_EMPTY);
        this.account = account;
        this.article = article;
        this.amount = amount;
        this.notice = "";
        this.date = date;
    }

    public Account getAccount() {
        return account;
    }

    public Article getArticle() {
        return article;
    }

    public double getAmount() {
        return amount;
    }

    public String getNotice() {
        return notice;
    }

    public Date getDate() {
        return date;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "account=" + account +
                ", article=" + article +
                ", amount=" + amount +
                ", notice='" + notice + '\'' +
                ", date=" + date +
                '}';
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
