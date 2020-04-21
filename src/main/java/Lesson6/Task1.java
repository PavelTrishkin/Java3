package Lesson6;

public class Task1 {
    public static int[] numsAfterFour(int[] arr) throws RuntimeException {
        int pos = 0;
        int[] arr2 = new int[0];
        boolean bool = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 4) {
                pos = i;
                bool = true;
            }
            arr2 = new int[arr.length - pos - 1];
            System.arraycopy(arr, pos + 1, arr2, 0, arr2.length);
        }
        if (bool != true) {
            throw new RuntimeException("4 не найдена");
        }
        return arr2;
    }
}
