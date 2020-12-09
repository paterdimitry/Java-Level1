package Lesson5;

public class Main {

    static Employee[] employee = new Employee[5];

    public static void main(String[] args) {
        int ageLimit = 40;

        initEmployeeArray();
        printInfoEmployeeOlderAgeLimit(ageLimit);
    }

    private static void initEmployeeArray() {
        employee[0] = new Employee("Иван", "Васильев", "Анатольевич", "главный инженер", "ivavas@mail.com", "8-910-813-28-82", 60000, 57);
        employee[1] = new Employee("Алексей", "Петров", "Дмитриевич", "инженер-конструктор", "alexalex@gmail.ru", "8-996-966-96-69", 40000, 29);
        employee[2] = new Employee("Дмитрий", "Вьюгин", "Анатольевич", "директор", "dirvygin@mail.by", "8-910-920-93-94", 80000, 48);
        employee[3] = new Employee("Арнольд", "Гауфман", "Ааронович", "главный бухгалтер", "gauffman@yandex.ru", "8-921-634-76-82", 60000, 44);
        employee[4] = new Employee("Стефания", "Шлицерман", "Исааковна", "бухгалтер", "stewany@index.ru", "8-930-354-36-71", 34000, 26);
    }

    private static void printInfoEmployeeOlderAgeLimit(int ageLimit) {
        for (Employee value : employee) {
            if (value.getAge() >= ageLimit) value.printInfo();
        }
    }


}
