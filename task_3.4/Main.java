/*
Задание: Сделайте функцию, которая параметрами принимает 2 числа. Если их сумма больше 10 - пусть функция вернет true, а если нет - false.
*/


import java.util.Scanner;
public class Test {
    public static void main(String[] args) {
        //напишите тут ваш код
        Scanner scan= new Scanner(System.in);
        System.out.println("Введите число А");
        int a=scan.nextInt();
        System.out.println("Введите число B");
        int b=scan.nextInt();
        boolean test=num(a,b);
        if(test==true) {
            System.out.println(true);
        }else {
            System.out.println(false);
        }
    }
    public static boolean num(int a,int b) {
        int res=a+b;
        if(res>10) {
            return (true);
        }else {
            return (false);
        }
    }
}
