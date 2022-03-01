package personalfinance.saveload;

import personalfinance.model.*;

import java.util.ArrayList;
import java.util.List;

public class SaveData {

    private static SaveData instanse;
    private List<Article> articleList = new ArrayList<>();
    private List<Currency> currencyList = new ArrayList<>();
    private List<Account> accountList = new ArrayList<>();
    private List<Transactions> transactionsList = new ArrayList<>();
    private List<Transfer> transferList = new ArrayList<>();

    private final Filter filter;
    private Common aldCommon;
    private boolean isSaved = true;

    private SaveData() {
        load();
        this.filter = new Filter();
    }
    public void load() {
        SaveLoad.load(this);

    }

    public Filter getFilter() {
        return filter;
    }
    public static SaveData getInstance() {
        if (instanse == null)
            instanse = new SaveData();
        return instanse;
    }

    public List<Article> getArticleList() {
        return articleList;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public List<Transactions> getTransactionsList() {
        return transactionsList;
    }

    public List<Transfer> getTransferList() {
        return transferList;
    }

    public void setArticleList(List<Article> articleList) {
        this.articleList = articleList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        this.transactionsList = transactionsList;
    }

    public void setTransferList(List<Transfer> transferList) {
        this.transferList = transferList;
    }

    public Currency getBaseCurrency() {
        for (Currency currency : currencyList) {
            if (currency.isBase())
                return currency;
        }
        return new Currency();
    }
}
