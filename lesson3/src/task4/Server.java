package task4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws InterruptedException {
        try (ServerSocket server = new ServerSocket(3345)) {
            Socket client = server.accept();
            System.out.println("Соединение установлено");

            ObjectInputStream objIn = new ObjectInputStream(client.getInputStream());
            ObjectOutputStream objOut = new ObjectOutputStream(client.getOutputStream());

            while(!client.isClosed()) {
                Cat catIn = (Cat) objIn.readObject();
                System.out.println("Восстановленный кот: " + catIn);

                if(catIn.name.equals("quit")){
                    System.out.println("Пришел отключающий программу кот quit...");
                    Thread.sleep(3000);
                    break;
                }

                objOut.writeObject(catIn);
            }

            System.out.println("Клиент отключился");

            objIn.close();
            objOut.close();

            client.close();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


