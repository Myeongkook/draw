import dto.DrawDto;
import service.Repository;
import service.SendAPI;
import service.ShortAPI;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RunApplication {
    public static void main(String[] args) throws SQLException, FileNotFoundException {
        List<DrawDto> draws = Repository.findDraws();
        if(draws.size()>0){
            List<String> users = Repository.findUsers();
            for (DrawDto draw : draws) {
                String content = "The Draw\n" + draw.getProduct() + "\n" + draw.getDate() + "\n" +ShortAPI.getShortUrl(draw.getUrl());
                SendAPI.sendSMS(users,content);
                Repository.updateDraw(draw.getUrl());
            }
        }
    }
}
