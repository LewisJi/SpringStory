package com.Lewis.system.sourceconfig;

public class EnvDefine {
    // 私有化建構子，防止這個常數類別被實例化
    private EnvDefine() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final String PROFILE_DEV = "dev";
    public static final String PROFILE_PROD = "prod";
    public static final String PROFILE_SIT = "sit";

    public static final String BASE_REPOSITORY = "com.Lewis.system.sourceconfig";
}
