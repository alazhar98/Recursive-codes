import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolSystem{

    public static void main(String[] args){
        // HashMaps for schools and students
        Map<String, Map<String, Object>> schools = new HashMap<>();

        // Adding schools with their addresses
        schools.put("School A", createSchool("School A", "123 muscat"));
        schools.put("School B", createSchool("School B", "456 alrustaq"));
        schools.put("School C", createSchool("School C", "789 fanja"));
        schools.put("School D", createSchool("School D", "101 salalah"));
        schools.put("School E", createSchool("School E", "202 sohar"));

        // Output schools and their students with average marks
        for (Map.Entry<String, Map<String, Object>> entry : schools.entrySet()) {
            String schoolName = entry.getKey();
            Map<String, Object> schoolInfo = entry.getValue();
            System.out.println("School: " + schoolName + " (" + schoolInfo.get("Address") + ")");
            System.out.println("Students:");

            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");
            for (Map<String, Object> student : students) {
                int totalMarks = 0;
                List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");

                for (Map<String, Object> subject : subjects) {
                    totalMarks += (int) subject.get("Marks");
                }
                double averageMarks = (double) totalMarks / subjects.size();
                System.out.println(student.get("ID") + ": " + student.get("Name") + " | Average Marks: " + averageMarks);
            }
            System.out.println();
        }
    }

    private static Map<String, Object> createSchool(String schoolName, String address) {
        Map<String, Object> schoolInfo = new HashMap<>();
        schoolInfo.put("Address", address);

        List<Map<String, Object>> students = new ArrayList<>();
        students.add(createStudent(1, "Alazhar", "10", 15));
        students.add(createStudent(2, "Fisal", "10", 16));
        students.add(createStudent(3, "Mohammed ", "10", 15));
        students.add(createStudent(4, "Salim", "10", 16));
        students.add(createStudent(5, "Ahmed", "10", 15));

        schoolInfo.put("Students", students);
        return schoolInfo;
    }

    private static Map<String, Object> createStudent(int id, String name, String grade, int age) {
        Map<String, Object> student = new HashMap<>();
        student.put("ID", id);
        student.put("Name", name);
        student.put("Grade", grade);
        student.put("Age", age);

        // Adding subjects for each student
        List<Map<String, Object>> subjects = new ArrayList<>();
        subjects.add(createSubject("Math", "Mr. Smith", 3, 85, "A", "Good"));
        subjects.add(createSubject("Science", "Ms. Johnson", 4, 78, "B", "Needs Improvement"));
        subjects.add(createSubject("English", "Mrs. Lee", 2, 90, "A", "Excellent"));
        subjects.add(createSubject("History", "Mr. Brown", 3, 88, "A", "Very Good"));
        subjects.add(createSubject("Art", "Ms. Green", 2, 75, "B", "Average"));

        student.put("Subjects", subjects);
        return student;
    }

    private static Map<String, Object> createSubject(String subjectName, String teacherName, int creditHours, int marks, String grade, String comments) {
        Map<String, Object> subject = new HashMap<>();
        subject.put("SubjectName", subjectName);
        subject.put("TeacherName", teacherName);
        subject.put("CreditHours", creditHours);
        subject.put("Marks", marks);
        subject.put("Grade", grade);
        subject.put("Comments", comments);
        return subject;
    }
}