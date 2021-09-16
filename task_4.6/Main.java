public class Main {
    public static void main(String[] args) {
        Person valera=new Person("Валера","Иванов",69,null,null);
        Person olga = new Person("Ольга","Иванова",67,null,null);
        Person oleg = new Person("Олег","Петров",65,null,null);
        Person jula = new Person("Юля","Петрова",67,null,null);
        Person alex = new Person("Алексей","Иванов",37,olga,valera);
        Person eva  = new Person("Ева","Иванова",37,jula,oleg);
        Person gosha= new Person("Гоша","Иванов",10,eva,alex);
        //System.out.println("Мама Алексея: "+alex.getMother().getName());
        //System.out.println("Бабушка Гоши: "+gosha.getMother().getMother().getName());
        System.out.println("Меня зовут "+gosha.getName()+" ,имя моей мамы "+gosha.getMother().getName()
        +" ,имя папы "+gosha.getFather().getName()+"."+" У меня две бабушки, бабушка "
        +gosha.getMother().getMother().getName()+" и "+gosha.getFather().getMother().getName()
        +". И у меня два деда, деда "+gosha.getMother().getFather().getName()+" и имя второго деда "
        +gosha.getFather().getFather().getName()+".");

    }
}

class Person{
    private String name;
    private String lastname;
    private int age;
    private int hp = 100;
    private Person mother;
    private Person father;
    public Person(String name, String lastname, int age, Person mother, Person father){
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.mother = mother;
        this.father = father;
    }
    public String getName() {
        return this.name;
    }
    public int getHp(){
        return this.hp;
    }
    public Person getMother(){
        return this.mother;
    }
    public Person getFather(){
        return this.father;
    }
    public void setHp(int hp){
        if (this.hp+hp>100) this.hp = 100;
        else this.hp = this.hp + hp;
    }
}
