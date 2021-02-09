package lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class MethodArrayToList {
    public static void main(String[] args) {
        Object[] arr = {1,2,3,"s"};
        transform(arr);
    }

    public static ArrayList<Object> transform(Object[] arr) {
        ArrayList<Object> array = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            array.add(arr[i]);
        }
        return array;
    }
}
