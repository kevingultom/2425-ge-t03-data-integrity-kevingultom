package academic.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollments;

public class Driver2 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollments> enrollments = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.equals("---")) break;

            String[] parts = input.split("#");
            if (parts.length < 2) continue;

            String command = parts[0];

            if (command.equals("course-add") && parts.length == 5) {
                courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
            } else if (command.equals("student-add") && parts.length == 5) {
                students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
            } else if (command.equals("enrollment-add") && parts.length == 5) {
                String courseId = parts[1];
                String studentId = parts[2];

                int i = 0;
                for (; i < courses.size(); i++) {
                    if (courses.get(i).getId().equals(courseId)) break;
                }
                if (i == courses.size()) {
                    System.out.println("invalid course|" + courseId);
                    continue;
                }

                i = 0;
                for (; i < students.size(); i++) {
                    if (students.get(i).getId().equals(studentId)) break;
                }
                if (i == students.size()) {
                    System.out.println("invalid student|" + studentId);
                    continue;
                }

                enrollments.add(new Enrollments(courseId, studentId, parts[3], parts[4], "None"));
            }
        }

        courses.sort((c1, c2) -> c1.getId().compareTo(c2.getId()));

        for (Course course : courses) System.out.println(course);
        for (Student student : students) System.out.println(student);
        for (Enrollments enrollment : enrollments) System.out.println(enrollment);

        scanner.close();
    }
}
