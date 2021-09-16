public class Main {
    public static void main(String[] args) {
        Dog dog=new Dog();
        dog.name="Sharik";
        dog.age=10;
        System.out.println(dog.name);
        System.out.println(dog.age);
    }

    public static class Dog{
        String name;
        int age;

        public String getName(){return name;}
        public void setName(String name) {
            this.name = name;
        }
        public int getAge(){return age;}

        public void setAge(int age) {
            this.age = age;
        }
    }

}
