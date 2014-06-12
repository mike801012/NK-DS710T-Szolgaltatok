package com.ds710t.szolgaltatok;

import com.ds710t.szolgaltatok.view.WAramSzolgaltatokMain;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class Szolgaltatok {

    /*Naplózás*/
    static final org.slf4j.Logger LOGGER =
            LoggerFactory.getLogger(Szolgaltatok.class);

    /**
     * @param args the command line arguments
     * @throws UnsupportedLookAndFeelException
     */
    public static void main(String[] args)
            throws UnsupportedLookAndFeelException {

        try {
            UIManager.setLookAndFeel(
                    "javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException ex) {
            Logger.getLogger(Szolgaltatok.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        /**
         * Megnyitjuk a főablakot
         */
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                GlobalisV.wm = new WAramSzolgaltatokMain();
                GlobalisV.wm.setVisible(true);
                LOGGER.info("Áramszolgáltatók ablak megnyitva");
            }
        });

    }
}
