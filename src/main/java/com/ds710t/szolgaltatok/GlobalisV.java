package com.ds710t.szolgaltatok;

import com.ds710t.szolgaltatok.model.MAramSzolgaltato;
import com.ds710t.szolgaltatok.view.WAramSzolgaltatokMain;
import java.util.ArrayList;
import javax.swing.JScrollPane;

/**
 * Globális változók.
 *
 * @author Pál Miklós NK-DS710T
 */
public class GlobalisV {

    /**
     * Lekérdezés után itt tárolódik az adat.
     */
    public static ArrayList<MAramSzolgaltato> data_global;
    /**
     * Kirajzolás után itt tárolódik az tábla.
     */
    public static JScrollPane scrollpane_global;
    /**
     * Főablak.
     */
    public static WAramSzolgaltatokMain wm;
}
