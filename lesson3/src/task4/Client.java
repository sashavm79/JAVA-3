package task4;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws InterruptedException {
//        try(Socket socket = new Socket("localhost", 3345);
//            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//            ObjectOutputStream objOut = new ObjectOutputStream(socket.getOutputStream());
//            ObjectInputStream objIn = new ObjectInputStream(socket.getInputStream());) {
//
//            System.out.println("Соединение установлено");
//
//            while(!socket.isOutputShutdown()) {
//                System.out.println("Какого кота хотите отправить на сервер? Для выхода запустите кота quit");
//                String catName = br.readLine();
//                Cat cat = new Cat(catName);
//
//                objOut.writeObject(cat);
//                System.out.println("Кот до сериализации: " + cat);
//
//                if(cat.name.equals("quit")){
//                    System.out.println("Кот quit закрывает соединение");
//                    Thread.sleep(2000);
//                    break;
//                }
//
//                Cat catComeback = (Cat) objIn.readObject();
//                System.out.println("Вернувшийся кот: " + catComeback);
//            }
//            System.out.println("Соединение закрыто");
//
//        } catch (IOException | ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }

//        try(Socket socket = new Socket("localhost", 3345);
//            BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
//            DataOutputStream oos = new DataOutputStream(socket.getOutputStream());
//            DataInputStream ois = new DataInputStream(socket.getInputStream()); ) {
//
//            System.out.println("Client connected to socket.");
//            System.out.println();
//            System.out.println("Client writing channel = oos & reading channel = ois initialized.");
//
//            while(!socket.isOutputShutdown()){
//                if(br.ready()){
//                    System.out.println("Client start writing in channel...");
//                    Thread.sleep(1000);
//                    String clientCommand = br.readLine();
//
//                    oos.writeUTF(clientCommand);
//                    oos.flush();
//                    System.out.println("Client sent message " + clientCommand + " to server.");
//                    Thread.sleep(1000);
//
//                    if(clientCommand.equalsIgnoreCase("quit")){
//                        System.out.println("Client close connections");
//                        Thread.sleep(2000);
//
//                        System.out.println("reading...");
//                        String in = ois.readUTF();
//                        System.out.println(in);
//                        break;
//                    }
//                    System.out.println("Client sent message & start waiting for data from server...");
//                    Thread.sleep(2000);
//
//                    System.out.println("reading...");
//                    String in = ois.readUTF();
//                    System.out.println(in);
//                }
//            }
//            System.out.println("Closing connections & channels on clientSide - DONE.");
//
//        } catch (UnknownHostException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
