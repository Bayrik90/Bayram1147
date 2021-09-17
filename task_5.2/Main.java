import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Модернизация ПО
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //List<String> list = new ArrayList<>();
        List<String> cities = new ArrayList<>();
        List<String> addresses = new ArrayList<String>();
        while (true) {
            //String family = scanner.nextLine();
            String city= scanner.nextLine();
            if (city.isEmpty()) {
                break;
            }
            //list.add(family);
            String family= scanner.nextLine();
            cities.add(city);
            addresses.add(family);
        }

        // Read the house number
        String cityIndex= scanner.nextLine();
        for(int i=0;i<cities.size();i++){
            if(cityIndex.equals(cities.get(i))){
                System.out.println(addresses.get(i));
            }
        }
        /*int houseNumber = scanner.nextInt();
        if (0 <= houseNumber && houseNumber < list.size()) {
            String familyName = list.get(houseNumber);
            System.out.println(familyName);
        }*/
    }
}
