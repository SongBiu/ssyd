package top.mapku.core.entity;

public class Good {
    public String userId;
    public Integer momentId;

    public Good(String userId, Integer momentId) {
        this.userId = userId;
        this.momentId = momentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMomentId() {
        return momentId;
    }

    public void setMomentId(Integer momentId) {
        this.momentId = momentId;
    }
}
