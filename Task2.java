import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of subjects... ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + " (out of 100)... ");
            marks[i] = scanner.nextInt();
        }

        int totalMarks = calculateTotalMarks(marks);

        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

        char grade = calculateGrade(averagePercentage);

        System.out.println("\nResults = ");
        System.out.println("Total Marks = " + totalMarks);
        System.out.println("Average Percentage = " + averagePercentage + "%");
        System.out.println("Grade = " + grade);

        scanner.close();
    }

    public static int calculateTotalMarks(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    public static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    public static char calculateGrade(double averagePercentage) {
        if (averagePercentage >= 85) {
            return 'O';
        } else if (averagePercentage >= 75) {
            return 'A';
        } else if (averagePercentage >= 55) {
            return 'B';
        } else if (averagePercentage >= 35) {
            return 'C';
        } else {
            return 'F';
        }
    }
}