import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class SchoolSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Object>> schools = new HashMap<>();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add School");
            System.out.println("2. Add Student to School");
            System.out.println("3. Add Subject to Student");
            System.out.println("4. Display Schools and Students");
            System.out.println("5. Retrieve Marks for a Student in a Subject");
            System.out.println("6. Calculate Average Marks for a Student");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addSchools(schools, scanner);
                    break;
                case 2:
                    addStudents(schools, scanner);
                    break;
                case 3:
                    addSubjects(schools, scanner);
                    break;
                case 4:
                    displaySchools(schools);
                    break;
                case 5:
                    retrieveMarks(schools, scanner);
                    break;
                case 6:
                    calculateAverageMarks(schools, scanner);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void addSchools(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("How many schools do you want to add? ");
        int numberOfSchools = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfSchools; i++) {
            System.out.print("Enter school name: ");
            String schoolName = scanner.nextLine();
            System.out.print("Enter school address: ");
            String schoolAddress = scanner.nextLine();

            Map<String, Object> schoolInfo = new HashMap<>();
            schoolInfo.put("Address", schoolAddress);
            schoolInfo.put("Students", new ArrayList<Map<String, Object>>());
            schools.put(schoolName, schoolInfo);
            System.out.println("School added successfully.");
        }
    }

    private static void addStudents(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name to add students: ");
        String schoolName = scanner.nextLine();

        Map<String, Object> schoolInfo = schools.get(schoolName);
        if (schoolInfo != null) {
            System.out.print("How many students do you want to add? ");
            int numberOfStudents = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < numberOfStudents; i++) {
                System.out.print("Enter student name: ");
                String studentName = scanner.nextLine();
                System.out.print("Enter student ID: ");
                int studentID = scanner.nextInt();
                System.out.print("Enter student grade: ");
                String studentGrade = scanner.next();
                System.out.print("Enter student age: ");
                int studentAge = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                Map<String, Object> student = createStudent(studentID, studentName, studentGrade, studentAge);
                ((List<Map<String, Object>>) schoolInfo.get("Students")).add(student);
                System.out.println("Student added successfully.");
            }
        } else {
            System.out.println("School not found.");
        }
    }

    private static void addSubjects(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student name to add subjects: ");
            String studentName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    System.out.print("How many subjects do you want to add? ");
                    int numberOfSubjects = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    for (int i = 0; i < numberOfSubjects; i++) {
                        System.out.print("Enter subject name: ");
                        String subjectName = scanner.nextLine();
                        System.out.print("Enter marks for " + subjectName + ": ");
                        int marks = scanner.nextInt();
                        scanner.nextLine(); // Consume newline

                        List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                        subjects.add(createSubject(subjectName, "Teacher Name", 3, marks, "A", "Good"));
                        System.out.println("Subject added successfully.");
                    }
                    return; // Exit after adding subjects for the student
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static void displaySchools(Map<String, Map<String, Object>> schools) {
        for (Map.Entry<String, Map<String, Object>> entry : schools.entrySet()) {
            String schoolName = entry.getKey();
            System.out.println("School: " + schoolName + " (Address: " + entry.getValue().get("Address") + ")");
            List<Map<String, Object>> students = (List<Map<String, Object>>) entry.getValue().get("Students");
            for (Map<String, Object> student : students) {
                System.out.printf("  Student: %s (ID: %d, Grade: %s, Age: %d)%n", student.get("Name"), student.get("ID"), student.get("Grade"), student.get("Age"));
                List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                for (Map<String, Object> subject : subjects) {
                    System.out.printf("    Subject: %s, Marks: %d%n", subject.get("SubjectName"), subject.get("Marks"));
                }
            }
        }
    }

    private static Map<String, Object> createStudent(int id, String name, String grade, int age) {
        Map<String, Object> student = new HashMap<>();
        student.put("ID", id);
        student.put("Name", name);
        student.put("Grade", grade);
        student.put("Age", age);
        student.put("Subjects", new ArrayList<Map<String, Object>>());
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

    private static void retrieveMarks(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    System.out.print("Enter subject name: ");
                    String subjectName = scanner.nextLine();
                    List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");

                    for (Map<String, Object> subject : subjects) {
                        if (subject.get("SubjectName").equals(subjectName)) {
                            System.out.printf("Marks for %s in %s: %d%n", studentName, subjectName, subject.get("Marks"));
                            return;
                        }
                    }
                    System.out.println("Subject not found.");
                    return;
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("School not found.");
        }
    }

    private static void calculateAverageMarks(Map<String, Map<String, Object>> schools, Scanner scanner) {
        System.out.print("Enter school name: ");
        String schoolName = scanner.nextLine();
        Map<String, Object> schoolInfo = schools.get(schoolName);

        if (schoolInfo != null) {
            System.out.print("Enter student name: ");
            String studentName = scanner.nextLine();
            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");

            for (Map<String, Object> student : students) {
                if (student.get("Name").equals(studentName)) {
                    List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");
                    int totalMarks = 0;
                    int subjectCount = subjects.size();

                    for (Map<String, Object> subject : subjects) {
                        totalMarks += (int) subject.get("Marks");
                        System.out.printf("Subject: %s, Marks: %d%n", subject.get("SubjectName"), subject.get("Marks"));
                    }

                    if (subjectCount > 0) {
                        double average = (double) totalMarks / subjectCount;
                        System.out.printf("Average Marks for %s: %.2f%n", studentName, average);
                    } else {
                        System.out.println("No subjects found for the student.");
                    }
                    return;
                }
            }
            System.out.println("Student not found.");
        } else {
            System.out.println("School not found.");
        }
    }
}
