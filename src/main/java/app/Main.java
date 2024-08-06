package app;

import app.managemodules.ManageCourses;
import app.managemodules.ManageGrades;
import app.managemodules.ManageRegistrations;
import app.managemodules.ManageStudents;
import app.persistence.configDb.MySqlConfig;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Manage Courses");
            System.out.println("2. Manage Registrations");
            System.out.println("3. Manage Students");
            System.out.println("4. Manage Grades");
            System.out.println("5. Exit");
            System.out.println("6. Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    new ManageCourses().run();
                    break;
                case 2:
                    new ManageRegistrations().run();
                    break;
                case 3:
                    new ManageStudents().run();
                    break;
                case 4:
                    new ManageGrades().run();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    MySqlConfig.closeConnection();
                    return;
                default:
                    System.out.println("Invalid option.");
            }

        }

    }


}