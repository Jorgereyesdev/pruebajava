package app.managemodules;

import app.controllers.GradeController;
import app.entities.Grade;
import app.utils.GradesType;

import java.util.Scanner;

public class ManageGrades {

    private GradeController gradeController = new GradeController();

    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("1. Create Grade");
            System.out.println("2. Update Grade");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.println("Enter the grade");
                        float grade = scanner.nextFloat();
                        System.out.println("Enter description of the grade (QUIZ, EXAM, WORKSHOP)");
                        GradesType description = GradesType.valueOf(scanner.nextLine());
                        System.out.println("Enter course ID");
                        int courseId = scanner.nextInt();
                        scanner.nextLine();
                        Grade createGrade = new Grade(grade, description, courseId);
                        gradeController.create(createGrade);
                        break;
                    } catch (Exception e) {
                        System.out.println("Error creating grade: Invalid input" + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Enter grade ID to update");
                        int id = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Enter the updated grade");
                        float updatedGrade = scanner.nextFloat();

                        System.out.println("Enter updated description of the grade (QUIZ, EXAM, WORKSHOP)");
                        GradesType updatedDescription = GradesType.valueOf(scanner.nextLine());

                        Grade updateGrade = new Grade(updatedGrade, updatedDescription);
                        gradeController.update(updateGrade);

                        break;
                    } catch (Exception e) {
                        System.out.println("Error updating student: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Exit");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
