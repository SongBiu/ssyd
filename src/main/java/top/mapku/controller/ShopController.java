package top.mapku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.mapku.core.aop.annotation.Message;
import top.mapku.core.service.impl.ShopServiceImpl;

import javax.annotation.Resource;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Controller
@RequestMapping("/wxapp/shop")
public class ShopController {
    @Resource
    private ShopServiceImpl shopService;

    @PutMapping("/verify-code")
    @Message(success = "验证码通过", fail = "验证码错误")
    public boolean verify(@RequestParam String userId, @RequestParam String code) {
            return shopService.verify(userId, code);
    }
}
