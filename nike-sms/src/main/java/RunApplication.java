import com.mysql.cj.xdevapi.JsonParser;
import dto.DbDto;
import org.json.JSONObject;
import service.Repository;
import service.SendAPI;
import service.ShortAPI;
import service.YamlReader;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RunApplication {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        List<String> users = Repository.findUsers();
        String shortUrl = ShortAPI.getShortUrl("nike.com/kr/launch/t/women/fw/nike-sportswear/DQ9324-600/attx41/wmns-nike-dunk-low");
        JSONObject json = new JSONObject(shortUrl);
        //SendAPI.sendSMS(users,"대량 발송 테스트 문자\n");
        Map<String, String>result = (Map<String, String>) json.get("result");
        String url = result.get("url");
        System.out.println(url);
    }
}
