import java.util.*;
class Subject {
    String name;
    String teacher ;
    int creditHours;
    double marks;
    String grade;
    String comments;

    public Subject(String name,String teacher,int creditHours,String grade,  double marks,  String comments) {
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
