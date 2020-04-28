package Lesson8;

public class Main {
    static final int SIZE_MIN = 5;
    static final int SIZE_MAX = 7;
    static final int SIZE = arrSize(SIZE_MIN, SIZE_MAX);
    static int value = 1;

    public static void main(String[] args) {

        int[][] matrix = new int[SIZE][SIZE];

        System.out.println(matrix.length);

        showMatrix(completionArr(completionEdges(matrix)));
    }

    /*
    Выбираем число от 5 до 7
     */
    public static int arrSize(int min, int max) {
        max -= min;

        return (int) (Math.random() * ++max) + min;
    }

    /*
    Метод печати двумерного массива
     */
    static void showMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println();
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] < 10) {
                    System.out.print(matrix[i][j] + "  ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
    }

    /*
    Метод заполнения двумерного массива по периметру
     */
    static int[][] completionEdges(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            matrix[0][i] = value;
            value++;
        }

        for (int i = 1; i < matrix.length; i++) {
            matrix[i][SIZE - 1] = value;
            value++;
        }

        for (int i = SIZE - 1; i != 0; i--) {
            matrix[SIZE - 1][i - 1] = value;
            value++;
        }
        for (int i = SIZE - 2; i != 0; i--) {
            matrix[i][0] = value;
            value++;
        }

        return matrix;
    }

    /*
    Метод заполнения остальной части двумерного массива
     */
    static int[][] completionArr(int[][] matrix) {
        int x = 1;
        int y = 1;


        while (value < SIZE*SIZE) {

            while (matrix[x][y+1] == 0) {
                matrix[x][y] = value;
                value++;
                y++;
            }

            while (matrix[x+1][y] == 0){
                matrix[x][y] = value;
                value++;
                x++;
            }

            while (matrix[x][y-1] == 0){
                matrix[x][y] = value;
                value++;
                y--;
            }

            while (matrix[x-1][y] == 0){
                matrix[x][y]= value;
                value++;
                x--;
            }
        }
        matrix[x][y] = value;
        return matrix;
    }

}
