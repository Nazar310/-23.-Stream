import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private int age;
    private double grade;

    public Student(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
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

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', age=" + age + ", grade=" + grade + "}";
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>(List.of(
                new Student("Alice", 21, 4.0),
                new Student("Bob", 23, 3.5),
                new Student("Charlie", 22, 3.8),
                new Student("Diana", 24, 3.9),
                new Student("Eve", 20, 3.7)
        ));

        System.out.println( );

        List<Student> filteredStudents = students.stream()
                .filter(student -> student.getAge() > 22)
                .collect(Collectors.toList());
        System.out.println("Студенти старше 22 років: " + filteredStudents);

        List<String> studentNames = students.stream()
                .map(Student::getName)
                .collect(Collectors.toList());
        System.out.println("Імена студентів: " + studentNames);

        int totalAge = students.stream()
                .map(Student::getAge)
                .reduce(0, Integer::sum);
        System.out.println("Загальний вік студентів: " + totalAge);
    }
}
