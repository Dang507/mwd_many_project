package projects.TA_web.entity;

public class CouponType {
    private String name;
    private String limit;
    private String status;
    private String imageLink;

    public CouponType(String name, String limit, String status) {
        this.name = name;
        this.limit = limit;
        this.status = status;
    }

    public CouponType(String name, String limit, String status, String imageLink){
        this.name = name;
        this.limit = limit;
        this.status = status;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
