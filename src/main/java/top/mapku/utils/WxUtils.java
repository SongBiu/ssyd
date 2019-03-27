package top.mapku.utils;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import top.mapku.core.dto.OpenIdDto;

import javax.annotation.PostConstruct;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

@Component
public class WxUtils {
    @Autowired
    private OpenIdDto openIdDto;
    private static WxUtils wxUtils;

    @PostConstruct
    void init() {
        wxUtils = this;
        wxUtils.openIdDto = this.openIdDto;
    }

    public static String getOpenid(String jsonCode) {
        wxUtils.openIdDto.setJscode(jsonCode);
        RestTemplate restTemplate = new RestTemplate();
        String jsonString = restTemplate.getForObject(wxUtils.openIdDto.toString(), String.class);
        JSONObject jsonObject = new JSONObject(jsonString);
        return (String)jsonObject.get("openid");
    }
}
