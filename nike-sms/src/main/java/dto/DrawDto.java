package dto;

public class DrawDto {

    private final String product;
    private final String date;
    private final String url;

    public DrawDto(String product, String date, String url) {
        this.product = product;
        this.date = date;
        this.url = url;
    }

    public String getProduct() {
        return product;
    }

    public String getDate() {
        return date;
    }

    public String getUrl() {
        return url;
    }
}
