import java.util.InputMismatchException;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean continueEnteringMarks = true;

        while (continueEnteringMarks) {
            try {
                int totalSubjects;
                System.out.print("Enter the number of subjects: ");
                totalSubjects = scanner.nextInt();

                if (totalSubjects <= 0) {
                    System.out.println("Number of subjects must be greater than 0.");
                    continue;
                }

                int[] subjectMarks = new int[totalSubjects];
                int totalMarks = 0;

                for (int i = 0; i < totalSubjects; i++) {
                    try {
                        System.out.print("Enter marks obtained in subject " + (i + 1) + ": ");
                        subjectMarks[i] = scanner.nextInt();

                        if (subjectMarks[i] < 0 || subjectMarks[i] > 100) {
                            System.out.println("Marks must be between 0 and 100.");
                            i--; // Retry input for this subject
                            continue;
                        }

                        totalMarks += subjectMarks[i];
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid integer.");
                        scanner.next(); // Clear the input buffer
                        i--; // Retry input for this subject
                    }
                }

                double averagePercentage = (double) totalMarks / (totalSubjects * 100) * 100;

                String grade;
                if (averagePercentage >= 90) {
                    grade = "A";
                } else if (averagePercentage >= 80) {
                    grade = "B";
                } else if (averagePercentage >= 70) {
                    grade = "C";
                } else if (averagePercentage >= 60) {
                    grade = "D";
                } else {
                    grade = "F";
                }

                System.out.println("\nResults:");
                System.out.println("Total Marks: " + totalMarks);
                System.out.println("Average Percentage: " + averagePercentage + "%");
                System.out.println("Grade: " + grade);

                boolean validInput = false;
                while (!validInput) {
                    System.out.print("Do you want to enter marks for another student? (yes/no): ");
                    String continueInput = scanner.next().toLowerCase();
                    if (continueInput.equals("yes")) {
                        validInput = true;
                    } else if (continueInput.equals("no")) {
                        validInput = true;
                        continueEnteringMarks = false;
                    } else {
                        System.out.println("Please enter only 'yes' or 'no'.");
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.next(); // Clear the input buffer
            }
        }

        scanner.close();
    }
}
