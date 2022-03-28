package model;

import java.util.Objects;
import exception.ModelException;
import saveload.SaveData;

public class Article extends Common {
    
    private String title;
    
    public Article() {}
    
    public Article(String title) throws ModelException {
        if (title.length() == 0) throw new ModelException(ModelException.TITLE_EMPTY);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Article{" + "title=" + title + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.title);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Article other = (Article) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String getValueForComboBox() {
        return title;
    }
    
    @Override
    public void postEdit(SaveData sd) {
        for (Transaction t : sd.getTransactions())
            if (t.getArticle().equals(sd.getOldCommon())) t.setArticle(this);
    }
    
}
