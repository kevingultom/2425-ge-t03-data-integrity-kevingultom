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
public class Driver2 {

    public static void main(String[] _args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        List<Enrollments> enrollments = new ArrayList<>();
        List<String> errors = new ArrayList<>(); // Menyimpan pesan kesalahan

        // Membaca input hingga menemukan '---'
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
                        String courseId = parts[1], studentId = parts[2];

                        // Validasi student
                        if (students.stream().noneMatch(s -> s.getId().equals(studentId))) {
                            errors.add("invalid student|" + studentId); // Menyimpan pesan kesalahan
                        } 
                        // Validasi course
                        else if (courses.stream().noneMatch(c -> c.getId().equals(courseId))) {
                            errors.add("invalid course|" + courseId); // Menyimpan pesan kesalahan
                        }
                        // Jika student dan course valid
                        else {
                            enrollments.add(new Enrollments(courseId, studentId, parts[3], parts[4], "None"));
                        }
                    }
                    break;
                default:
                    break;
            }
        }

        courses.sort((course1, course2) -> course1.getId().compareTo(course2.getId()));
        students.sort((student1, student2) -> student1.getId().compareTo(student2.getId()));

     
        for (String error : errors) {
            System.out.println(error);
        }

        for (Course course : courses) {
            System.out.println(course);
        }

        for (Student student : students) {
            System.out.println(student);
        }

        for (Enrollments enrollment : enrollments) {
            System.out.println(enrollment);
        }

        scanner.close();
    }
}
