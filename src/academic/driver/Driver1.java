package academic.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import academic.model.Course;
import academic.model.Student;
import academic.model.Enrollments;

/**
 * @author 12S23001-Kevin Gultom
 * @author 12S23010-Tiffani Butar-butar
 */
public class Driver1 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollments> enrollments = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String input = scanner.nextLine().trim();
            if (input.equals("---")) {
                break;
            }

            String[] parts = input.split("#");
            if (parts.length < 2) {
                continue;
            }

            String command = parts[0];
            
            switch (command) {
                case "course-add":
                    if (parts.length == 5) {
                        courses.add(new Course(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    }
                    break;
                case "student-add":
                    if (parts.length == 5) {
                        students.add(new Student(parts[1], parts[2], Integer.parseInt(parts[3]), parts[4]));
                    }
                    break;
                case "enrollment-add":
                    if (parts.length == 5) {
                        enrollments.add(new Enrollments(parts[1], parts[2], parts[3], parts[4], "None"));
                    }
                    break;
                default:
                    break;
            }
        }

        courses.sort((course1, course2) -> course1.getId().compareTo(course2.getId()));

        for (int i = 0; i < courses.size(); i++) {
            System.out.println(courses.get(i));
        }

        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        for (int i = 0; i < enrollments.size(); i++) {
            System.out.println(enrollments.get(i));
        }

        scanner.close();
    }
}