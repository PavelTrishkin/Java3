package Lesson3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(8189);
             Socket socket = server.accept()) {
            System.out.println("Client connected");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stud.ser"));
            Students students = (Students) ois.readObject();
            ois.close();
            students.info();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
