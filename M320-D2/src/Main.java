public class Main {
    public static void main(String[] args) {
        Class school1 = new Class("Math Class");

        Student student1 = new Student("Student1", school1);
        Student student2 = new Student("Student2", school1);
        Student student3 = new Student("Student3", school1);

        student1.addTest(new Test(80, 100)); // Added maxPoints parameter
        student2.addTest(new Test(80, 100));
        student3.addTest(new Test(80, 100));

        student1.addTest(new Test(40, 100));
        student2.addTest(new Test(40, 100));
        student3.addTest(new Test(40, 100));

        student1.addTest(new Test(100, 100));
        student2.addTest(new Test(100, 100));
        student3.addTest(new Test(100, 100));

        school1.addStudent(student1);
        school1.addStudent(student2);
        school1.addStudent(student3);

        for (Student student : school1.getStudents()) {
            System.out.println("Average Grade for " + student.getName() + ": " +
                    student.getAverageGrade());
        }

        System.out.println("Class Average: " + school1.getAverage());
    }
}
