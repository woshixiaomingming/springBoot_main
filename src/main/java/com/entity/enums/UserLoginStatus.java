package com.entity.enums;

public enum UserLoginStatus {

    Fail(0, "未登陆"),

    SUCCESS(1, "已登陆");

    private int key;
    private String value;

    UserLoginStatus(int key, String value) {
        this.key = key;
        this.value = value;
    }

    UserLoginStatus(String value) {
        this.key = key;
        this.value = value;
    }

    UserLoginStatus(int key) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByKey(int key) {
        UserStatus[] enums = UserStatus.values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getKey() == key) {
                return enums[i].getValue();
            }
        }
        return "";
    }

    public static Integer getKeyByValue(String value) {
        UserStatus[] enums = UserStatus.values();
        for (int i = 0; i < enums.length; i++) {
            if (enums[i].getValue().equals(value)) {
                return enums[i].getKey();
            }
        }
        return null;
    }
}
