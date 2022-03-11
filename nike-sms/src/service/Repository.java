package service;

import java.sql.*;

public class Repository {
    static String URL = "";
    static String USER = "";
    static String PW = "";

    public static void main(String[] args) throws SQLException {
        ResultSet rs;
        Connection conn = DriverManager.getConnection(URL, USER, PW);
        System.out.println(conn);
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from draw");
        while (rs.next()){
            String one = rs.getString(1);
            String two = rs.getString(2);
            String three = rs.getString(3);

            System.out.println(one + " " + two + " " + three);
        }
    }
}
