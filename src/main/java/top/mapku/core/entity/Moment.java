package top.mapku.core.entity;


import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public class Moment {

    @Value("${ssyd.domain}")
    private String domain;

    private Integer momentId;
    private Date momentDate;
    private String userId;
    private Integer bag;
    private String content;
    private String imageUrl;
    private String position;
    private Boolean ssyd;
    private Integer good;

    public Moment(String userId, Integer bag, String content, String imageUrl, String position, Boolean ssyd) {
        this.userId = userId;
        this.bag = bag;
        this.content = content;
        this.imageUrl = imageUrl;
        this.position = position;
        this.ssyd = ssyd;
    }

    public Moment(String userId, String content, String position, Boolean ssyd) {
        this.userId = userId;
        this.content = content;
        this.position = position;
        this.ssyd = ssyd;
    }

    static Moment ssydMoment(String userId, Integer bag, String content, String imageUrl, String position) {
        return new Moment(userId, bag, content, imageUrl, position, true);
    }

    static Moment xqjlMoment(String userId, String content, String position) {
        return new Moment(userId, content, position, false);
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getSsyd() {
        return ssyd;
    }

    public void setSsyd(Boolean ssyd) {
        this.ssyd = ssyd;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }
}
