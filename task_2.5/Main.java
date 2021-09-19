/*
Задание: Запросить у пользователя ввод числа и сохранить это число в переменную a.Если переменная a равна 10, то выведите 'Верно', иначе выведите 'Неверно'.
*/
public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("Введите число ");
        int a= scan.nextInt();
        if(a==10) System.out.println("OK");
        else System.out.println("Неверно");
    }
}
