import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;


public class GPACalculator {
    public static void main(String[] args) {
        System.out.println("Welcome to your GPA Calculator");

        HashMap<String, Double> grades = new HashMap<>();

        grades.put("A", 4.0);
        grades.put("B", 3.0);
        grades.put("C", 2.0);
        grades.put("D", 1.0);
        grades.put("F", 0.0);

        Scanner read = new Scanner(System.in);
        System.out.println("Enter the number of courses taken: ");
        int numOfCourses = read.nextInt();
        read.nextLine(); // Consume the newline character left by nextInt()

        HashMap<String, Double> courseAndCredit = new HashMap<>();
        for (int i = 1; i <= numOfCourses; i++) {
            System.out.println("Enter the name of course " + i + ": ");
            String courseName = read.nextLine();
            System.out.println("Enter the number of credit hours for " + courseName + ": ");
            Double creditHour = read.nextDouble();
            read.nextLine(); // Consume the newline character left by nextDouble()
            courseAndCredit.put(courseName, creditHour);
        }
		read.nextLine();
		
        Set<String> courses = courseAndCredit.keySet();
		Double totalGrade = 0.0;
		for (String course : courses) {
			System.out.println("Enter your grade for " + course + ": ");
			String grade = read.nextLine();
			Double gradeForEach = grades.get(grade) * courseAndCredit.get(course);
			totalGrade += gradeForEach;
		}
		
		Double totalCreditHours = 0.0;
		for (String course : courses) {
			totalCreditHours += courseAndCredit.get(course);
		}
		
		Double GPA = totalGrade / totalCreditHours;
		DecimalFormat decimalFormat = new DecimalFormat("#.#");
		String roundedGPA = decimalFormat.format(GPA);
		
		if (GPA == 4.0) {
			System.out.println("Your GPA is " + roundedGPA + ". Yayy! Congrats!");
		} else {
			System.out.println("Your GPA is " + roundedGPA);
		}
    }
}
