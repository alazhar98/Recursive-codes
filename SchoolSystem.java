import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SchoolSystem {

    public static void main(String[] args) {
        // HashMaps for schools and students
        Map<String, Map<String, Object>> schools = new HashMap<>();
        initializeSchools(schools);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Search by Student Name");
            System.out.println("2. Search by School Name");
            System.out.println("3. Search by Subject Name");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    searchByStudent(schools, studentName);
                    break;
                case 2:
                    System.out.print("Enter school name: ");
                    String schoolName = scanner.nextLine();
                    searchBySchool(schools, schoolName);
                    break;
                case 3:
                    System.out.print("Enter subject name: ");
                    String subjectName = scanner.nextLine();
                    searchBySubject(schools, subjectName);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initializeSchools(Map<String, Map<String, Object>> schools) {
        // Adding schools with their addresses and unique students
        schools.put("School A", createSchool("School A", "muscat"));
        schools.put("School B", createSchool("School B", "alrustaq"));
        schools.put("School C", createSchool("School C", "fanja"));
        schools.put("School D", createSchool("School D", "salalah"));
        schools.put("School E", createSchool("School E", "sohar"));
    }

    private static void searchByStudent(Map<String, Map<String, Object>> schools, String studentName) {
        boolean found = false;
        for (Map.Entry<String, Map<String, Object>> entry : schools.entrySet()) {
            List<Map<String, Object>> students = (List<Map<String, Object>>) entry.getValue().get("Students");
            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    System.out.println("Details for student " + studentName + ":");
                    System.out.printf("ID: %d, Grade: %s, Age: %d%n", student.get("ID"), student.get("Grade"), student.get("Age"));
                    System.out.println("Subjects and Marks:");
                    List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                    int totalMarks = 0;

                    for (Map<String, Object> subject : subjects) {
                        int marks = (int) subject.get("Marks");
                        totalMarks += marks;
                        System.out.printf(" - %s: %d marks%n", subject.get("SubjectName"), marks);
                    }

                    double averageMarks = (double) totalMarks / subjects.size();
                    System.out.printf("Average Marks: %.2f%n", averageMarks);
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println("Student " + studentName + " not found.");
        }
    }

    private static void searchBySchool(Map<String, Map<String, Object>> schools, String schoolName) {
        Map<String, Object> schoolInfo = schools.get(schoolName);
        if (schoolInfo != null) {
            System.out.println("School: " + schoolName + " (" + schoolInfo.get("Address") + ")");
            System.out.println("Students:");
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");
            for (Map<String, Object> student : students) {
                System.out.printf("%d: %s%n", student.get("ID"), student.get("Name"));
            }
        } else {
            System.out.println("School " + schoolName + " not found.");
        }
    }

    private static void searchBySubject(Map<String, Map<String, Object>> schools, String subjectName) {
        boolean found = false;
        for (Map.Entry<String, Map<String, Object>> entry : schools.entrySet()) {
            List<Map<String, Object>> students = (List<Map<String, Object>>) entry.getValue().get("Students");
            for (Map<String, Object> student : students) {
                List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                for (Map<String, Object> subject : subjects) {
                    if (subject.get("SubjectName").equals(subjectName)) {
                        System.out.printf("Student: %s from %s scored %d in %s%n",
                                student.get("Name"), entry.getKey(), subject.get("Marks"), subjectName);
                        found = true;
                    }
                }
            }
        }
        if (!found) {
            System.out.println("Subject " + subjectName + " not found.");
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
