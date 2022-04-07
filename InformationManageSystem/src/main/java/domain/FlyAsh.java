package domain;

import java.util.Date;
import java.util.Map;

public class FlyAsh {
    private int id;
    private String name;
    private String type;
    private Date getDate;
    private String origin;
    private String remark;

    public FlyAsh(int id, String name, String type, Date getDate, String origin, String remark) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.getDate = getDate;
        this.origin = origin;
        this.remark = remark;
    }

    public FlyAsh(Map<String, Object> m){
        this.id = (int) m.get("id");
        this.name = (String) m.get("name");
        this.type = (String) m.get("type");
        this.getDate = (Date) m.get("getDate");
        this.origin = (String) m.get("origin");
        this.remark = (String) m.get("remark");
    }

    public FlyAsh() {
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getGetDate() {
        return getDate;
    }

    public void setGetDate(Date getDate) {
        this.getDate = getDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "FlyAsh{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", getDate=" + getDate +
                ", origin='" + origin + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
