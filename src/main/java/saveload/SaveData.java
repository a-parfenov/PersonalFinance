package saveload;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import exception.ModelException;
import model.*;

public final class SaveData {
    
    private static SaveData instance;
    private List<Article> articleList = new ArrayList();
    private List<Currency> currencieList = new ArrayList();
    private List<Account> accountList = new ArrayList();
    private List<Transaction> transactionList = new ArrayList();
    private List<Transfer> transferList = new ArrayList();
    
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
            a.setAmountFromTransactionsAndTransfers(transactionList, transferList);
        }
    }
    
    public void clear() {
        articleList.clear();
        currencieList.clear();
        accountList.clear();
        transactionList.clear();
        transferList.clear();
    }

    private void sort() {
        this.articleList.sort((Article a, Article a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
        this.accountList.sort((Account a, Account a1) -> a.getTitle().compareToIgnoreCase(a1.getTitle()));
        this.transactionList.sort((Transaction t, Transaction t1) -> (int) (t1.getDate().compareTo(t.getDate())));
        this.transferList.sort((Transfer t, Transfer t1) -> (int) (t1.getDate().compareTo(t.getDate())));
        this.currencieList.sort(new Comparator<Currency>() {
            @Override
            public int compare(Currency c, Currency c1) {
                if (c.isBase()) return -1;
                if (c1.isBase()) return 1;
                if (c.isOn() ^ c1.isOn()) {
                    if (c1.isOn()) return 1;
                    else return -1;
                }
                return c.getTitle().compareToIgnoreCase(c1.getTitle());
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
    
    public static SaveData getInstance() {
        if (instance == null) instance = new SaveData();
        return instance;
    }
    
    public Filter getFilter() {
        return filter;
    }

    public List<Article> getArticles() {
        return articleList;
    }

    public List<Currency> getCurrencies() {
        return currencieList;
    }

    public List<Account> getAccounts() {
        return accountList;
    }

    public List<Transaction> getTransactions() {
        return transactionList;
    }

    public List<Transfer> getTransfers() {
        return transferList;
    }

    public void setArticles(List<Article> articles) {
        if (articles != null) this.articleList = articles;
    }

    public void setCurrencies(List<Currency> currencies) {
        if (currencies != null) this.currencieList = currencies;
    }

    public void setAccounts(List<Account> accounts) {
        if (accounts != null) this.accountList = accounts;
    }

    public void setTransactions(List<Transaction> transactions) {
        if (transactions != null) this.transactionList = transactions;
    }

    public void setTransfers(List<Transfer> transfers) {
        if (transfers != null) this.transferList = transfers;
    }
    
    public Currency getBaseCurrency() {
        for (Currency c : currencieList)
            if (c.isBase()) return c;
        return new Currency();
    }
    
    public ArrayList<Currency> getEnableCurrencies() {
        ArrayList<Currency> list = new ArrayList();
        for (Currency c : currencieList)
            if (c.isOn()) list.add(c);
        return list;
    }
    
    public List<Transaction> getFilterTransactions() {
        ArrayList<Transaction> list = new ArrayList();
        for (Transaction t : transactionList)
            if (filter.check(t.getDate())) list.add(t);
        return list;
    }
    
    public List<Transfer> getFilterTransfers() {
        ArrayList<Transfer> list = new ArrayList();
        for (Transfer t : transferList)
            if (filter.check(t.getDate())) list.add(t);
        return list;
    }
    
    public List<Transaction> getTransactionsOnCount(int count) {
        return new ArrayList(transactionList.subList(0, Math.min(count, transactionList.size())));
    }
    
    public Common getOldCommon() {
        return oldCommon;
    }
    
    public void add(Common c) throws ModelException {
        List ref = getRef(c);
        if (ref.contains(c)) throw new ModelException(ModelException.IS_EXISTS);
        ref.add(c);
        c.postAdd(this);
        sort();
        saved = false;
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
    
    public void remove(Common c) {
        getRef(c).remove(c);
        c.postRemove(this);
        saved = false;
    }

    @Override
    public String toString() {
        return "SaveData{"
                + "articles=" + articleList
                + ", currencies=" + currencieList
                + ", accounts=" + accountList
                + ", transactions=" + transactionList
                + ", transfers=" + transferList + '}';
    }
    
    public void updateCurrencies() throws Exception {
        HashMap<String, Double> rates = RateCurrency.getRates(getBaseCurrency());
        for (Currency c : currencieList)
            c.setRate(rates.get(c.getCode()));
        for (Account a : accountList)
            a.getCurrency().setRate(rates.get(a.getCurrency().getCode()));
        saved = false;
    }
    
    private List getRef(Common c) {
        if (c instanceof Account) return accountList;
        else if (c instanceof Article) return articleList;
        else if (c instanceof Currency) return currencieList;
        else if (c instanceof Transaction) return transactionList;
        else if (c instanceof Transfer) return transferList;
        return null;
    }
    
}
