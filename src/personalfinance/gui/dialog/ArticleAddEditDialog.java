package personalfinance.gui.dialog;

import javax.swing.JTextField;
import personalfinance.exception.ModelException;
import personalfinance.gui.MainFrame;
import personalfinance.model.Article;
import personalfinance.model.Common;
import personalfinance.settings.Style;

public class ArticleAddEditDialog extends AddEditDialog {

    public ArticleAddEditDialog(MainFrame frame) {
        super(frame);
    }

    @Override
    protected void init() {
        components.put("LABEL_TITLE", new JTextField());
        
        icons.put("LABEL_TITLE", Style.ICON_TITLE);
    }

    @Override
    protected void setValues() {
        Article article = (Article) c;
        values.put("LABEL_TITLE", article.getTitle());
    }

    @Override
    public Common getCommonFromForm() throws ModelException {
        String title = ((JTextField) components.get("LABEL_TITLE")).getText();
        return new Article(title);
    }
    
}
