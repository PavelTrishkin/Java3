package Lesson6;

public class Task2 {
    public static boolean searchNumFour(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                return true;
            }
            else if (arr[i] == 1){
                return true;
            }
        }
        return false;
    }
}
