package com.avery.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getConnection() throws Exception {
        Connection conn = null;

        try {
            Class.forName(PropertyUtil.getProperty("jdbc.driver"));
            String url = PropertyUtil.getProperty("jdbc.url");
            conn = DriverManager.getConnection(url, PropertyUtil.getProperty("jdbc.user"), PropertyUtil.getProperty("jdbc.password"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new Exception();
        }

        return conn;
    }

    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
             if (rs != null) {
                 rs.close();
                 rs = null;
             }

             if (stmt != null) {
                 stmt.close();
                 stmt = null;
             }

             if (conn != null) {
                 conn.close();
                 conn = null;
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
}
