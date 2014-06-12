package com.ds710t.szolgaltatok.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pál Miklós NK-DS710T
 */
public class MySQLConnect {

    private Connection connect = null;
    private String sqlusername = "tarifakalauz";
    private String sqluserpw = "tarifakalauz";

    /**
     *
     * @return Connection
     * @throws Exception
     */
    public Connection conn() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            connect = DriverManager.getConnection(
                    "jdbc:mysql://localhost/learnjava?user=" + sqlusername
                    + "&password=" + sqluserpw);


        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }

        return connect;

    }
}
