package com.ds710t.szolgaltatok.controller;

import com.ds710t.szolgaltatok.GlobalisV;
import com.ds710t.szolgaltatok.model.MAramSzolgaltato;
import com.ds710t.szolgaltatok.model.MAramSzolgaltatok;
import com.ds710t.szolgaltatok.model.MAramSzolgaltatokXML;
import com.ds710t.szolgaltatok.view.WAramSzolgaltatokTable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class CAramSzolgaltatok {

    /**
     * MAramSzolgaltato[].
     */
    private ArrayList<MAramSzolgaltato> a;
    /**
     * MAramSzolgaltatok.
     */
    private MAramSzolgaltatok am;
    private MAramSzolgaltatokXML amxml;
    /**
     * Naplózás.
     */
    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(
            CAramSzolgaltatok.class);

    /**
     * Konstruktor.
     */
    public CAramSzolgaltatok() {
    }

    /**
     * Összes adat lekérdezése a táblához (XML fájlból).
     *
     * @return amxml.SelectAll()
     */
    public final ArrayList<MAramSzolgaltato> getAdatXML() {

        amxml = new MAramSzolgaltatokXML();
        LOGGER.info("XML beolvasás elindítva.");
        return amxml.SelectAll();
    }

    /**
     * Összes adat lekérdezése a táblához (MYSQL LOCALHOST).
     *
     * @return a
     */
    public final ArrayList<MAramSzolgaltato> getAdat() {
        try {
            am = new MAramSzolgaltatok();
            LOGGER.info("SQL kérés elindítva.");
            a = am.SelectAll();

        } catch (SQLException ex) {
            Logger.getLogger(CAramSzolgaltatok.class.getName()).
                    log(Level.SEVERE, null, ex);
            LOGGER.error("SQL hiba!");
        } catch (Exception ex) {
            Logger.getLogger(CAramSzolgaltatok.class.getName()).
                    log(Level.SEVERE, null, ex);
            LOGGER.info("Hiba!");
        }

        return a;
    }

    /**
     * Egy rekord hozzáadása.
     *
     * @param p
     */
    public void insertAdat(final MAramSzolgaltato p) {
        GlobalisV.data_global.add(p);
        reDrawTable();
    }

    /**
     * Egy rekord módosítása.
     *
     * @param p, id
     */
    public void updateAdat(final MAramSzolgaltato p, int id) {
        for (int i = 0; i < GlobalisV.data_global.size(); i++) {
            if (GlobalisV.data_global.get(i).getId() == id) {
                GlobalisV.data_global.get(i).setMegnevezes(p.getMegnevezes());
                GlobalisV.data_global.get(i).setMegnevezes_rovid(p.
                        getMegnevezes_rovid());
                GlobalisV.data_global.get(i).setCim(p.getCim());
                GlobalisV.data_global.get(i).setUf(p.getUf());
                GlobalisV.data_global.get(i).setUf_online(p.getUf_online());
                GlobalisV.data_global.get(i).setLink(p.getLink());
                GlobalisV.data_global.get(i).setKapcsolattarto_mail(p.
                        getKapcsolattarto_mail());
                GlobalisV.data_global.get(i).setLeiras(p.getLeiras());

            }
        }
        reDrawTable();
    }

    /**
     * Egy rekord törlése.
     *
     * @param id
     */
    public void deleteAdat(int id) {
        for (int i = 0; i < GlobalisV.data_global.size(); i++) {
            if (GlobalisV.data_global.get(i).getId() == id) {
                GlobalisV.data_global.remove(i);
            }
        }
        reDrawTable();
    }

    private void reDrawTable() {
        //Táblázat generálása
        WAramSzolgaltatokTable T = new WAramSzolgaltatokTable();
        GlobalisV.scrollpane_global.getViewport().remove(0);
        GlobalisV.scrollpane_global.getViewport().add(T.generateTable());
    }
}
