package com.avery.book.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	private static Properties properties = null;
    static {
        // 生成输入流
        InputStream ins=PropertyUtil.class.getClassLoader().getResourceAsStream("app.properties");
        // 生成properties对象
        properties = new Properties();
        try {
            properties.load(ins);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != ins) {
                    ins.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getProperty(String key) {
    	return properties.getProperty(key);
    }
}
