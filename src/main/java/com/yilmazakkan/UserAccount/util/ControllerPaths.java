package com.yilmazakkan.UserAccount.util;

public final class ControllerPaths {


    private static final String BASE_PATH = "/rest";

    public static final  class TokenCtrl {
        public static final String CTRL = BASE_PATH + "/token";
    }

    public static final class UserCtrl {
        public static final String CTRL = BASE_PATH + "/users";
    }
}
