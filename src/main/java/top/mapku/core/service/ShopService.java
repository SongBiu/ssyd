package top.mapku.core.service;

/**
 * create by lisong
 * email: songlcis@gmail.com
 */

public interface ShopService {
    boolean verify(String userId, String code);

    void buyPostcard(String userId);

    void buyVoucher(String userId);

    void usePostcard(String userId);

    void useVoucher(String userId);
}
