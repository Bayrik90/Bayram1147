   import java.io.*;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        try{
            FileInputStream fin=new FileInputStream("C:\\Users\\Bayrik\\Desktop\\projects\\proxi\\ip.txt");
            int i;
            String result="";
            while ((i=fin.read())!=-1){
                if(i==13) continue;// Возврат каретки, то пропускаем иттерацию
                else if(i==10){//Перенос строки
                    System.out.println("Пытаюсь подключиться "+result);
                    String ip=result.split(":")[0];
                    int port=Integer.parseInt(result.split(":")[1]);
                    result="";//это есть вычищение
                    checkProxy(ip,port);
                    System.out.println("*------*");
                }else if(i==9){
                    //System.out.println(":");//табуляция
                    result+=":";
                }else{
                    result+=(char) i;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    static void checkProxy(String ip, int port){
        try {
            //Создаем объект прокси
            Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));
            //Указываем к какому ресурсу нужно подключиться
            URL url = new URL("https://vozhzhaev.ru/test.php");
            //открываем соединение
            URLConnection URLConnection = url.openConnection(proxy);
            //сохраняем ответ в поток ввода

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(URLConnection.getInputStream())
            );
            String inputLine;//переменная,в которую в формате строки кладем ответ от сервера
            while ((inputLine = in.readLine()) != null){//читаем ответ от сервера пока не встретится нулл
                System.out.println(inputLine+" работает!");
                FileOutputStream fos=new FileOutputStream("C:\\Users\\Bayrik\\Desktop\\projects\\proxi\\good_ip.txt", true);
                String ip_port = ip+':'+port+'\n';
                byte[] buffer = ip_port.getBytes();
                fos.write(buffer); //

            }
            in.close();//закрываем поток ввода

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("IP "+ip+" - не работает!");// Если ip не доступен, то бужет Exception, но мы его обрабатываем и выводим инфо на экран
        }
    }
}
