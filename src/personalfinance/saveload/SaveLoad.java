package personalfinance.saveload;

import personalfinance.settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SaveLoad {

    public static void load(SaveData sd) {
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) um.unmarshal(Settings.getFileSave());

            sd.setAccountList(wrapper.getAccount());
            sd.setArticleList(wrapper.getArticle());
            sd.setTransactionsList(wrapper.getTransactions());
            sd.setTransferList(wrapper.getTransferList());
            sd.setCurrencyList(wrapper.getCurrency());
        } catch (JAXBException e) {
            System.out.println("Файл не существует");
        }
    }

    public static void save(SaveData sd) {

        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Wrapper wrapper = new Wrapper();

            wrapper.setAccount(sd.getAccountList());
            wrapper.setArticle(sd.getArticleList());
            wrapper.setTransactions(sd.getTransactionsList());
            wrapper.setTransferList(sd.getTransferList());
            wrapper.setCurrency(sd.getCurrencyList());

            m.marshal(wrapper, Settings.getFileSave());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
