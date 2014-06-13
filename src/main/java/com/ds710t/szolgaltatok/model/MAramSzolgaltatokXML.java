package com.ds710t.szolgaltatok.model;

import com.sun.org.apache.xerces.internal.parsers.DOMParser;
import java.io.IOException;
import java.util.ArrayList;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class MAramSzolgaltatokXML {

    /**
     * Ebben a listában tároljuk a beolvasott adatokat.
     */
    private ArrayList<MAramSzolgaltato> selectData;
    /**
     * Naplózás.
     */
    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(
            MAramSzolgaltatokXML.class);
    /**
     * XML beolvasó funkciókat tartalmazó osztály.
     */
    private XMLFunctions xmlfunctions;
    /**
     * Egy rekord tárolását valósítja meg.
     */
    private MAramSzolgaltato item;

    /**
     * Konstruktor.
     */
    public MAramSzolgaltatokXML() {
    }

    /**
     * Eljárás, amely bejárja az aram_szolgaltatok.xml fájlt.
     *
     * Ciklussal bejárja az XML fájlt:
     *
     * {@code
     *  for (int i = 0; i < nodeListSzolgaltato.getLength(); i++)
     * }
     *
     * @return selectData
     */
    public ArrayList<MAramSzolgaltato> SelectAll() {


        try {

            DOMParser parser = new DOMParser();
            xmlfunctions = new XMLFunctions();

            String fileName = Thread.currentThread().getContextClassLoader().
                    getResource("aram_szolgaltatok.xml").getFile();
            parser.parse(fileName);

            Document doc = parser.getDocument();

            NodeList nodeListSzolgaltato = doc.getElementsByTagName(
                    "szolgaltato");

            selectData = new ArrayList<>();

            for (int i = 0; i < nodeListSzolgaltato.getLength(); i++) {
                Node node = nodeListSzolgaltato.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    item = new MAramSzolgaltato();
                    Element element = (Element) node;

                    //ID
                    item.setId(Integer.parseInt(xmlfunctions.
                            getNV("id", element)));

                    //Megnevezés
                    item.setMegnevezes(xmlfunctions.
                            getNV("megnevezes", element));

                    //Megnevezés, rövid
                    item.setMegnevezes_rovid(xmlfunctions.
                            getNV("megnevezes_rovid", element));

                    //Cím
                    item.setCim(xmlfunctions.
                            getNV("cim", element));

                    //Uf online
                    item.setUf_online(xmlfunctions.
                            getNV("uf_online", element));
                    //Uf
                    item.setUf(xmlfunctions.
                            getNV("uf", element));
                    //Leiras
                    item.setLeiras(xmlfunctions.
                            getNV("leiras", element));
                    //Link
                    item.setLink(xmlfunctions.
                            getNV("link", element));
                    //Kapcsolattartó mail
                    item.setKapcsolattarto_mail(xmlfunctions.
                            getNV("kapcsolattarto_mail", element));
                    //Törölt
                    item.setTorolt(Integer.parseInt(xmlfunctions.
                            getNV("torolt", element)));

                    selectData.add(item);

                }

            }


        } catch (SAXException | IOException ex) {
            LOGGER.error("Hiba", ex);
        }

        return selectData;
    }
}
