package top.mapku.core.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import top.mapku.utils.Constant;

@Component
public class HttpUrl {
    @Value("${ssyd.appid}")
    private String appid;

    @Value("${ssyd.secret}")
    private String secret;

    private String jscode;

    public void setJscode(String jscode) {
        this.jscode = jscode;
    }

    @Override
    public String toString() {
        return String.format(Constant.OPENID_URL_FORMAT, appid, secret, jscode);
    }
}
