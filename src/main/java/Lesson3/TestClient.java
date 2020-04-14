package Lesson3;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
    public static void main(String[] args) {
        Students students = new Students(1, "Bob");
        try (Socket s = new Socket("127.0.0.1", 8189)) {
            System.out.println("Socket connected");
            System.out.println("Socket ready");
            ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("stud.ser"));
            oos.writeObject(students);
            oos.close();
            students.info();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
