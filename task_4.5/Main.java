public class Main{
    public static void main(String[] args) {
        Horse horse=new Horse();
        horse.run();
        Pegasus pegasus=new Pegasus();
        pegasus.fly();
    }
}
class Animal{

}
class Horse extends Animal{
    public void run(){
        System.out.println("Итого, я поскакал(а)");
    }
}
class Pegasus extends Horse{
    public void fly(){
        System.out.println("Итого,я полетел(а)");
    }
}
