package personalfinance.saveload;

import personalfinance.exception.ModelException;
import personalfinance.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class SaveData {

    private static SaveData instanse;
    private List<Article> articleList = new ArrayList<>();
    private List<Currency> currencyList = new ArrayList<>();
    private List<Account> accountList = new ArrayList<>();
    private List<Transactions> transactionsList = new ArrayList<>();
    private List<Transfer> transferList = new ArrayList<>();

    private final Filter filter;
    private Common oldCommon;
    private boolean saved = true;

    public SaveData() {
        load();
        this.filter = new Filter();
    }
    public void load() {
        SaveLoad.load(this);
        sort();
        for (Account a : accountList) {
            a.setAmountFromTransactionsAndTransfers(transactionsList, transferList);
        }
    }

    private void sort() {
        this.articleList.sort((Article t, Article t1) -> t.getTitle().compareToIgnoreCase(t1.getTitle()));
        this.accountList.sort((Account t, Account t1) -> t.getTitle().compareToIgnoreCase(t1.getTitle()));
        this.transactionsList.sort((Transactions t, Transactions t1) -> (int) (t1.getDate().compareTo(t.getDate())));
        this.transferList.sort((Transfer t, Transfer t1) -> (int) (t1.getDate().compareTo(t.getDate())));
        this.currencyList.sort(new Comparator<Currency>() {
            @Override
            public int compare(Currency o1, Currency o2) {
                if (o1.isBase())
                    return -1;
                if (o2.isBase())
                    return 1;
                if (o1.isOn() ^ o2.isOn())
                    if (o2.isOn())
                        return 1;
                    else
                        return -1;
                return o1.getTitle().compareToIgnoreCase(o2.getTitle());
            }
        });
    }

    public void save() {
        SaveLoad.save(this);
        saved = true;
    }

    public boolean isSaved() {
        return saved;
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
        if (articleList != null)
            this.articleList = articleList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        if (currencyList != null)
            this.currencyList = currencyList;
    }

    public void setAccountList(List<Account> accountList) {
        if (accountList != null)
            this.accountList = accountList;
    }

    public void setTransactionsList(List<Transactions> transactionsList) {
        if (transactionsList != null)
            this.transactionsList = transactionsList;
    }

    public void setTransferList(List<Transfer> transferList) {
        if (transferList != null)
            this.transferList = transferList;
    }

    public Currency getBaseCurrency() {
        for (Currency currency : currencyList) {
            if (currency.isBase())
                return currency;
        }
        return new Currency();
    }

    public ArrayList<Currency> getEnableCurrencies() {
        ArrayList<Currency> list = new ArrayList<>();
        for (Currency c : currencyList)
            if (c.isOn())
                list.add(c);
        return list;
    }

    public List<Transactions> getFilterTransactions() {
        ArrayList<Transactions> list = new ArrayList<>();
        for (Transactions t : transactionsList)
            if (filter.check(t.getDate()))
                list.add(t);
        return list;
    }

    public List<Transfer> getFilterTransfers() {
        ArrayList<Transfer> list = new ArrayList<>();
        for (Transfer t : transferList)
            if (filter.check(t.getDate()))
                list.add(t);
        return list;
    }

    public List<Transactions> getTransactionsOnCount(int count) {
        return new ArrayList<>(transactionsList.subList(0, Math.min(count, transactionsList.size())));
    }

    public Common getOldCommon() {
        return oldCommon;
    }

    public void add(Common c) throws ModelException {
        List ref = getRef(c);
        if (ref.contains(c))
            throw new ModelException(ModelException.IS_EXISTS);
        ref.add(c);
        c.postAdd(this);
        sort();
        saved = false;
    }

    private List getRef(Common c) {
        if (c instanceof Account)
            return accountList;
        else if (c instanceof Article)
            return articleList;
        else if (c instanceof Currency)
            return currencyList;
        else if (c instanceof Transactions)
            return transactionsList;
        else if (c instanceof Transfer)
            return transferList;
        return null;
    }

    public void edit(Common oldC, Common newC) throws ModelException {
        List ref = getRef(oldC);
        if (ref.contains(newC) && oldC != ref.get(ref.indexOf(newC))) throw new ModelException(ModelException.IS_EXISTS);
        ref.set(ref.indexOf(oldC), newC);
        oldCommon = oldC;
        newC.postEdit(this);
        sort();
        saved = false;
    }

    public void updateCurrencies() throws Exception {
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for (Currency c : currencyList)
            c.setRate(rates.get(c.getCode()));
        for (Account a : accountList)
            a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
    }

    public void remove(Common c) {
        getRef(c).remove(c);
        c.postRemove(this);
        saved = false;
    }

    public List<Article> getArticles() {
        return articleList;
    }

    public List<Currency> getCurrencies() {
        return currencyList;
    }

    public List<Account> getAccounts() {
        return accountList;
    }

    public List<Transactions> getTransactions() {
        return transactionsList;
    }

    public List<Transfer> getTransfers() {
        return transferList;
    }

    @Override
    public String toString() {
        return "SaveData{" +
                "articleList=" + articleList +
                ", currencyList=" + currencyList +
                ", accountList=" + accountList +
                ", transactionsList=" + transactionsList +
                ", transferList=" + transferList +
                '}';
    }

    public void clear() {
        articleList.clear();
        currencyList.clear();
        accountList.clear();
        transferList.clear();
        transactionsList.clear();
    }
}
