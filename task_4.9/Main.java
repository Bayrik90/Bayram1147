/*
Составить генеалогическое древо. У вас должно быть 2 бабушки, 2 дедушки, мама, папа, ребёнок.
Для всех персонажей должен корректно работать метод info()
На экран должно попасть максимум информации.
т.е. для ребенка нужно вывести инфо о родителях, а так же о бабушках и дедушках.*/

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("Ольга", "Иванова", 70, null,null);
        Person person2 = new Person("Александр", "Иванов", 74, null,null);
        Person person3 = new Person("Вера", "Петрова", 65, null, null);
        Person person4 = new Person("Николай", "Петров", 68, null, null);
        Person person5 = new Person("Иван", "Иванов", 38, person1, person2);
        Person person6 = new Person("Ирина", "Иванова", 35, person3, person4);
        Person person7 = new Person("Василий", "Иванов", 12, person6, person5);

        person7.info();
    }
    static class Person{
        private String name;
        private String lastname;
        private int age;
        private Person mother;
        private Person father;
        Person(String name, String lastname, int age, Person mother, Person father){
            this.name = name;
            this.lastname = lastname;
            this.age = age;
            this.mother = mother;
            this.father = father;
        }

        void info(){
            String info = "Меня зовут "+this.name+"\n";


            if(this.mother != null) {
                info += "Мою маму зовут " + this.mother.name + "\n";
                if (this.mother.father != null) info += "Моего дедушку по маминой линии зовут " + this.mother.father.name + "\n";
            }

            if (this.father != null) {
                info += "Моего отца зовут " + this.father.name + "\n";
                if (this.father.mother != null) info += "Мою бабушку по папиной линии зовут " + this.father.mother.name + "\n";
            }
            if(this.father != null){
                info += "Моего отца зовут "+this.father.name+"\n";
                if(this.father.father != null){
                    info += "Моего дедушку по папиной линии зовут "+this.father.father.name+"\n";
                }
                if(this.father.mother != null){
                    info += "Мою бабушку по папиной линии зовут "+this.father.mother.name+"\n";
                }
            }

            System.out.println(info);
        }

        public Person getMother() {
            return mother;
        }

        public Person getFather() {
            return father;
        }

        String getName(){
            return this.name;
        }
        String getLastname(){
            return this.lastname;
        }
        int getAge(){
            return this.age;
        }

}}
