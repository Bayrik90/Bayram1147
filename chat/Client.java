package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
public static void main(String[] args) {
Scanner scanner = new Scanner(System.in);
try {
Socket socket = new Socket("127.0.0.1", 8188);
System.out.println("Успешно подключен!");
// Поток ввода
DataInputStream in = new DataInputStream(socket.getInputStream());//5
// Поток вывода
DataOutputStream out = new DataOutputStream(socket.getOutputStream());//5
Thread thread = new Thread(new Runnable() {//16
@Override
public void run() {
try {
while (true){
String response = in.readUTF();
System.out.println("Ответ сервера - "+response);//8
}
}catch (IOException e){
System.out.println("Соединение разорвано");
}
}
});
thread.start();

while (true){
System.out.println("Введите сообщение: ");// 6
String text = scanner.nextLine();
out.writeUTF(text);
}
} catch (IOException exception) {
exception.printStackTrace();
}
}
}
