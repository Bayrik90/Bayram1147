package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.UUID;

public class User {
   private Socket socket;//1; 3- privati
   private String userName;
   private UUID uuid;
   private DataOutputStream out;//9
   private DataInputStream in;
    //
    public Socket getSocket() {return socket;}
    public String getUserName() {return userName;}
    public UUID getUuid() {return uuid;}
    public DataOutputStream getOut() {return out;}//9
    public DataInputStream getIn() {return in;}

    public void setOut(DataOutputStream out) {this.out = out;}//10
    public void setIn(DataInputStream in) {this.in = in;}
    public void setUserName(String userName) {//4
        this.userName = userName;
    }

    public User(Socket socket){//
        this.socket=socket;
        this.uuid= UUID.randomUUID();//уникальный ключ

    }
}
