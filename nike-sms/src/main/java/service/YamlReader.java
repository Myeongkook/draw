package service;


import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class YamlReader {

    public static void main(String[] args) throws FileNotFoundException {
        Yaml y = new Yaml();
        FileReader file = new FileReader("C:\\Users\\Myeongkook Park\\Desktop\\draw\\nike-sms\\src\\main\\resources\\config.yaml");
        Map<String,Object> result = y.load(file);
        Map<String, Object> shortURL = (Map<String, Object>) result.get("shortURL");
        String ID = (String) shortURL.get("ID");
        String secret = (String) shortURL.get("PW");
        System.out.println(ID + " " + secret);
    }
}
