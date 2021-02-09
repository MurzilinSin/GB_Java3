package lesson1;

import java.util.Arrays;

public class MethodChange {
    public static void changePose(Object[] arr,Object a, Object b) {
        int one = 0;
        int two = 0;
        for (int i = 0; i < arr.length; i++) {
            if(a == arr[i]) {
                one = i;
            }
            if(b == arr[i]) {
                two = i;
            }
        }
        arr[one] = b;
        arr[two] = a;
    }

    public static void main(String[] args) {
        Object[] arr = {4,5,6,7,8,9};
        changePose(arr,4,9);
        System.out.println(Arrays.toString(arr));
    }
}
