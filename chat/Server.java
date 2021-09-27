package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class Server {
public static void main(String[] args) {
ArrayList<Socket> usersSocket = new ArrayList<>();//13
//ArrayList<String> names = new ArrayList<>();
Scanner scan=new Scanner(System.in);
try {
ServerSocket serverSocket = new ServerSocket(8188);//1) серверсокет читает порт
System.out.println("Сервер запущен");
while (true){
Socket socket = serverSocket.accept();//9
System.out.println("Подключился новый клиент");
usersSocket.add(socket);
DataOutputStream out = new DataOutputStream(socket.getOutputStream());//3)
DataInputStream in = new DataInputStream(socket.getInputStream());//3)
Thread thread = new Thread(new Runnable() {//10
@Override
public void run() {
String text;//11.1
ArrayList<String> names = new ArrayList<>();
try {//11
out.writeUTF("Имя пользователя");
String name = in.readUTF();
names.add(name);
while (true) {//2)
text = in.readUTF();//7
System.out.println("Клиент прислал сообщение: " + text);
// каждый элем из коллекции кладем в userSocket
for (Socket userSocket : usersSocket) {
DataOutputStream out = new DataOutputStream(userSocket.getOutputStream());
out.writeUTF(names+" : "+text);//15 рассылка по всем участникам чата
}
}
} catch (IOException exception) {
usersSocket.remove(socket);
System.out.println("Клиент отключился");//17
}
}
});
thread.start();//12
}
} catch (IOException exception) {
exception.printStackTrace();
}
}
}
