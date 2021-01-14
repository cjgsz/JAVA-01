package com.company;


import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main( String[] args ) throws IOException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        myClassLoader myClassLoader = new myClassLoader();
        Class<?> helloClass  = myClassLoader.loadClass("Hello", "Hello.xlass");
        Object o = helloClass.newInstance();
        Method hello = helloClass.getMethod("hello");
        hello.invoke(o);
    }

}
