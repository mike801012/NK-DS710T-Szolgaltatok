package com.ds710t.szolgaltatok.view;

import com.ds710t.szolgaltatok.GlobalisV;
import com.ds710t.szolgaltatok.controller.CAramSzolgaltatok;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class WAramSzolgaltatokMain extends JFrame {

    private WAramSzolgaltatokNew NewAblak;
    private WAramSzolgaltatokTable T;
    private JScrollPane scrollPane;
    private JPanel mainPanel;

    /**
     * Init
     */
    public WAramSzolgaltatokMain() {


        initUI();

    }

    private void initUI() {

        JMenuBar menubar = new JMenuBar();


        JMenu file = new JMenu("Főmenü");
        file.setMnemonic(KeyEvent.VK_F); //ALT+F

        //ImageIcon icon = new ImageIcon("exit.png");
        Icon newicon = UIManager.getIcon("Tree.leafIcon");
        JMenuItem fileNew = new JMenuItem("Új", newicon);
        fileNew.setMnemonic(KeyEvent.VK_N);
        fileNew.setToolTipText("Új rekord hozzáadása");

        //Bármikor nyomható shortcut
        fileNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                ActionEvent.CTRL_MASK));

        fileNew.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        NewAblak = new WAramSzolgaltatokNew();
                        NewAblak.setVisible(true);
                        NewAblak.setDefaultCloseOperation(
                                javax.swing.WindowConstants.HIDE_ON_CLOSE);
                    }
                });
            }
        });




        JMenuItem fileExit = new JMenuItem("Kilépés");
        //setMnemonic: csak akkor reagál, ha látszik a menü
        fileExit.setMnemonic(KeyEvent.VK_E);

        //Bármikor nyomható shortcut
        fileExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,
                ActionEvent.CTRL_MASK));

        fileExit.setToolTipText("Kilépek a programból!");
        fileExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        file.add(fileNew);

        file.addSeparator();
        file.add(fileExit); //Kilépés menüpont hozzáadása File főmenühöz

        menubar.add(file); //Főmenü hozzáadása menübarhoz

        JMenu helpmenu = new JMenu("Súgó");
        menubar.add(Box.createHorizontalGlue());

        JMenuItem about = new JMenuItem("About");

        about.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                java.awt.EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        About ab = new About();
                        ab.setVisible(true);
                        ab.setDefaultCloseOperation(
                                javax.swing.WindowConstants.HIDE_ON_CLOSE);
                    }
                });
            }
        });

        helpmenu.add(about);
        menubar.add(helpmenu);//About hozzáadása menübarhoz, jobbra

        setJMenuBar(menubar); //Menübar hozzáadása az ablakhoz



        JToolBar toolbar = new JToolBar();
        ImageIcon toolbar_new = new ImageIcon(ClassLoader.getSystemResource(
                "toolbar_new.png"));


        JButton toolbarnewButton = new JButton(toolbar_new);

        toolbarnewButton.setOpaque(false);
        toolbarnewButton.setContentAreaFilled(false);
        toolbarnewButton.setBorderPainted(false);
        toolbarnewButton.setToolTipText("Új elem");

        toolbar.add(toolbarnewButton);

        toolbarnewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                NewAblak = new WAramSzolgaltatokNew();
                NewAblak.setVisible(true);
                NewAblak.setDefaultCloseOperation(
                        javax.swing.WindowConstants.HIDE_ON_CLOSE);
            }
        });



        add(toolbar, BorderLayout.NORTH);

        //ADATOK BEGYŰJTÉSE
        CAramSzolgaltatok c = new CAramSzolgaltatok();
        //XML vagy MYSQL?
        //data = controller.getAdat();
        GlobalisV.data_global = c.getAdatXML();

        //Táblázat generálása
        T = new WAramSzolgaltatokTable();
        JTable table = T.generateTable();

        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1, 0));

        GlobalisV.scrollpane_global = new JScrollPane(table);
        mainPanel.add(GlobalisV.scrollpane_global);


        this.getContentPane().add(mainPanel);


        //ablak beállítása
        setTitle("Áramszolgálatók és kereskedők - Pál Miklós NK-DS710T");
        setSize(1024, 768);
        setLocationRelativeTo(null);
    }
}
