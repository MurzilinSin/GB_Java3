package lesson6;

import java.util.Arrays;

public class Methods {

    public int[] outputAfterFour(int[] arr){
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 4) {
                index = i+1;
            }
        }

        if(index == 0 | arr.length == 0) {
            System.err.println("Херня какая то! Ошибка Runtime!");
            throw new RuntimeException();
        }

        int[] modifiedArr = new int[arr.length-index];
        for (int i = index, j = 0; i < arr.length; i++) {
            modifiedArr[j] = arr[i];
            j++;
        }
        return modifiedArr;
    }

    public boolean oneAndFour(int[] arr){
        int four = 0;
        int one = 0;
        int something = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 1){
                one++;
            }
            else if (arr[i] == 4){
                four++;
            }
            else {
                something++;
            }
        }
        return four!=0 && one!=0 && something == 0;
    }
}