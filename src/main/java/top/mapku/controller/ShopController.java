package top.mapku.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
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
    public boolean verify(@CookieValue("id") String userId, @RequestParam String code) {
        return shopService.verify(userId, code);
    }

    @PostMapping("/buy/postcard")
    public void buyPostcard(@CookieValue("id") String userId) {
        shopService.buyPostcard(userId);
    }

    @PostMapping("/buy/voucher")
    public void buyVoucher(@CookieValue("id") String userId) {
        shopService.buyVoucher(userId);
    }

    @PostMapping("/use/postcard")
    public void usePostcard(@CookieValue("id") String userId) {
        shopService.usePostcard(userId);
    }

    @PostMapping("/use/voucher")
    public void useVoucher(@CookieValue("id") String userId) {
        shopService.useVoucher(userId);
    }
}
