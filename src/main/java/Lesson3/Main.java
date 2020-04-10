package Lesson3;


import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

//        readFileOnByteArr();
//        sequentialReading();
//        readBook();
    }

    public static void readFileOnByteArr() {
        File file = new File("C:\\Зимний вечер.txt");
        try (FileInputStream in = new FileInputStream(file)) {
            byte[] arr = new byte[512];
            int x;

            while ((x = in.read(arr)) > 0) {
                System.out.println(new String(arr, 0, x));
            }

        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }

    public static void sequentialReading() {
        try {
            ArrayList<InputStream> al = new ArrayList<>();
            al.add(new FileInputStream("C:\\1.txt"));
            al.add(new FileInputStream("C:\\2.txt"));
            al.add(new FileInputStream("C:\\3.txt"));
            al.add(new FileInputStream("C:\\4.txt"));
            al.add(new FileInputStream("C:\\5.txt"));

            SequenceInputStream in = new SequenceInputStream(Collections.enumeration(al));
            int x;

            while ((x = in.read()) != -1){
                System.out.print((char)x);
            }
            in.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }

    public static void readBook(){
        try(RandomAccessFile in = new RandomAccessFile("C:\\book.txt", "r");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            long fileLength = in.length();
            long pageLength = 1800;
            long pagesCount = fileLength/pageLength;
            byte[] b = new byte[1800];
            System.out.println("Длина файла: " + fileLength + "  Длина страницы: " + pageLength + "  Кол-во страниц: " + pagesCount);
            while (true) {
                System.out.println("\nВведите номер страницы в диапозоне от 0 до " + pagesCount + ". -1 для Выхода.");
                long p = Long.parseLong(br.readLine());
                if (p <= pagesCount && p >= 0) {
                    in.seek(p * pageLength);
                    in.read(b, 0, b.length);
                    for (byte bb : b) System.out.print((char) bb);
                } else if (p == -1) {
                    System.out.println("До встречи!");
                    System.exit(0);
                } else {
                    System.out.println("Такой страницы не существует: " + p);
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void test(){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            byte[] arr = new byte[512];
            int x;
            System.out.println("Введите путь к файлу, который нужно прочитать");
            FileInputStream in = new FileInputStream(br.readLine());
            while ((x = in.read(arr)) > 0) {
                System.out.println(new String(arr, 0, x));
            }

        } catch (IOException e) {
            e.fillInStackTrace();
        }
    }//попробовал сделать метод чтобы самому указывать путь к файлу
}

