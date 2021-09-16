public class Main {
    public static void main(String[] args) {
        Mouse jerryMouse = new Mouse("Jerry", 12, 5);
        Dog guffi=new Dog("Quffi",90,50);
        Cat tom=new Cat("Tom",70,30); 
    }
}
class Mouse {
    String name;
    int height;
    int tail;

    public Mouse(String name, int height, int tail) {
        this.name = name;
        this.height = height;
        this.tail = tail;
    }
}
class Dog{
    String name;
    int height;
    int tall;

    public Dog(String name,int height,int tall){
        this.name=name;
        this.height=height;
        this.tall=tall;
    }
}
class Cat{
    String name;
    int height;
    int tall;

    public Cat(String name,int height,int tall){
        this.name=name;
        this.height=height;
        this.tall=tall;
    }
}
