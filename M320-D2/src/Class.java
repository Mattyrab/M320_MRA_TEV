
public class Class {

    private String name;
    private ArrayList<Student> students;

    public Class(String className) {
        name = className;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        if students.size() < 20 {
            students.add(student);
        }
        else {
            System.out.println("Class is full");
        }
    }

    public float getAverage() {

    }
}