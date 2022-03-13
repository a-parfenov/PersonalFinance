package personalfinance.model;

import personalfinance.saveload.SaveData;

import java.util.HashMap;
import java.util.List;

public class Statistics {

    public static double getBalanceCurrency(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccountList()) {
            if (currency.equals(account.getCurrency())) {
                amount += account.getAmount();
            }
        }
        return amount;
    }

    public static double getBalance(Currency currency) {
        SaveData sd = SaveData.getInstance();
        double amount = 0;
        for (Account account : sd.getAccountList()) {
            amount += account.getAmount() * account.getCurrency().getRateByCurrency(currency);
        }
        return amount;
    }

    private static HashMap<String, Double> getDataForChartOnArticles(boolean income) {
        List<Transactions> transactionsList = SaveData.getInstance().getTransactionsList();
        HashMap<String, Double> data = new HashMap<>();
        for (Transactions transactions : transactionsList) {
            if (income && transactions.getAmount() > 0) {
                String key = transactions.getArticle().getTitle();
                double sum = 0;
                double amount = transactions.getAmount();
                if (!income)
                    amount *= -1;
                if (data.containsKey(key))
                    sum = data.get(key);
                sum = amount * transactions.getAccount().getCurrency().getRateByCurrency(SaveData.getInstance().getBaseCurrency());
                data.put(key, round(sum));
            }
        }
        return data;
    }

    private static double round(double value) {
        return (double) Math.round(value * 100) / 100;
    }

    public static HashMap<String, Double> getDataForChartOnIncomeArticles() {
        return getDataForChartOnArticles(true);
    }

    public static HashMap<String, Double> getDataForChartOnExpArticles() {
        return getDataForChartOnArticles(false);
    }
}
