package service;

import dto.DbDto;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<String> findUsers() throws SQLException, FileNotFoundException {
        DbDto db = (DbDto) YamlReader.getObject("DB");
        ResultSet rs;
        Connection conn = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPw());
        System.out.println(conn);
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from user where is_subscribed = TRUE");
        List<String> users = new ArrayList<>();
        while (rs.next()) {
            String phone = rs.getString(7);
            users.add(phone);
        }
        return users;
    }
}
