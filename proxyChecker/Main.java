    static void checkProxy(String ip, int port){
        try {
            Proxy proxy=new Proxy(Proxy.Type.HTTP,new InetSocketAddress(ip,port));
            URL url = new URL("https://vozhzhaev.ru/test.php");
            URLConnection URLConnection = url.openConnection(proxy);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(URLConnection.getInputStream())
            );
            String inputLine;
            while ((inputLine = in.readLine()) != null){
                System.out.println(inputLine+" работает!");
                FileOutputStream fos=new FileOutputStream("C:\\Users\\Bayrik\\Desktop\\projects\\proxi\\good_ip.txt", true);
                String ip_port = ip+':'+port+"\n";
                byte[] buffer = ip_port.getBytes();
                fos.write(buffer); //

            }
            in.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("IP "+ip+" - не работает!");// Если ip не доступен, то бужет Exception, но мы его обрабатываем и выводим инфо на экран
        }
    }
