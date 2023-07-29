package Practice;

import java.util.ArrayList;

public class Interview {

    public static void main(String[] args) {
        ArrayList<String> cities = new ArrayList<>();
        cities.add("New York");
        cities.add("Las Vegas");
        cities.add("Miami");
        cities.add("Albany");

        for (int i = 0; i < cities.size(); i++) {
            if (cities.get(i) == "Miami") {
                System.out.println("Cities: " + cities.get(i));
            }//end of condition statement
        }//end of loop
    }//end of main

}//end of class
