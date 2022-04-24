package projects.TA_web.entity;

public class Coupon{
    private String Duration;
    private String Name;
    private String Point;
    private String Value;
    private String Status;
    private String UnitName;
    private String UnitNameTimes;
    private String CuoponType;

    public Coupon(String status, String unitName, String unitNameTimes, String cuoponType) {
        Status = status;
        UnitName = unitName;
        UnitNameTimes = unitNameTimes;
        CuoponType = cuoponType;
    }

    public String getCuoponType() {
        return CuoponType;
    }

    public void setCuoponType(String cuoponType) {
        CuoponType = cuoponType;
    }

    public String getDuration() {
        return Duration;
    }

    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String point) {
        Point = point;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getUnitName() {
        return UnitName;
    }

    public void setUnitName(String unitName) {
        UnitName = unitName;
    }

    public String getUnitNameTimes() {
        return UnitNameTimes;
    }

    public void setUnitNameTimes(String unitNameTimes) {
        UnitNameTimes = unitNameTimes;
    }

    public Coupon(String duration, String name, String point, String value, String status,
                  String unitName, String unitNameTimes,String CouponType ) {
        Duration = duration;
        Name = name;
        Point = point;
        Value = value;
        Status = status;
        UnitName = unitName;
        UnitNameTimes = unitNameTimes;
        CouponType = CouponType;
    }

    public Coupon(String duration, String point, String value) {
        Duration = duration;
        Point = point;
        Value = value;
    }
}