package Lesson5;

public class Employee {
    public String name;
    public String surname;
    public String patronym;
    public String position;
    protected String email;
    protected String phoneNumber;
    private int salary;
    private int age;

    public Employee(String name, String surname, String patronym, String position, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.surname = surname;
        this.patronym = patronym;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public Employee() {
        System.err.println("Пустая запись сотрудника!");
    }

    public void printInfo() {
        System.out.println("Сотрудник " + surname + " " + name + " " + patronym);
        System.out.println("Должность: " + position);
        System.out.println("Возраст: " + age);
        System.out.println("Заработная плата: " + salary + " руб.");
        System.out.println("Контакты: телефон " + phoneNumber + ", Электронная почта " + email);
        System.out.println();
    }

    public int getAge() {
        return age;
    }
}
