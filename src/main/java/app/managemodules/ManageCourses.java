package app.managemodules;

import app.controllers.CourseController;
import app.entities.Course;

import java.util.Scanner;

public class ManageCourses {

    private CourseController courseController = new CourseController();

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while(true) {
            System.out.println("1. Create Course");
            System.out.println("2. Delete Course");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice) {
                case 1:
                    try {
                        System.out.println("Enter course name");
                        String name = scanner.nextLine();

                        Course course = new Course(name);
                        courseController.create(course);
                        System.out.println("Course created successfully.");
                    } catch (Exception e) {
                        System.out.println("Error creating course: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter course ID to delete");
                        int id = scanner.nextInt();

                        courseController.delete(id);
                        System.out.println("Course deleted successfully.");
                    } catch (Exception e) {
                        System.out.println("Error deleting course: " + e.getMessage());
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }


}
