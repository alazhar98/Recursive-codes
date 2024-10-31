import java.util.*;


class Subject {
    String name;
    String teacher;
    int creditHours;
    double marks;
    String grade;
    String comments;

    public Subject(String name, String teacher, int creditHours, String grade, double marks, String comments) {
        this.name = name;
        this.creditHours = creditHours;
        this.teacher = teacher;
        this.grade = grade;
        this.comments = comments;
        this.marks = marks;
    }

}

class Student{
    String id ;
    String name ;
    int grade;
    int age ;

    HashMap<String, Subject> subjects;

    public Student(String id, String name, int grade, int age) {
        this.name=name;
        this.grade=grade;
        this.age=age;
        this.id=id ;

    }
}

class School{
    String name;
    String address ;
    HashMap<String, Student> students;

    public School(String name, String address) {
        this.name=name ;
        this.address=address;
        this.students=new HashMap<>();
    }
}

public class SchoolSystem{
    private static HashMap<String, School> schools = new HashMap<>();

    public static void addSchool(String name , String address){
        schools.put(name, new School(name,address));
    }
    public static void addStudent(String schoolName, String studentId, String name, int grade, int age){
        if (!schools.containsKey(schoolName)){
            System.out.println("there is no School with this name ");
            return;
        }

        Student student= new Student(studentId,name,grade,age);
        schools.get(schoolName).students.put(studentId,student);


    }
    public static void addSubject(String schoolName , String studentId, String subjectName, String teacher, int creditHours, double marks, String grade, String comments){
        if (!schools.containsKey(schoolName) || !schools.get(schoolName).students.containsKey(studentId)) {
            System.out.println("There is no student or There is no School");
            return;
        }
        Subject subject = new Subject(subjectName, teacher, creditHours, marks, grade, comments);
        schools.get(schoolName).students.get(studentId).subjects.put(subjectName,subject);
    }


}