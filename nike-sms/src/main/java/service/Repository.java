package service;

import dto.DbDto;
import dto.DrawDto;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Repository {

    public static List<String> findUsers() throws SQLException, FileNotFoundException {
        ResultSet rs;
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        rs = stmt.executeQuery("select * from member where is_subscribed = TRUE");
        List<String> users = new ArrayList<>();
        while (rs.next()) {
            String phone = rs.getString(5);
            users.add(phone);
        }
        stmt.close();
        conn.close();
        return users;
    }

    private static Connection getConnection() throws FileNotFoundException, SQLException {
        DbDto db = (DbDto) YamlReader.getObject("DB");
        Connection conn = DriverManager.getConnection(db.getUrl(), db.getUser(), db.getPw());
        return conn;
    }

    public static List<DrawDto> findDraws() throws SQLException, FileNotFoundException{
        ResultSet rs;
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
//        rs = stmt.executeQuery("select * from draw where is_sent = False and date BETWEEN NOW() and NOW() + INTERVAL 5 MINUTE");
        rs = stmt.executeQuery("select * from draw where is_sent = False and date >= NOW()");
        List<DrawDto> result = new ArrayList<>();
        while (rs.next()){
            String url = rs.getString("url");
            String date = rs.getString("date");
            String product = rs.getString("product");
            result.add(new DrawDto(product,date,url));
        }
        stmt.close();
        conn.close();
        return result;
    }

    public static void updateDraw(String url) throws SQLException, FileNotFoundException{
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("update draw set is_sent=TRUE where url=?");
        pstmt.setString(1,url);
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();

    }

    public static void insertCrontabLog() throws SQLException, FileNotFoundException {
        Connection conn = getConnection();
        PreparedStatement pstmt = conn.prepareStatement("insert into crontab_log (runtime_timestamp) VALUES (NOW())");
        pstmt.executeUpdate();
        pstmt.close();
        conn.close();
    }
}
