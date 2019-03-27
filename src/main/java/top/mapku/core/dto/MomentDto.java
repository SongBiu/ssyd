package top.mapku.core.dto;


import java.sql.Date;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public class MomentDto {
    private Integer momentId;
    private Date momentDate;
    private Integer bag;
    private String content;
    private String imgurl;
    private String postion;
    private Boolean simple;
    private String userId;
    private String good;

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }

    public Date getMomentDate() {
        return momentDate;
    }

    public void setMomentDate(Date momentDate) {
        this.momentDate = momentDate;
    }

    public Integer getBag() {
        return bag;
    }

    public void setBag(Integer bag) {
        this.bag = bag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public Boolean getSimple() {
        return simple;
    }

    public void setSimple(Boolean simple) {
        this.simple = simple;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getGood() {
        return good;
    }

    public void setGood(String good) {
        this.good = good;
    }
}
