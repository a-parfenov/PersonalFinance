package personalfinance.gui;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import personalfinance.gui.menu.MainMenu;
import personalfinance.settings.Style;
import personalfinance.settings.Text;

public final class MainFrame extends JFrame implements Refresh {
    
    private final GridBagConstraints constraints;
    private final MainMenu mb;
   // private final LeftPanel leftPanel;
   // private RightPanel rightPanel;
   // private final MainToolBar tb;
    
    public MainFrame() {
        super(Text.get("PROGRAM_NAME"));
        
        setResizable(false);
        setIconImage(Style.ICON_MAIN.getImage());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        
        mb = new MainMenu(this);
        setJMenuBar(mb);
        
        setLayout(new GridBagLayout());
        
        constraints = new GridBagConstraints();
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        

        
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.anchor = GridBagConstraints.NORTH;

        
        pack();
        setLocationRelativeTo(null);

    }

    @Override
    public void refresh() {
        SwingUtilities.updateComponentTreeUI(this);
        pack();
    }

    public MainMenu getMenu() {
        return mb;
    }


}
