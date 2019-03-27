package top.mapku.core.dto;


import java.sql.Date;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public class UserDto {
    private String userId;
    private String userName;
    private Integer teamId;
    private Date registrationDate;
    private Integer score;
    private Integer bag;
    private Integer postcard;
    private Integer voucher;
    private String avatarUrl;
    private Boolean pku;

    public UserDto(String userId, String userName, String avatarUrl) {
        this.userId = userId;
        this.userName = userName;
        this.avatarUrl = avatarUrl;
    }

    public UserDto(String userId, String userName, Integer teamId, Date registrationDate, Integer score, Integer bag, Integer postcard, Integer voucher, String avatarUrl, Boolean pku) {
        this.userId = userId;
        this.userName = userName;
        this.teamId = teamId;
        this.registrationDate = registrationDate;
        this.score = score;
        this.bag = bag;
        this.postcard = postcard;
        this.voucher = voucher;
        this.avatarUrl = avatarUrl;
        this.pku = pku;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getBag() {
        return bag;
    }

    public void setBag(Integer bag) {
        this.bag = bag;
    }

    public Integer getPostcard() {
        return postcard;
    }

    public void setPostcard(Integer postcard) {
        this.postcard = postcard;
    }

    public Integer getVoucher() {
        return voucher;
    }

    public void setVoucher(Integer voucher) {
        this.voucher = voucher;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Boolean getPku() {
        return pku;
    }

    public void setPku(Boolean pku) {
        this.pku = pku;
    }
}
