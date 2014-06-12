package com.ds710t.szolgaltatok.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class MAramSzolgaltatok {

    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private MySQLConnect c = null;
    private ArrayList<MAramSzolgaltato> selectData = null;
    static final org.slf4j.Logger LOGGER = LoggerFactory.getLogger(
            MAramSzolgaltatok.class);

    /**
     * Konstruktor
     */
    public MAramSzolgaltatok() {
    }

    /**
     *
     * @return MAramSzolgaltato[]
     * @throws SQLException
     * @throws SQLException
     * @throws SQLException, Exception
     */
    public ArrayList<MAramSzolgaltato> SelectAll() throws SQLException,
            Exception {
        try {

            c = new MySQLConnect();
            connect = c.conn();

            LOGGER.info("Csatlakozva az adatbázishoz.");

            preparedStatement = connect.prepareStatement(""
                    + "SELECT * FROM TARIFAKALAUZ.aram_szolgaltatok");

            resultSet = preparedStatement.executeQuery();

            selectData = new ArrayList<>();


            while (resultSet.next()) {

                MAramSzolgaltato item = new MAramSzolgaltato();

                item.setId(resultSet.getInt("id"));
                item.setMegnevezes(resultSet.getString("megnevezes"));
                item.setMegnevezes_rovid(resultSet.
                        getString("megnevezes_rovid"));
                item.setCim(resultSet.getString("cim"));
                item.setUf_online(resultSet.getString("uf_online"));
                item.setUf(resultSet.getString("uf"));
                item.setLeiras(resultSet.getString("leiras"));
                item.setLink(resultSet.getString("link"));
                item.setKep(resultSet.getString("kep"));
                item.setKapcsolattarto_mail(resultSet.
                        getString("kapcsolattarto_mail"));
                item.setTorolt(resultSet.getInt("torolt"));

                selectData.add(item);

            }
            LOGGER.info("Adatok begyűjtve.");
            return selectData;

        } catch (SQLException e) {
            throw e;
        } finally {
            close(connect, preparedStatement, resultSet);
        }

    }

    /**
     *
     * @param connect
     * @param preparedStatement
     * @param resultSet
     */
    public void close(Connection connect, PreparedStatement preparedStatement,
            ResultSet resultSet) {
        if (connect != null) {
            try {
                connect.close();
                LOGGER.info("Adatbázis kapcsolat lezárva.");
            } catch (Exception e) { /* ignore close errors */ }
        }

        if (preparedStatement != null) {
            try {
                preparedStatement.close();
                LOGGER.info("PreparedStatement kilőve.");
            } catch (Exception e) { /* ignore close errors */ }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
                LOGGER.info("ResultSet kilőve.");
            } catch (Exception e) { /* ignore close errors */ }
        }
    }
}
