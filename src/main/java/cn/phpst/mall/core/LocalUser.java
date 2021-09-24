package cn.phpst.mall.core;

import cn.phpst.mall.model.User;

public class LocalUser {
    private static User user;

    public static void set(User user, Integer scope) {
        LocalUser.user = user;
    }

    public static User getUser() {
        return LocalUser.user;
    }
}
