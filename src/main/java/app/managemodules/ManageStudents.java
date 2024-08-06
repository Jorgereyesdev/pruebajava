package app.managemodules;

import app.controllers.StudentController;
import app.entities.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageStudents {

    private StudentController studentController = new StudentController();

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while(true) {
            System.out.println("1. Create Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Update Student");
            System.out.println("4. Find Students by Email");
            System.out.println("5. Find All Students");
            System.out.println("6. Find student by ID");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    try {
                        System.out.println("Enter Student name");
                        String name = scanner.nextLine();
                        System.out.println("Enter Student lastname");
                        String lastname = scanner.nextLine();
                        System.out.println("Enter Student email");
                        String email = scanner.nextLine();
                        System.out.println("Enter Student state (true/false)");
                        boolean state = Boolean.parseBoolean(scanner.nextLine());
                        System.out.println("Enter course ID ");
                        int idCourse = scanner.nextInt();
                        System.out.println("Enter grade ID ");
                        int idGrade = scanner.nextInt();
                        Student student = new Student(name, lastname, email, state, idCourse, idGrade);
                        studentController.create(student);
                        System.out.println("Student created successfully.");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error creating student: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter Student ID to delete");
                        int id = scanner.nextInt();

                        studentController.delete(id);
                        System.out.println("Student deleted successfully.");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error deleting student: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Enter Student ID to update");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter Student name");
                        String name = scanner.nextLine();
                        System.out.println("Enter Student lastname");
                        String lastname = scanner.nextLine();
                        System.out.println("Enter Student email");
                        String email = scanner.nextLine();
                        System.out.println("Enter Student state (true/false)");
                        boolean state = Boolean.parseBoolean(scanner.nextLine());

                        Student student = new Student(id, name, lastname, email, state);
                        studentController.update(student);
                        System.out.println("Student updated successfully.");
                        break;
                    } catch (Exception e) {
                        System.out.println("Error updating student: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter Student email");
                    String email = scanner.nextLine();
                    Student student = studentController.getStudentByEmail(email);
                    if(student!= null) {
                        System.out.println(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    List<Student> students = new ArrayList<Student>();
                    students = studentController.findAllStudent(10, 1);
                    for(Student s : students) {
                        System.out.println(s);
                    }
                    break;
                case 6:
                    System.out.println("Enter Student ID");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    Student student2 = studentController.findStudentById(id);
                    if(student2!= null) {
                        System.out.println(student2);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 7:
                    return;
                default:
                    System.out.println("Invalid option.");
                }
            }
        }
}
