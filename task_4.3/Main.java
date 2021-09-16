public class Main {
    public static void main(String[] args) {
        Cat cat1=new Cat();
        Cat cat2=new Cat();
        cat1.age=8;
        cat1.weight=10;
        cat1.strength=20;
        cat2.age=7;
        cat2.weight=11;
        cat2.strength=20;
        System.out.println(cat1.fight(cat2));
    }
}

class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int ball=0;
        if(this.age> anotherCat.age)ball++;
        if(this.weight> anotherCat.weight)ball++;
        if(this.strength> anotherCat.strength)ball++;
        if(ball>1) return true;
        else if(ball>0) return true;
        else return false;
    }
}
