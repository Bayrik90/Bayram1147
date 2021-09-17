import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> names = new ArrayList();
        names.add("Анатолий");
        names.add("Георгий");
        names.add("Руслан");
        names.add("Георгий");
        names.add("Павел");
        names.add("Руслан");

        System.out.println("List"+names);
        Set<String> set = new LinkedHashSet<>(names);
        // чистим  коллекцию
        names.clear();
        names.addAll(set);
        System.out.println("List after short"+names);
}}
