package 面试;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class test {

    public static void main(String[] args) {
        Person s1 = new Person("小明", 12);
        Person s2 = new Person("小红", 16);
        Person s3 = new Person("小白", 14);
        Person s4 = new Person("小黄", 13);
        ArrayList<Person> s = new ArrayList<>();
        s.add(s1);
        s.add(s2);
        s.add(s3);
        s.add(s4);
        Collections.sort(s, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        for (Person person : s) {
            System.out.println(person);
        }
    }
}