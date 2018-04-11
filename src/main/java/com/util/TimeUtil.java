package com.util;

import java.sql.Timestamp;

public class TimeUtil {

    public static Timestamp getNow () {
        return new Timestamp(System.currentTimeMillis());
    }
}
