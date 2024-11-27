import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.print("How many students are there? ");
        int studentCount = inputScanner.nextInt();
        inputScanner.nextLine();

        String[] studentNames = new String[studentCount];
        double[][] studentScores = new double[studentCount][];
        double[] averageScores = new double[studentCount];
        char[] grades = new char[studentCount];

        for (int i = 0; i < studentCount; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            studentNames[i] = inputScanner.nextLine();

            System.out.print("How many assignments did " + studentNames[i] + " have? ");
            int assignments = inputScanner.nextInt();
            studentScores[i] = new double[assignments];

            double totalScore = 0;
            for (int j = 0; j < assignments; j++) {
                System.out.print("Enter score for assignment " + (j + 1) + ": ");
                studentScores[i][j] = inputScanner.nextDouble();
                totalScore += studentScores[i][j];
            }

            averageScores[i] = totalScore / assignments;

            if (averageScores[i] >= 90) {
                grades[i] = 'A';
            } else if (averageScores[i] >= 80) {
                grades[i] = 'B';
            } else if (averageScores[i] >= 70) {
                grades[i] = 'C';
            } else if (averageScores[i] >= 60) {
                grades[i] = 'D';
            } else {
                grades[i] = 'F';
            }

            inputScanner.nextLine();
        }

        System.out.println("\nStudent Grade Summary:");
        for (int i = 0; i < studentCount; i++) {
            System.out.println("Name: " + studentNames[i]);
            System.out.println("Average Score: " + averageScores[i]);
            System.out.println("Grade: " + grades[i]);
            System.out.println("---------------------------");
        }

        double classTotal = 0;
        double highestAverage = averageScores[0];
        double lowestAverage = averageScores[0];

        for (double avg : averageScores) {
            classTotal += avg;
            if (avg > highestAverage) {
                highestAverage = avg;
            }
            if (avg < lowestAverage) {
                lowestAverage = avg;
            }
        }

        double classAverage = classTotal / studentCount;
        System.out.println("Class Average: " + classAverage);
        System.out.println("Highest Average: " + highestAverage);
        System.out.println("Lowest Average: " + lowestAverage);

        inputScanner.close();
    }
}
