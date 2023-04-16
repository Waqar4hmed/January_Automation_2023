package ActionItems;

public class W2_AI2_Pt1 {

    public static void main(String[] args) {

        //using multiple conditional statements, when grade is between 90-100, print out statement should be, grade is an A, and so on and so on
        int grade = 65;

        if (grade <= 100 && grade >= 90) {
            System.out.println("Student's grade is a A");
        } else if (grade < 90 && grade >= 80) {
            System.out.println("Student's grade in a B");
        } else if (grade < 80 && grade >= 70) {
            System.out.println("Student's grade is a C");
        } else if (grade < 70 && grade >= 60) {
            System.out.println("Student's grade is a D");
        } else {
            System.out.println("Student's grade is a F");
        }//end of multiple conditional statements

    }//end of main

}//end of class
