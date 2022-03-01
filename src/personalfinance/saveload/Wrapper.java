package personalfinance.saveload;

import personalfinance.model.*;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "data")
public class Wrapper {

    private List<Article> articles;
    private List<Currency> currency;
    private List<Account> accounts;
    private List<Transactions> transactions;
    private List<Transfer> transfers;

    @XmlElement(name = "articles")
    public List<Article> getArticle() {
        return articles;
    }

    public void setArticle(List<Article> article) {
        this.articles = article;
    }

    @XmlElement(name = "currency")
    public List<Currency> getCurrency() {
        return currency;
    }

    public void setCurrency(List<Currency> currency) {
        this.currency = currency;
    }

    @XmlElement(name = "accounts")
    public List<Account> getAccount() {
        return accounts;
    }

    public void setAccount(List<Account> account) {
        this.accounts = account;
    }

    @XmlElement(name = "transactions")
    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    @XmlElement(name = "transfers")
    public List<Transfer> getTransferList() {
        return transfers;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transfers = transferList;
    }
}
