import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolSystem {

    public static void main(String[] args) {
        // HashMaps for schools and students
        Map<String, Map<String, Object>> schools = new HashMap<>();

        // Adding schools with their addresses and unique students
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
        if (schoolName.equals("School A")) {
            students.add(createStudent(1, "Alice", "10", 15, 85, 78, 90));
            students.add(createStudent(2, "Bob", "10", 16, 76, 82, 88));
            students.add(createStudent(3, "Charlie", "10", 15, 90, 77, 95));
            students.add(createStudent(4, "David", "10", 16, 80, 85, 87));
            students.add(createStudent(5, "Eva", "10", 15, 90, 77, 99));
        } else if (schoolName.equals("School B")) {
            students.add(createStudent(1, "Frank", "10", 15, 88, 76, 85));
            students.add(createStudent(2, "Grace", "10", 16, 70, 80, 90));
            students.add(createStudent(3, "Hannah", "10", 15, 95, 70, 75));
            students.add(createStudent(4, "Ian", "10", 16, 60, 85, 80));
            students.add(createStudent(5, "Jack", "10", 15, 78, 80, 85));
        } else if (schoolName.equals("School C")) {
            students.add(createStudent(1, "Kate", "10", 15, 92, 81, 88));
            students.add(createStudent(2, "Leo", "10", 16, 70, 90, 84));
            students.add(createStudent(3, "Mia", "10", 15, 85, 75, 95));
            students.add(createStudent(4, "Nina", "10", 16, 88, 80, 90));
            students.add(createStudent(5, "Owen", "10", 15, 77, 82, 78));
        } else if (schoolName.equals("School D")) {
            students.add(createStudent(1, "Paul", "10", 15, 75, 90, 80));
            students.add(createStudent(2, "Quinn", "10", 16, 88, 77, 83));
            students.add(createStudent(3, "Rose", "10", 15, 80, 85, 90));
            students.add(createStudent(4, "Sam", "10", 16, 90, 82, 84));
            students.add(createStudent(5, "Tina", "10", 15, 70, 88, 79));
        } else if (schoolName.equals("School E")) {
            students.add(createStudent(1, "Uma", "10", 15, 91, 89, 95));
            students.add(createStudent(2, "Victor", "10", 16, 84, 82, 90));
            students.add(createStudent(3, "Wendy", "10", 15, 76, 88, 80));
            students.add(createStudent(4, "Xander", "10", 16, 79, 85, 78));
            students.add(createStudent(5, "Yara", "10", 15, 85, 90, 92));
        }

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
