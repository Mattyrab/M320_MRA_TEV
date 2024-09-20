public class Main {
    public static void main(String[] args) {
        Class schoolClass = new Class("Math Class");

        Student student1 = new Student("Student1");
        Student student2 = new Student("Student2");
        Student student3 = new Student("Student3");

        student1.addTest(new Test(80, 100)); // Added maxPoints parameter
        student2.addTest(new Test(80, 100));
        student3.addTest(new Test(80, 100));

        student1.addTest(new Test(40, 100));
        student2.addTest(new Test(40, 100));
        student3.addTest(new Test(40, 100));

        student1.addTest(new Test(100, 100));
        student2.addTest(new Test(100, 100));
        student3.addTest(new Test(100, 100));

        schoolClass.addStudent(student1);
        schoolClass.addStudent(student2);
        schoolClass.addStudent(student3);

        for (Student student : schoolClass.getStudents()) {
            System.out.println("Average Grade for " + student.getName() + ": " +
                    student.getAverageGrade());
        }

        System.out.println("Class Average: " + schoolClass.getAverage());
    }
}
