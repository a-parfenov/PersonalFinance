package personalfinance;

import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.*;
import personalfinance.saveload.SaveData;
import personalfinance.settings.Settings;
import personalfinance.settings.Text;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalFinance {
    public static void main(String[] args) throws Exception {
        init();
        SaveData sd = SaveData.getInstance();
        MainFrame frame = new MainFrame();
        frame.setVisible(true);

        System.out.println(sd.getCurrencyList());
    }

    private static void testModel() throws ModelException {
        Currency c1 = new Currency("Рубль", "RUB", 1, true, true);
        Currency c2 = new Currency("Доллар", "USD", 65, true, false);
        Currency c3 = new Currency("Евро", "EUR", 75, false, false);
        Currency c4 = new Currency("Гривна", "UAH", 2.5, false, false);

        Account ac1 = new Account("Кошелек", c1, 1000);
        Account ac2 = new Account("Карта VISA", c1, 0);
        Account ac3 = new Account("Депозит 1", c1, 100000);
        Account ac4 = new Account("Депозит 2", c2, 0);

        Article article1 = new Article("Продукты");
        Article article2 = new Article("Транспорт");
        Article article3 = new Article("Здоровье");
        Article article4 = new Article("Зарплата");

        ArrayList<Currency> currencyArrayList = new ArrayList<>();
        currencyArrayList.add(c1);
        currencyArrayList.add(c2);
        currencyArrayList.add(c3);
        currencyArrayList.add(c4);

        ArrayList<Account> accountArrayList = new ArrayList<>();
        accountArrayList.add(ac1);
        accountArrayList.add(ac2);
        accountArrayList.add(ac3);
        accountArrayList.add(ac4);

        ArrayList<Article> articleArrayList = new ArrayList<>();
        articleArrayList.add(article1);
        articleArrayList.add(article2);
        articleArrayList.add(article3);
        articleArrayList.add(article4);

        ArrayList<Transactions> transactionsArrayList = new ArrayList<>();
        transactionsArrayList.add(new Transactions(ac2, article3, 30000));
        transactionsArrayList.add(new Transactions(ac2, article1, -1500, "Запасы"));
        transactionsArrayList.add(new Transactions(ac1, article2, -3500, "Бензин"));
        transactionsArrayList.add(new Transactions(ac1, article2, 10750, "Билет на самолет"));
        transactionsArrayList.add(new Transactions(ac3, article4, 40000));
        transactionsArrayList.add(new Transactions(ac2, article3, 2500, new Date(new Date().getTime() - (long) 86400000 * 30)));

        for (int i = 0; i < 50; i++) {
            Article tempArticle;
            Account tempAccount;
            if (Math.random() < 0.5)
                tempArticle = article1;
            else
                tempArticle = article4;
            if (Math.random() < 0.5)
                tempAccount = ac1;
            else
                tempAccount = ac2;
            double tempAmount = Math.round(Math.random() * (-1000));
            Date tempDate = new Date((long) (new Date().getTime() - (long) 86400000 * 30 * Math.random()));
            transactionsArrayList.add(new Transactions(tempAccount, tempArticle, tempAmount, tempDate));
        }
        ArrayList<Transfer> transferArrayList = new ArrayList<>();
        transferArrayList.add(new Transfer(ac2, ac1, 25000, 25000));
        transferArrayList.add(new Transfer(ac2, ac3, 30000, 36000));
        transferArrayList.add(new Transfer(ac2, ac4, 6000, 90));

        for (Account a : accountArrayList) {
            a.setAmountFromTransactionsAndTransfers(transactionsArrayList, transferArrayList);
        }

        SaveData sd = new SaveData().getInstance();
        sd.setArticleList(articleArrayList);
        sd.setCurrencyList(currencyArrayList);
        sd.setTransactionsList(transactionsArrayList);
        sd.setTransferList(transferArrayList);
        sd.setAccountList(accountArrayList);
        sd.save();

    }

    private static void init() {
        try {
            Text.init();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, Settings.FONT_ROBOTO_LIGHT));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(PersonalFinance.class.getName()).log(Level.SEVERE, null, e);
        }
    }


}
