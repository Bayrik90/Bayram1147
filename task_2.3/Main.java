//Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.

public class Main {
    public static void main(String[] args) {
        String triangle="8";
        for (int i = 0; i < 10; i++) {
            System.out.println(triangle);
            triangle+=8;
        }
    }
}
