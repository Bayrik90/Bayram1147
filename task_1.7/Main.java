import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a= scan.nextInt();
        int b= scan.nextInt();
        int c= scan.nextInt();
        int kub_metr=1000;
        System.out.println("Количество литров воды нужное для наполнения бассейна будет равно "+(a*b*c*kub_metr));
    }
}
