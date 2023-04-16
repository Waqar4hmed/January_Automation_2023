package Practice;

public class W2_Practice {
    public static void main(String[] args) {
        String[] fruits = new String[]{"Apple", "Orange", "Strawberry", "Grape"};
        int[] numbers = new int[]{1, 2, 3, 4};

        for (int i = 0; i < fruits.length; i++) {

            if (fruits[i] == "Orange" || fruits[i] == "Strawberry") {
                System.out.println(fruits[i] + " " + numbers[i]);
            }//end of conditions

            //another way of writing the code above
            /*
            if (fruits[i] == "Orange") {
                System.out.println(fruits[i] + " " + numbers[i]);
            } else if (fruits[i] == "Strawberry") {
                System.out.println(fruits[i] + " " + numbers[i]);
            }//end of conditions

             */

        }//end of loop

    }//end of main
}//end of class
