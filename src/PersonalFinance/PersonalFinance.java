package PersonalFinance;

import settings.Text;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonalFinance {
    public static void main(String[] args) {
        init();
        System.out.println(Text.get("PROGRAM_NAME"));
        System.out.println(Arrays.toString(Text.getMonths()));
    }
    private static void init() {
        try {
            Text.init();
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("fonts/Roboto-Light.ttf")));
        } catch (FontFormatException | IOException e) {
            Logger.getLogger(PersonalFinance.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
