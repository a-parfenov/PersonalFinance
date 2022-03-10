package personalfinance.gui.dialog;

import personalfinance.gui.MainDatePicker;
import personalfinance.gui.MainFrame;
import personalfinance.saveload.SaveData;

import java.util.Date;
import javax.swing.JTextField;
import org.jdatepicker.impl.JDatePickerImpl;
import personalfinance.exception.ModelException;
import personalfinance.model.Account;
import personalfinance.model.Common;
import personalfinance.model.Transfer;
import personalfinance.settings.Format;
import personalfinance.settings.Style;

public class TransferAddEditDialog extends AccountAddEditDialog {

    public TransferAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put("LABEL_DATE", new MainDatePicker().getDatePicker());
        components.put("LABEL_FROM_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccountList().toArray()));
        components.put("LABEL_TO_ACCOUNT", new CommonComboBox(SaveData.getInstance().getAccountList().toArray()));
        components.put("LABEL_FROM_AMOUNT", new JTextField());
        components.put("LABEL_TO_AMOUNT", new JTextField());
        components.put("LABEL_NOTICE", new JTextField());

        icons.put("LABEL_DATE", Style.ICON_DATE);
        icons.put("LABEL_FROM_ACCOUNT", Style.ICON_ACCOUNT);
        icons.put("LABEL_TO_ACCOUNT", Style.ICON_ACCOUNT);
        icons.put("LABEL_FROM_AMOUNT", Style.ICON_AMOUNT);
        icons.put("LABEL_TO_AMOUNT", Style.ICON_AMOUNT);
        icons.put("LABEL_NOTICE", Style.ICON_NOTICE);

        values.put("LABEL_DATE", new Date());
        values.put("LABEL_FROM_AMOUNT", Format.amount(0));
        values.put("LABEL_TO_AMOUNT", Format.amount(0));
    }

    @Override
    protected void setValues() {
        Transfer transfer = (Transfer) c;
        values.put("LABEL_DATE", transfer.getDate());
        values.put("LABEL_FROM_ACCOUNT", transfer.getFromAccount());
        values.put("LABEL_TO_ACCOUNT", transfer.getToAccount());
        values.put("LABEL_FROM_AMOUNT", transfer.getFromAmount());
        values.put("LABEL_TO_AMOUNT", transfer.getToAmount());
        values.put("LABEL_NOTICE", transfer.getNotice());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        try {
            Account fromAccount = (Account) ((CommonComboBox) components.get("LABEL_FROM_ACCOUNT")).getSelectedItem();
            Account toAccount = (Account) ((CommonComboBox) components.get("LABEL_TO_ACCOUNT")).getSelectedItem();
            String fromAmount = ((JTextField) components.get("LABEL_FROM_AMOUNT")).getText();
            String toAmount = ((JTextField) components.get("LABEL_TO_AMOUNT")).getText();
            String notice = ((JTextField) components.get("LABEL_NOTICE")).getText();
            Date date = (Date) ((JDatePickerImpl) components.get("LABEL_DATE")).getModel().getValue();
            return new Transfer(fromAccount, toAccount, Format.fromAmountToNumber(fromAmount), Format.fromAmountToNumber(toAmount), notice, date);
        } catch (NumberFormatException ex) {
            throw new ModelException(ModelException.AMOUNT_FORMAT);
        }
    }
}
