package dto;

public class DbDto {

    private final String url;
    private final String user;
    private final String pw;

    public DbDto(String url, String user, String pw) {
        this.url = url;
        this.user = user;
        this.pw = pw;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPw() {
        return pw;
    }
}
