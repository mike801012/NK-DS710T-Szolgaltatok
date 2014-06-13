package com.ds710t.szolgaltatok.model;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class XMLFunctions {

    /**
     * XML file beolvasását megvalósító osztály.
     */
    public XMLFunctions() {
    }

    /**
     *
     * @param tagName tag neve
     * @param element elem
     * @return getNodeValue(tagName, nodelist)
     */
    public String getNV(String tagName, Element element) {
        NodeList nodelist = element.getElementsByTagName(tagName);
        return getNodeValue(tagName, nodelist);
    }

    /**
     *
     * @param tagName tag neve
     * @param nodes node-ok listája
     * @return a node aktuális értékét adja vissza
     */
    private String getNodeValue(String tagName, NodeList nodes) {
        for (int x = 0; x < nodes.getLength(); x++) {
            Node node = nodes.item(x);
            if (node.getNodeName().equalsIgnoreCase(tagName)) {
                NodeList childNodes = node.getChildNodes();
                for (int y = 0; y < childNodes.getLength(); y++) {
                    Node data = childNodes.item(y);
                    if (data.getNodeType() == Node.TEXT_NODE) {
                        return data.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
}
