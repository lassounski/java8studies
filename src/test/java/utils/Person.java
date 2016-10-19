package utils;

public class Person {
    final String name;
    final int age;
    final String phome;

    public Person(String name, int age, String phome) {
        this.name = name;
        this.age = age;
        this.phome = phome;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getPhome() {
        return phome;
    }

    public int ageDifference(Person p) {
        return this.age - p.getAge();
    }

    @Override
    public String toString() {
        return String.format("%s - %d years old - Phone: %s", name, age, phome);
    }

    public Character getNameFirstChar() {
        return name.charAt(0);
    }
}