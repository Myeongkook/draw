package dto;

public class ShortDto {

    private final String clientId;
    private final String clientSecret;

    public ShortDto(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }
}
