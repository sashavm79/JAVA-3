package Lesson_2;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class Main {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pstmt;


    public static void main(String[] args) throws SQLException {

        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

//  закомментировал для того чтобы не создавалась новая таблица каждый раз
//        try {
//            create("newStudents");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        try {
            add("newStudents", "Bob3", "11");
            add("newStudents", "Sem3", "12");
            add("newStudents", "Bob4", "13");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            read("newStudents");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            delete("newStudents", "5", "4");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            upgrade("newStudents", "5");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            read("newStudents");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Распознаем текст из файла DZ_update.txt
        String text = readtxt();

        System.out.println(text);

        // Получаем массив элементов новых студентов из текста: text

        String[] [] textStudent = arrText(text);

        try {
        for(int i = 1; i < textStudent.length; i++) {
            add("newStudents", textStudent[i][2], textStudent[i][4]);
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            read("newStudents");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        disconnect();

    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:server.db");
        stmt = connection.createStatement();
    }

    public static void create(String name) throws SQLException{
        stmt.executeUpdate("CREATE TABLE " + name +
                "(id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "score TEXT)");
    }
    public static void add(String table, String name, String score) throws SQLException{
        stmt.executeUpdate("INSERT INTO " + table + " (name, score) VALUES ('" + name +"', " + score + ")");
    }

    public static void delete(String table, String score, String id) throws SQLException{
        stmt.executeUpdate("DELETE FROM " + table + " WHERE ID > '" + id + "'");
    }

    public static void upgrade(String table, String score) throws SQLException{
        stmt.executeUpdate("UPDATE " + table + " SET score = " + score);
    }

    public static void read(String table) throws SQLException{
        ResultSet rs = stmt.executeQuery("SELECT id, name, score FROM " + table);

        ResultSetMetaData rsmd = rs.getMetaData();

        for (int i = 1; i < rsmd.getColumnCount(); i++) {
            System.out.println(rsmd.getColumnName(i) + " " + rsmd.getColumnType(i) + " " + rsmd.getTableName(i));
        }

        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString("score"));
        }
    }
    public static String readtxt(){
        String text = "";
        try(FileReader reader = new FileReader("DZ_update.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                text = text + String.valueOf((char) c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return text;
    }

    public static String[][] arrText(String text) {
        String[] stringArray = text.split("\r\n");
        String[][] textStudent = new String[5][5];

        boolean karr = true;
        int k = 2;  //Уменьшает  создаваемый массив на 2 ед, т.к. первые 2 строки не относятся к данным по студентам.
        int l =1;  // коэффициент для последующего входа в создаваемый массив
        for (int i = 0; i < stringArray.length; i++) {
            String[] stringArrayNext = stringArray[i].split(" ");
            for (int j = 0; j < stringArrayNext.length; j++) {
                // Формируем массив из студентов файла
                if (stringArrayNext[j].equals("1") || l ==0) {
                        l = 0;
                    textStudent[i - k][j] = stringArrayNext[j];
                }
            }

        }
        return textStudent;
    }

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

