package dto;

public class SmsDto {

    private final String serviceid;
    private final String accessKeyId;
    private final String secretKey;

    public SmsDto(String serviceid, String accessKeyId, String secretKey) {
        this.serviceid = serviceid;
        this.accessKeyId = accessKeyId;
        this.secretKey = secretKey;
    }

    public String getServiceid() {
        return serviceid;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getSecretKey() {
        return secretKey;
    }
}
