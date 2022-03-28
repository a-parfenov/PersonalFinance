package gui;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import settings.Settings;
import settings.Text;

public class MainFileChooser extends JFileChooser {

    private final MainFrame frame;
    
    public MainFileChooser(MainFrame frame) {
        this.frame = frame;
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Program Files", Settings.SAVE_FILE_EXT);
        setFileFilter(filter);
        setAcceptAllFileFilterUsed(false);
        setCurrentDirectory(Settings.SAVE_DIR);
        
        UIManager.put("FileChooser.saveDialogTitleText", Text.get("FC_SAVE"));
        UIManager.put("FileChooser.lookInLabelText", Text.get("FC_LOOK"));
        UIManager.put("FileChooser.saveInLabelText", Text.get("FC_LOOK"));
        UIManager.put("FileChooser.openDialogTitleText", Text.get("FC_OPEN"));
        
        UIManager.put("FileChooser.homeFolderToolTipText", Text.get("FC_HOME"));
        
        UIManager.put("FileChooser.openButtonText", Text.get("FC_OPEN"));
        UIManager.put("FileChooser.openButtonToolTipText", Text.get("FC_OPEN"));
        UIManager.put("FileChooser.saveButtonText", Text.get("FC_SAVE"));
        UIManager.put("FileChooser.saveButtonToolTipText", Text.get("FC_SAVE"));
        UIManager.put("FileChooser.cancelButtonText", Text.get("FC_CANCEL"));
        UIManager.put("FileChooser.cancelButtonToolTipText", Text.get("FC_CANCEL"));
        
        UIManager.put("FileChooser.fileNameLabelText", Text.get("FC_NAME_FILE"));
        UIManager.put("FileChooser.filesOfTypeLabelText", Text.get("FC_TYPE_FILE"));
        
        UIManager.put("FileChooser.upFolderToolTipText", Text.get("FC_UP"));
        UIManager.put("FileChooser.newFolderToolTipText", Text.get("FC_NEW_DIRECTORY"));
        UIManager.put("FileChooser.listViewButtonToolTipText", Text.get("FC_LIST"));
        UIManager.put("FileChooser.detailsViewButtonToolTipText", Text.get("FC_TABLE"));
        UIManager.put("FileChooser.fileNameHeaderText", Text.get("FC_NAME"));
        UIManager.put("FileChooser.fileSizeHeaderText", Text.get("FC_SIZE"));
        UIManager.put("FileChooser.fileTypeHeaderText", Text.get("FC_TYPE"));
        UIManager.put("FileChooser.fileDateHeaderText", Text.get("FC_DATE"));
        UIManager.put("FileChooser.fileAttrHeaderText", Text.get("FC_ATTR"));
        
        UIManager.put("FileChooser.acceptAllFileFilterText", Text.get("FC_ALL_FILTER"));
        
        updateUI();
        
    }
    
    public int open() {
        return super.showOpenDialog(frame);
    }
    
    public int save() {
        return super.showSaveDialog(frame);
    }
    
}
