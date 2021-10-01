/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если эти числа равны - пусть функция вернет true, а если не равны - false.
*/
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Ввести число 1");
        int a=scanner.nextInt();
        System.out.println("Ввести число 2");
        int b=scanner.nextInt();
        boolean test=num(a,b);
        if(test==true){
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
    public static boolean num(int a,int b) {
        if(a==b){return (true);}
        else return (false);
    }
}

