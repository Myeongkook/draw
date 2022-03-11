package service;

import java.sql.*;

public class Repository {
    static String URL = "jdbc:mysql://15.164.131.180:3306/nike";
    static String USER = "manager";
    static String PW = "qweqwe1";

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
            String four = rs.getString(4);

            System.out.println(one + " " + two + " " + three + " " + four);
        }
    }
}
