package Lesson6;


import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task2 task2 = new Task2();
        int[] arr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] arr2 = {2, 2, 3, 7, 4};

        System.out.println(Arrays.toString(task1.numsAfterFour(arr)));
        System.out.println(task2.searchNumFour(arr2));
    }


}
