/*
Задание: Дан массив с элементами [2, 3, 4, 5]. С помощью цикла for найдите произведение элементов этого массива.
*/
public class Main {
    public static void main(String[] args) {
        double[]arr={2,3,4,5};
        double sum=1;
        for (int i = 0; i < arr.length; i++) {
            sum=sum*arr[i];
        }
        System.out.print(sum);
    }
