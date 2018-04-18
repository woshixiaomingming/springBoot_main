package com.util;

import java.util.ResourceBundle;

public class MainGlobalConfig {

        private static ResourceBundle rb = null;
        private static MainGlobalConfig config = null;
        private static Object lock = new Object();
        private static String config_file = "main";

        public MainGlobalConfig() {
            if (rb == null) {
               rb = ResourceBundle.getBundle(config_file);
            }
        }

        public static void getInstance () {
            if (null == config) {
                synchronized (lock) {
                    config = new MainGlobalConfig();
                }
            }
        }

        public static String getValue (String key) {
            if (null == config) {
                getInstance();
            }
            try {
                if (null == rb) {
                    return null;
                } else {
                    return rb.getString(key);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
}
