package service;


import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class YamlReader {

    public static void main(String[] args) throws FileNotFoundException {
        Yaml y = new Yaml();
        FileReader file = new FileReader("/Users/myeongkook/Documents/DEV/nike/nike-sms/src/resource/properties.yaml");
        Map<String,Object> result = y.load(file);
        Map<String, Object> shortURL = (Map<String, Object>) result.get("shortURL");
        String ID = (String) shortURL.get("ClientID");
        String secert = (String) shortURL.get("ClientSecret");
        System.out.println(ID + " " + secert);
    }
}
