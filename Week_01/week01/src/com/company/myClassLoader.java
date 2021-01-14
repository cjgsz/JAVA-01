package com.company;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Copyright(C),2020-2021,gsz
 * FileName:myClassLoader
 * Auther:  gaoshangzheng
 * Date:    2021/1/1422:49
 * Description:my classloader
 * History:
 * <author>   <time>  <version>  <desc>
 * 作者姓名    时间     版本号    描述
 */
public class myClassLoader extends ClassLoader{
    public Class<?> loadClass(String className, String classPath) throws IOException {
        InputStream is = this.getClass().getResourceAsStream(classPath);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n = 0;
        while (-1 != (n = is.read(buffer))) {
            os.write(buffer, 0, n);
        }
        byte[] originBytes = os.toByteArray();
        for (int i = 0; i < originBytes.length; i++) {
            originBytes[i] = (byte) (255 - originBytes[i]);
        }
        if (originBytes.length > 0) {
            return super.defineClass(className, originBytes, 0, originBytes.length);
        }
        return null;

    }
}
