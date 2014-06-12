package com.ds710t.szolgaltatok.view;

import com.ds710t.szolgaltatok.GlobalisV;
import com.ds710t.szolgaltatok.controller.CAramSzolgaltatok;
import com.ds710t.szolgaltatok.model.MAramSzolgaltato;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class WAramSzolgaltatokTable {

    private Vector colNames;
    private JTable table;
    private DefaultTableModel tableModel;
    private MAramSzolgaltato[] data;
    private WUtils wutils;
    private int row;
    private int col;
    private WAramSzolgaltatokMod ModAblak;
    private Desktop d;
    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(
            WAramSzolgaltatokTable.class);

    /**
     * Konstruktor
     */
    public WAramSzolgaltatokTable() {
    }

    /**
     *
     * @return table
     */
    public JTable generateTable() {

        wutils = new WUtils();

        colNames = new Vector();
        colNames.add("ID");
        colNames.add("");
        colNames.add("");
        colNames.add("Megnevezés");
        colNames.add("Rövid)");
        colNames.add("Cím");
        colNames.add("Ügyfélszolgálat (online)");
        colNames.add("Ügyfélszolgálat");
        colNames.add("Web");
        colNames.add("E-mail");


        tableModel = new DefaultTableModel(colNames, 0);

        table = new JTable(tableModel) {
            @Override
            public boolean isCellEditable(int rowIndex, int vColIndex) {
                return false;
            }

            @Override
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };

        table.setRowHeight(20);

        //Tömböt csinálok az arraylistből
        data = GlobalisV.data_global.toArray(
                new MAramSzolgaltato[GlobalisV.data_global.size()]);

        for (int i =
                0; i < data.length; i++) {

            ImageIcon mIcon = new ImageIcon(ClassLoader.getSystemResource(
                    "edit.gif"));

            ImageIcon dIcon = new ImageIcon(ClassLoader.getSystemResource(
                    "delete.gif"));

            Object[] _row = {String.format("%03d", data[i].getId()), mIcon,
                dIcon, data[i].getMegnevezes(), data[i].getMegnevezes_rovid(),
                data[i].getCim(), data[i].getUf_online(), data[i].getUf(),
                data[i].getLink(), data[i].getKapcsolattarto_mail()};

            tableModel.addRow(_row);

        }

        LOGGER.info("Táblázat kirajzolva!");

        //Klikkelések figyelése
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            @SuppressWarnings("empty-statement")
            public void mouseClicked(java.awt.event.MouseEvent e) {
                row = table.rowAtPoint(e.getPoint());

                col = table.columnAtPoint(e.getPoint());

                if (col == 1) {
                    System.out.println("ID :" + " " + Integer.parseInt(
                            (String) table.getValueAt(row, 0)));
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            ModAblak = new WAramSzolgaltatokMod(Integer.
                                    parseInt((String) table.getValueAt(row, 0)));
                            ModAblak.setVisible(true);
                            ModAblak.setDefaultCloseOperation(
                                    javax.swing.WindowConstants.HIDE_ON_CLOSE);
                        }
                    });
                }

                if (col == 2) {

                    java.awt.EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                            CAramSzolgaltatok c = new CAramSzolgaltatok();
                            c.deleteAdat(Integer.
                                    parseInt((String) table.getValueAt(row, 0)));


                        }
                    });
                }

                if (col == 6) {
                    d = Desktop.getDesktop();
                    try {
                        try {

                            d.browse(new URI((String) table.getValueAt(row, 6)));

                        } catch (URISyntaxException ex) {
                            Logger.getLogger(WAramSzolgaltatokTable.class.
                                    getName()).log(Level.SEVERE, null, ex);
                            LOGGER.error("URI Syntax hiba!");
                        }
                    } catch (IOException ex) {
                        Logger.getLogger(WAramSzolgaltatokTable.class.getName()).
                                log(Level.SEVERE, null, ex);
                        LOGGER.error("IO hiba!");
                    }
                }
            }
        });


        return wutils.autoResizeColWidth(table, tableModel);

    }
}
