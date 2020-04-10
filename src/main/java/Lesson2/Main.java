package Lesson2;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;

    public static void main(String[] args) throws SQLException {
//        File file = new File("C:\\Users\\Павел\\Desktop\\DZ_update.txt");
//        ArrayList<String> strings = new ArrayList<>();
//        Scanner sc;
//
//
//        try{
//            sc = new Scanner(file);
//
//            while (sc.hasNextLine()) {
//                String line = sc.nextLine().trim();
//                strings.add(line);
//            }
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }

//        System.out.println(strings);


        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        createTable("students", "id", "name", "score");

        deleteFromTable("students", 10);

        insertIntoTable("students", "Bob2", "0", 4);

        updateTable("students", "score", "0", 1);


        ResultSet rs = selectAll();

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }


        disconnect();
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:mainDB.db");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(String tableName, String nameColumn1, String nameColumn2, String nameColumn3) throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS " + tableName + " ( " +
                nameColumn1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                nameColumn2 + " TEXT, " +
                nameColumn3 + " TEXT)");
    }

    public static void updateTable(String tableName, String nameColumnForUpdate, String value, int idValue) throws SQLException {
        stmt.executeUpdate(String.format("UPDATE %s SET %s = %s WHERE id = %d", tableName, nameColumnForUpdate, value, idValue));
    }

    public static void deleteFromTable(String tableName, int indexValue) throws SQLException {
        stmt.executeUpdate(String.format("DELETE FROM %s WHERE id = %d", tableName, indexValue));
    }

    public static void insertIntoTable(String tableName, String nameValue, String scoreValue, int idValue) throws SQLException {
        stmt.executeUpdate(String.format("INSERT INTO %s VALUES (%d, '%s', %s)", tableName, idValue, nameValue, scoreValue));
    }

    public static ResultSet select(String nameColumn, String tableName) throws SQLException {
        return stmt.executeQuery(String.format("SELECT %s FROM %s", nameColumn,tableName));
    }

    public static ResultSet selectAll() throws SQLException {
       return stmt.executeQuery("SELECT id, name, score FROM students");
    }
}
