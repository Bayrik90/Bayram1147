/* 1ый способ */
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Multi {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\Bayrik\\Desktop\\projects\\proxi\\ip.txt");
            int i;
            String result = "";
            while ((i = fin.read()) != -1) {
                if (i == 13) continue;// Возврат каретки, то пропускаем иттерацию
                else if (i == 10) {//Перенос строки
                    System.out.println("Пытаюсь подключиться " + result);
                    String ip = result.split(":")[0];
                    int port = Integer.parseInt(result.split(":")[1]);
                    result = "";//это есть вычищение
                    CheckProxyClass task1=new CheckProxyClass(ip,port);
                    task1.start();
                    System.out.println("*------*");
                } else if (i == 9) {
                    //System.out.println(":");//табуляция
                    result += ":";
                } else {//остальные символы
                    //System.out.println((char)i);
                    result += (char) i;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class CheckProxyClass extends Thread{
    String ip;
    int port;
    public CheckProxyClass(String ip,int port){
        this.ip=ip;
        this.port=port;
    }
    private void checkProxy(String ip, int port) {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection URLConnection = url.openConnection(proxy);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(URLConnection.getInputStream())
            );
            String inputLine;//переменная,в которую в формате строки кладем ответ от сервера
            while ((inputLine = in.readLine()) != null) {//читаем ответ от сервера пока не встретится нулл
                System.out.println(inputLine + " работает!");
            }
            in.close();//закрываем поток ввода
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("IP " + ip + " - не работает!");
        }
    }
    @Override
    public void run() {
        super.run();
        this.checkProxy(this.ip,this.port);
    }
}

/* 3ий способ*/

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Multi {
    public static void main(String[] args) {
        try {
            FileInputStream fin = new FileInputStream("C:\\Users\\Bayrik\\Desktop\\projects\\proxi\\ip.txt");
            int i;
            String result = "";
            while ((i = fin.read()) != -1) {
                if (i == 13) continue;// Возврат каретки, то пропускаем иттерацию
                else if (i == 10) {//Перенос строки
                    //System.out.println("Пытаюсь подключиться " + result);
                    String ip = result.split(":")[0];
                    int port = Integer.parseInt(result.split(":")[1]);
                    result = "";
                    Thread task=new Thread(new Runnable() {
                        @Override
                        public void run() {
                            //System.out.println(ip+port);
                            checkProxy(ip,port);
                        }
                    });
                    task.start();
                    //System.out.println("*------*");
                } else if (i == 9) {
                    //System.out.println(":");//табуляция
                    result += ":";
                } else {//остальные символы
                    //System.out.println((char)i);
                    result += (char) i;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void checkProxy(String ip, int port) {
        try {
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(ip, port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection URLConnection = url.openConnection(proxy);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(URLConnection.getInputStream())
            );
            String inputLine;//переменная,в которую в формате строки кладем ответ от сервера
            while ((inputLine = in.readLine()) != null) {//читаем ответ от сервера пока не встретится нулл
                System.out.println(inputLine + " работает!");
            }
            in.close();//закрываем поток ввода
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("IP " + ip + " - не работает!");
        }
    }

}
