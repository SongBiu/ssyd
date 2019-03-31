package top.mapku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import top.mapku.core.aop.annotation.Auth;
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
    @Auth
    public boolean verify(@CookieValue("id") String userId, @RequestParam String code) {
        return shopService.verify(userId, code);
    }

    @PostMapping("/buy/postcard")
    @Message(fail = "购买明信片失败", success = "购买明信片成功")
    @Auth
    public void buyPostcard(@CookieValue("id") String userId) {
        shopService.buyPostcard(userId);
    }

    @PostMapping("/buy/voucher")
    @Message(fail = "购买代金券失败", success = "购买代金券成功")
    @Auth
    public void buyVoucher(@CookieValue("id") String userId) {
        shopService.buyVoucher(userId);
    }

    @PostMapping("/use/postcard")
    @Message(fail = "使用明信片失败", success = "使用明信片成功")
    @Auth
    public void usePostcard(@CookieValue("id") String userId) {
        shopService.usePostcard(userId);
    }

    @PostMapping("/use/voucher")
    @Message(fail = "使用代金券失败", success = "使用代金券成功")
    @Auth
    public void useVoucher(@CookieValue("id") String userId) {
        shopService.useVoucher(userId);
    }
}
