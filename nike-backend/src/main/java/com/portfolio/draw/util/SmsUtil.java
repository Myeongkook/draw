package com.portfolio.draw.util;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.List;
import java.util.Random;

@Component
public class SmsUtil {

    private String serviceId;
    private String accessKey;
    private String secretKey;

    public SmsUtil(@Value("${SMS.serviceID}") String serviceId, @Value("${SMS.accessKeyID}") String accessKey, @Value("${SMS.secretKey}") String secretKey) {
        this.serviceId = serviceId;
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    private String makeSignature(String url, String timestamp, String method,  String accessKey, String secretKey) throws NoSuchAlgorithmException, InvalidKeyException {
        String space = " ";
        String newLine = "\n";
        String message = new StringBuilder()
                .append(method)
                .append(space)
                .append(url)
                .append(newLine)
                .append(timestamp)
                .append(newLine)
                .append(accessKey)
                .toString();

        SecretKeySpec signingKey;
        String encodeBase64String;

        signingKey = new SecretKeySpec(secretKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256");
        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(signingKey);
        byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));
        encodeBase64String = Base64.getEncoder().encodeToString(rawHmac);
        return encodeBase64String;
    }

    public int sendSMS(List<String> users, String content){
        String hostNameUrl = "https://sens.apigw.ntruss.com";     		// ????????? URL
        String requestUrl= "/sms/v2/services/";                   		// ?????? URL
        String requestUrlType = "/messages";                  		// ?????? URL
        String method = "POST";											// ?????? method
        String timestamp = Long.toString(System.currentTimeMillis()); 	// current timestamp (epoch)
        requestUrl += serviceId + requestUrlType;
        String apiUrl = hostNameUrl + requestUrl;

        // JSON ??? ????????? body data ??????
        JSONObject bodyJson = new JSONObject();
        JSONArray toArr = new JSONArray();
        for (String user : users) {
            toArr.put(new JSONObject().put("to", user));
        }


        bodyJson.put("type","SMS");     					// Madantory, ????????? Type (SMS | LMS | MMS), (????????? ??????)	        // Optional, ?????? ????????????, (default: 82)
        bodyJson.put("content", content);	                // Mandatory(??????), ?????? ????????? ??????, SMS: ?????? 80byte, LMS, MMS: ?????? 2000byte
        bodyJson.put("messages", toArr);					// Mandatory(??????), ?????? ????????? ?????? (messages.XXX), ?????? 1,000???
        bodyJson.put("from", "01084898972");
        String body = bodyJson.toString();


        try {
            URL url = new URL(apiUrl);

            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setUseCaches(false);
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setRequestProperty("content-type", "application/json");
            con.setRequestProperty("x-ncp-apigw-timestamp", timestamp);
            con.setRequestProperty("x-ncp-iam-access-key", accessKey);
            con.setRequestProperty("x-ncp-apigw-signature-v2", makeSignature(requestUrl, timestamp, method, accessKey, secretKey));
            con.setRequestMethod(method);
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());

            wr.write(body.getBytes());
            wr.flush();
            wr.close();

            return con.getResponseCode();

        } catch (Exception e) {
            System.out.println(e);
            return 400;
        }
    }



}