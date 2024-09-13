
public class Student {
    private String name = new String();
    private ArrayList<Test> tests = new ArrayList<Test>();
    private Class studentClass;

    public Student(String studentName, Class studentsClass) {
        name = studentName;
        studentClass = studentsClass;
    }

    public String getName() {
        return name;
    }

    public void setName(String studentName) {
        name = studentName;
    }

    public float getAverageGrade() {
        float grades;

        for (Test test : tests) {
            grades =+ test.calculateGrade();
        }

        return grades / tests.size();
    }

    public void addTest(Test test) {
        tests.add(test);
    }

    public ArrayList<Test> getTests() {
        return tests;
    }

    public void setStudentClass(Class studentClass) {
        studentClass = studentClass;
    }

    public Class getStudentClass() {
        return studentClass;
    }
}