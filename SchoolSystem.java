import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SchoolSystem{

    public static void main(String[] args){
        // hashMap for school
        Map<String, Map<String, Object>> schools = new HashMap<>();

        schools.put("School A", createSchool("School A", "123 Main St"));
        schools.put("School B", createSchool("School B", "456 Elm St"));
        schools.put("School C", createSchool("School C", "789 Oak St"));
        schools.put("School D", createSchool("School D", "101 Pine St"));
        schools.put("School E", createSchool("School E", "202 Maple St"));
        for (int schoolIndex = 1; schoolIndex <= 5; schoolIndex++) {
            String schoolName = "School " + (char) ('A' + schoolIndex - 1);
            String address = schoolIndex + " Main St";

            // Each school has a list of students
            List<Map<String, Object>> students = new ArrayList<>();

            for (int studentIndex = 1; studentIndex <= 5; studentIndex++) {
                Map<String, Object> student = new HashMap<>();
                student.put("ID", studentIndex);
                student.put("Name", "Student " + studentIndex);
                student.put("Grade", "Grade " + (schoolIndex + 5));
                student.put("Age", 15 + studentIndex);

                // ArrayList for subject
                List<Map<String, Object>> subjects = new ArrayList<>();
                for (int subjectIndex = 1; subjectIndex <= 5; subjectIndex++) {
                    Map<String, Object> subject = new HashMap<>();
                    subject.put("SubjectName", "Subject " + subjectIndex);
                    subject.put("TeacherName", "Teacher " + subjectIndex);
                    subject.put("CreditHours", 3);
                    subject.put("Marks", 80 + subjectIndex);
                    subject.put("Grade", "A");
                    subject.put("Comments", "Good");

                    subjects.add(subject);
                }
                student.put("Subjects", subjects);
                // adding every student to students list
                students.add(student);
            }

            // hasMap for school information
            Map<String, Object> schoolInfo = new HashMap<>();
            schoolInfo.put("Address", address);
            schoolInfo.put("Students", students);
            schools.put(schoolName, schoolInfo);
        }

        // adding school information for every school
        for (Map.Entry<String, Map<String, Object>> entry : schools.entrySet()) {
            String schoolName = entry.getKey();
            Map<String, Object> schoolInfo = entry.getValue();
            System.out.println("School: " + schoolName + " (" + schoolInfo.get("Address") + ")");
            System.out.println("Students:");

            List<Map<String, Object>> students = (List<Map<String, Object>>) schoolInfo.get("Students");
            for (Map<String, Object> student : students) {
                int totalMarks = 0;
                List<Map<String, Object>> subjects = (List<Map<String, Object>>) student.get("Subjects");

                //calculate the totalMarks for every student
                for (Map<String, Object> subject : subjects) {
                    totalMarks += (int) subject.get("Marks");
                }
                // calculate the every marks for every student
                double averageMarks = (double) totalMarks / subjects.size();
                System.out.println(student.get("ID") + ": " + student.get("Name") + " | Average Marks: " + averageMarks);
            }
            System.out.println();
        }
    }
}