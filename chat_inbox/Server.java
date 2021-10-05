package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


public class Server {
    public static void main(String[] args) {

        ArrayList<User> users=new ArrayList<>();//(UC)-6
        try {
            ServerSocket serverSocket = new ServerSocket(8188);//1) серверсокет читает порт
            System.out.println("Сервер запущен");
            while (true){
                Socket socket = serverSocket.accept();//9
                System.out.println("Подключился новый клиент");
                User currentUser=new User(socket);//5-от User.class
                users.add(currentUser);//UC-7; и нижний юзерссокет.адд нам более не нужен
                currentUser.setOut(new DataOutputStream(currentUser.getSocket().getOutputStream()));//
                currentUser.setIn(new DataInputStream(currentUser.getSocket().getInputStream()));
                Thread thread = new Thread(new Runnable() {//10
                    @Override
                    public void run() {
                        String text;//11.1
                        try {//11
                            currentUser.getOut().writeUTF("Введите имя: ");//uc-15
                            String userName=currentUser.getIn().readUTF();
                            for(User user:users){
                                if (userName.equals(user.getUserName())){
                                    user.getOut().writeUTF("Пользователь с таким именем существует,выберите другое имя");
                                    userName=currentUser.getIn().readUTF();
                                }
                            }
                            currentUser.setUserName(userName);//кладем имена в метод сетюзер и устанавливаем их
                            for (User user : users) {//uc-18
                                user.getOut().writeUTF("Пользователь "+currentUser.getUserName()+" присоединился к чату");
                            }
                            while (true) {//2)
                                text = currentUser.getIn().readUTF();//7; uc-12
                                if(text.equals("/onlineUsers")){//uc-22
                                    String names="Пользователи онлайн: ";
                                    for(User user: users){
                                        names+=user.getUserName()+", ";
                                    }
                                    currentUser.getOut().writeUTF(names);//отправили список онлайн юзеров
                                }else if (text.indexOf("/m")==0){
                                    String[] splittedText=text.split(" ");
                                    for(User user:users){
                                        if(user.getUserName().equals(splittedText[1])){
                                            user.getOut().writeUTF(splittedText[2]);
                                            break;
                                        }
                                    }
                                }
                                else {// uc -23 -рассылка сообщения
                                    System.out.println(currentUser.getUserName()+" : " + text);//uc-16 и копируем его в значение фор
                                    // каждый элем из коллекции кладем в userSocket
                                    for (User user : users) {//Uc-8; currentUser это текущий,а user - все пользов-ли
                                        if (currentUser.getUuid().equals(user.getUuid())) continue;//uc-20
                                        user.getOut().writeUTF(currentUser.getUserName() + " : " + text);//uc-13
                                    }
                                }
                            }
                        } catch (IOException exception) {
                            //uc=14-currentUser вместо сокета
                            users.remove(currentUser);
                            for (User user : users) {
                                try {
                                    user.getOut().writeUTF("Пользователь "+currentUser.getUserName()+" покинул чат");//uc-19
                                } catch (IOException e) {//uc-19
                                    e.printStackTrace();
                                }
                            }
                            System.out.println("Клиент "+currentUser.getUserName()+" отключился");//17
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
