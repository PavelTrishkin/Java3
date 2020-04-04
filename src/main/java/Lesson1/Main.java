package Lesson1;

import java.util.ArrayList;
import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        Integer arr1[] = {1,2,3,4,5};
        String arr2[] = {"A","B","C","D"};

        changeElements(arr2, 3, 0);
        arrToArrList(arr2);

        Box<Apple> appleBox = new Box<Apple>();
        Box<Apple> appleBox1 = new Box<Apple>();
        Box<Orange> orangeBox = new Box<Orange>();

        appleBox.addFruit(new Apple(), 14);
        orangeBox.addFruit(new Orange(), 10);

        System.out.println(appleBox.getWeight());
        System.out.println(orangeBox.getWeight());

        System.out.println(appleBox.compare(orangeBox));

        appleBox.changeBox(appleBox1);
    }

    //Задание 1
    public static void changeElements(Object arr[], int arrPos, int toPos){
        System.out.println("Начальный массив: "+ Arrays.toString(arr));
        Object n = arr[arrPos];

        arr[arrPos] = arr[toPos];
        arr[toPos] = n;

        System.out.println("Массив после перестановки:" + Arrays.toString(arr));
    }

    //Задание 2
    public static void arrToArrList(Object arr[]){

        ArrayList<Object> list = new ArrayList<Object>(Arrays.asList(arr));
        System.out.println(list);
    }

}
