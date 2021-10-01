/*
Задание: Дан массив с числами. Выведите последовательно его элементы используя рекурсию и не используя цикл.
*/


public class Main {
    public static void main(String[] args) {
        int num[] = {4,2,6,2,65};
        int i=0;
        F(i, num);
    }

    private static void F(int i,int[] num) {
        System.out.println(num[i++]);
        if(i<num.length){F(i, num);}
    }
}
