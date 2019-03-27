package top.mapku.utils;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import top.mapku.core.entity.HttpUrl;

import javax.annotation.PostConstruct;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@Component
public class WxUtils {
    @Autowired
    private HttpUrl httpUrl;
    private static WxUtils wxUtils;

    @PostConstruct
    void init() {
        wxUtils = this;
        wxUtils.httpUrl = this.httpUrl;
    }

    public static String getOpenid(String jsonCode) {
        wxUtils.httpUrl.setJscode(jsonCode);
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(wxUtils.httpUrl.toString(), String.class);
        JSONObject jsonObject = new JSONObject(jsonString);
        return (String) jsonObject.get("openid");
    }
}
