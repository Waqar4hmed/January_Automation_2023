package Day3_030423;

public class T4_Split {
    public static void main(String[] args) {

        //declare a single string variable
        String message = "My name is john";
        //print out only John from the string above
        String[] arrayMessage = message.split(" ");
        System.out.println("Result: " + arrayMessage[3]);

    }//end of main
}//end of class
