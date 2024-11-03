import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolSystem {

    public static void main(String[] args) {
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

                // Calculate total marks for the student
                for (Map<String, Object> subject : subjects) {
                    totalMarks += (int) subject.get("Marks");
                }
                double averageMarks = (double) totalMarks / subjects.size();
                System.out.printf("%d: %s | Average Marks: %.2f%n",
                        student.get("ID"), student.get("Name"), averageMarks);
            }
            System.out.println();
        }
    }

    private static Map<String, Object> createSchool(String schoolName, String address) {
        Map<String, Object> schoolInfo = new HashMap<>();
        schoolInfo.put("Address", address);

        List<Map<String, Object>> students = new ArrayList<>();
        students.add(createStudent(1, "Alazhar", "10", 15, 85, 78, 90));
        students.add(createStudent(2, "Fisal", "10", 16, 76, 82, 88));
        students.add(createStudent(3, "Mohammed", "10", 15, 90, 77, 95));
        students.add(createStudent(4, "Salim", "10", 16, 80, 85, 87));
        students.add(createStudent(5, "Ahmed", "10", 15, 90, 77, 99));

        schoolInfo.put("Students", students);
        return schoolInfo;
    }

    private static Map<String, Object> createStudent(int id, String name, String grade, int age, int mathMarks, int scienceMarks, int artMarks) {
        Map<String, Object> student = new HashMap<>();
        student.put("ID", id);
        student.put("Name", name);
        student.put("Grade", grade);
        student.put("Age", age);

        // Adding subjects for each student with different marks
        List<Map<String, Object>> subjects = new ArrayList<>();
        subjects.add(createSubject("Math", "Mr. Smith", 3, mathMarks, "A", "Good"));
        subjects.add(createSubject("Science", "Ms. Johnson", 4, scienceMarks, "B", "Needs Improvement"));
        subjects.add(createSubject("Art", "Ms. Green", 2, artMarks, "A", "Excellent"));

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
