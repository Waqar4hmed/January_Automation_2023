package Day3_030423;

import java.util.ArrayList;

public class T3_Array_Loop_Conditions {
    public static void main(String[] args) {

        /*
        iterate through list of fruits using Arraylist
        but only print when fruit is apple of grape
        */

        ArrayList<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Strawberry");
        fruits.add("Grape");

        for (int i = 0; i < fruits.size(); i++) {
            /*
            if (fruits.get(i) == "Apple") {
                System.out.println("Fruit: " + fruits.get(i));
            } else if (fruits.get(i) == "Grape") {
                System.out.println("Fruit: " + fruits.get(i));
            }//end of conditions
            */

            //using the OR operator
            if (fruits.get(i) == "Apple" || fruits.get(i) == "Grape") {
                System.out.println("Fruit: " + fruits.get(i));
            }//end of Conditions using OR operator
        }//end of for loop

    }//end of main
}//end of class
