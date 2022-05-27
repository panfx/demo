package com.example.demo.service;

import org.springframework.objenesis.instantiator.util.UnsafeUtils;
import sun.misc.Unsafe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author
 * @date 2022/05/08 19:34
 */
public class MyUnsafe {

    public static void main(String[] args) {
        Unsafe unsafe = UnsafeUtils.getUnsafe();
        System.out.println(unsafe);

        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            Object o = theUnsafe.get(null);
            Unsafe myUnsafe = (Unsafe) o;
            System.out.println(myUnsafe);

            Constructor<Unsafe> constructor = Unsafe.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            Unsafe unsafe1 = constructor.newInstance();
            System.out.println(unsafe1);
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
