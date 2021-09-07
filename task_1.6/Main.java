import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ваше число");
        int num=scan.nextInt();
        System.out.println("Результат вашего числа будет равен "+(num+(num*0.15)));
    }
}
