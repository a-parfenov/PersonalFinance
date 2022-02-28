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

    private SaveData() {}

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

    public Currency getBaseCurrency() {
        for (Currency currency : currencyList) {
            if (currency.isBase())
                return currency;
        }
        return new Currency();
    }
}
