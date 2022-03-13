package service;


import dto.DbDto;
import dto.ShortDto;
import dto.SmsDto;
import org.yaml.snakeyaml.Yaml;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class YamlReader {

    public static Object getObject(String objectKey) throws FileNotFoundException{
        Map<String, Object> load = new Yaml().load(new FileReader("/Users/myeongkook/Documents/DEV/draw/nike-sms/src/main/resources/config.yaml"));
        Map<String, String> result = (Map<String, String>) load.get(objectKey);
        switch (objectKey) {
            case "SMS":
                return new SmsDto(result.get("serviceID"), result.get("accessKeyID"), result.get("secretKey"));
            case "DB":
                return new DbDto(result.get("URL"), result.get("user"), result.get("pw"));
            case "shortURL":
                return new ShortDto(result.get("clientID"), result.get("clientSecret"));
            default:
                throw new IllegalArgumentException();
        }
    }

}
