package app.managemodules;

import app.controllers.RegistrationController;
import app.entities.Registration;

import java.util.Scanner;

public class ManageRegistrations {

    private RegistrationController registrationController = new RegistrationController();

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Create Registration");
            System.out.println("2. Delete Registration");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter course ID to register");
                        int courseId = scanner.nextInt();
                        System.out.println("Enter the student ID to register");
                        int studentId = scanner.nextInt();
                        scanner.nextLine();

                        Registration registration = new Registration(courseId, studentId);
                        registrationController.create(registration);
                        System.out.println("Registration created.");
                    } catch (Exception e) {
                        System.out.println("Error creating registration: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.println("Enter registration ID to delete");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        registrationController.delete(id);
                        System.out.println("Registration deleted.");
                    } catch (Exception e) {
                        System.out.println("Error deleting registration: " + e.getMessage());
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
