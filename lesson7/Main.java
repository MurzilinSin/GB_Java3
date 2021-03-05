package lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        Testing test = new Testing();
        start(Testing.class, test);
    }

    private static void start(Class<Testing> test, Testing testing) throws InvocationTargetException, IllegalAccessException {
        Method[] methods = test.getDeclaredMethods();
        List<Method> list = new ArrayList<>();

        checkBeforeAfterCount(methods);

        for (Method method : methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)){
                method.setAccessible(true);
                method.invoke(testing);
            }
        }
        for (Method method : methods) {
            if(method.isAnnotationPresent(Test.class)){
                list.add(method);
            }
        }
        bubbleSortByPriority(list);
        for (Method method : list) {
            method.invoke(testing);
        }
        for (Method method : methods) {
            if(method.isAnnotationPresent(AfterSuite.class)) {
                method.setAccessible(true);
                method.invoke(testing);
            }
        }

    }

    private static void bubbleSortByPriority(List<Method> list) {
        for (int j = list.size() - 1; j > 0; j--) {
            for (int i = 0; i < j; i++) {
                if(list.get(i).getAnnotation(Test.class).priority() < list.get(i+1).getAnnotation(Test.class).priority()){
                    Method tmp = list.get(i+1);
                    list.set(i+1, list.get(i));
                    list.set(i, tmp);
                }
            }
        }
    }

    private static void checkBeforeAfterCount(Method[] methods){
        int counta = 0;
        int countb = 0;
        for (Method method : methods) {
            if(method.isAnnotationPresent(BeforeSuite.class)){
                countb++;
            }
            else if(method.isAnnotationPresent(AfterSuite.class)){
                counta++;
            }
        }
        if(counta > 1 | countb > 1){
            throw new RuntimeException(String.format("Количество BeforeSuite: %s. \n Количество AfterSuite: %s",countb,counta));
        }
    }
}
