package top.mapku.utils;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public class Constant {
    public static final String COOKIE_SESSION_ID = "ssid";
    public static final String OPENID_URL_FORMAT = "https://api.weixin.qq.com/sns/jscode2session?appid=%s&secret=%s&js_code=%s&grant_type=authorization_code";
    public static final int SECONDS_ONE_DAY = 3600 * 24;
    public static final int MAX_SCORE_PER_MOMENT = 5;
    public static final int REWARD_SCORE = 3;
    public static final int PRICE_POSTCARD = 3;
    public static final int PRICE_VOUCHER = 10;
}
