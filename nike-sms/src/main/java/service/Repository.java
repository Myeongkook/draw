package service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {
    public final static String URL = "";
    public final static String USER = "";
    public final static String PW = "";

    public static void main(String[] args) throws SQLException {
        ResultSet rs;
        Connection conn = DriverManager.getConnection(URL, USER, PW);
        System.out.println(conn);
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from user where is_subscribed = TRUE");
        List<String> users = new ArrayList<>();
        while (rs.next()){
            String phone = rs.getString(7);
            users.add(phone);
        }
        for (String user : users) {
            System.out.println(user);
        }
    }
}
