package top.mapku.core.service.impl;

import org.springframework.stereotype.Component;
import top.mapku.core.mapper.ShopMapper;
import top.mapku.core.aop.exception.CodeException;
import top.mapku.core.service.ShopService;

import javax.annotation.Resource;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */
@Component
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopMapper shopMapper;

    @Override
    public boolean verify(String userId, String code) {
        boolean codeEqual = shopMapper.selectCodeByUserId(userId).equals(code);
        if (!codeEqual) {
            throw new CodeException();
        }
        return true;
    }
}
