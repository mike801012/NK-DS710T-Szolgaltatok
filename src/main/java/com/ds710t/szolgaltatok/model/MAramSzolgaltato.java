package com.ds710t.szolgaltatok.model;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class MAramSzolgaltato {

    /**
     * Az áram szolgáltatókhoz tartozó egyedi azonosító, elsődleges kulcs.
     */
    private int id = 0;
    /**
     * A kereskedő ill. szolgáltató szöveges megnevezése.
     */
    private String megnevezes;
    /**
     * A kereskedő ill. szolgáltató rövidített szöveges megnevezése.
     */
    private String megnevezes_rovid;
    /**
     * A kereskedő ill. szolgáltató székhelyének címe.
     */
    private String cim;
    /**
     * Link az online ügyfélszolgálatra.
     */
    private String uf_online;
    /**
     * Offline ügyfélszolgálati elérhetőség(ek)).
     */
    private String uf;
    /**
     * A kereskedő ill. szolgáltatóhoz kapcsolódó, bővebb szöveges leírás.
     */
    private String leiras;
    /**
     * A kereskedő ill. szolgáltató weboldalára mutató link.
     */
    private String link;
    /**
     * A kereskedő ill. szolgáltató szerveren tárolt logóképének url címe.
     */
    private String kep;
    /**
     * A kereskedő kapcsolattartójának e-mail címe
     */
    private String kapcsolattarto_mail;
    /**
     * A rekord aktív-inaktív állapotának jelzésére szolgáló kétállapotú jelző.
     * Értéke 0 vagy 1.
     */
    private int torolt;

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return megnevezes
     */
    public String getMegnevezes() {
        return megnevezes;
    }

    /**
     *
     * @param megnevezes
     */
    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    /**
     *
     * @return megnevezes_rovid
     */
    public String getMegnevezes_rovid() {
        return megnevezes_rovid;
    }

    /**
     *
     * @param megnevezes_rovid
     */
    public void setMegnevezes_rovid(String megnevezes_rovid) {
        this.megnevezes_rovid = megnevezes_rovid;
    }

    /**
     *
     * @return cim
     */
    public String getCim() {
        return cim;
    }

    /**
     *
     * @param cim
     */
    public void setCim(String cim) {
        this.cim = cim;
    }

    /**
     *
     * @return uf_online
     */
    public String getUf_online() {
        return uf_online;
    }

    /**
     *
     * @param uf_online
     */
    public void setUf_online(String uf_online) {
        this.uf_online = uf_online;
    }

    /**
     *
     * @return uf
     */
    public String getUf() {
        return uf;
    }

    /**
     *
     * @param uf
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     *
     * @return leiras
     */
    public String getLeiras() {
        return leiras;
    }

    /**
     *
     * @param leiras
     */
    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    /**
     *
     * @return link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     */
    public void setLink(String link) {
        this.link = link;
    }

    /**
     *
     * @return kep
     */
    public String getKep() {
        return kep;
    }

    /**
     *
     * @param kep
     */
    public void setKep(String kep) {
        this.kep = kep;
    }

    /**
     *
     * @return kapcsolattarto_mail
     */
    public String getKapcsolattarto_mail() {
        return kapcsolattarto_mail;
    }

    /**
     *
     * @param kapcsolattarto_mail
     */
    public void setKapcsolattarto_mail(String kapcsolattarto_mail) {
        this.kapcsolattarto_mail = kapcsolattarto_mail;
    }

    /**
     *
     * @return torolt
     */
    public int getTorolt() {
        return torolt;
    }

    /**
     *
     * @param torolt
     */
    public void setTorolt(int torolt) {
        this.torolt = torolt;
    }
}
