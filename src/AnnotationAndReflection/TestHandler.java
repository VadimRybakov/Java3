package AnnotationAndReflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.TreeMap;

public class AbstractTest {

    private static final int MIN_PRIORITY = 1;
    private static final int MAX_PRIORITY = 10;
    private static final Map<Integer, Method> methodMap = new TreeMap<>();
    private static Method[] methods;
    private static Class<?> clazz;

    public static void start(Object testClass) {
        if (testClass instanceof Class) {
            clazz = (Class<?>) testClass;
            methods = clazz.getDeclaredMethods();
        }

        else if (testClass instanceof String) {
            try {
                clazz = Class.forName((String) testClass);
                methods = clazz.getDeclaredMethods();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else throw new RuntimeException("Argument is not class or className");


        for (Method m : methods) {

            if (m.getAnnotation(Before.class) != null) {
                methodMap.put(MIN_PRIORITY - 1, m);
            }
            if (m.getAnnotation(After.class) != null) {
                methodMap.put(MAX_PRIORITY + 1, m);
            }
            if (m.getAnnotation(Test.class) != null) {
                methodMap.put(m.getAnnotation(Test.class).priority(), m);
            }
        }

        for (Integer key : methodMap.keySet()) {
            System.out.println("priority:" + key + " " + methodMap.get(key).getName());
        }
        try {
            Object tests = clazz.getDeclaredConstructor().newInstance();
            for (Integer key : methodMap.keySet()) {
                methodMap.get(key).invoke(tests);
            }
        } catch (IllegalAccessException | InvocationTargetException
                | NoSuchMethodException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
