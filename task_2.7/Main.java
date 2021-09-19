// Дано число, например 31. Проверьте, что это число не делится ни на одно другое число кроме себя самого и единицы
public class Main {
    public static void main(String[] args) {
        int a=31;
        for (int i = 2; i <a ; i++) {
            if(a%i==0) System.out.println(true);
            else System.out.println(false);
            break;
        }
    }
