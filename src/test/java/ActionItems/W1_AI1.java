package ActionItems;

import java.util.ArrayList;

public class W1_AI1 {
    public static void main(String[] args) {

        //create an array list for countries using string datatype
        ArrayList<String> countries = new ArrayList<>();
        countries.add("Pakistan");
        countries.add("America");
        countries.add("Bangladesh");
        countries.add("India");

        //create an array list for country code using integer datatype
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(92);
        countryCode.add(1);
        countryCode.add(880);
        countryCode.add(91);

        //create for loop for countries and country code
        for (int i = 0; i < countries.size(); i++) {
            System.out.println("My country is " + countries.get(i) + " and my country code is " + countryCode.get(i));
        }//end of for loop for countries and country code

        //create linear array for region using string datatype
        String[] regions = new String[]{"North America", "South America", "Central America", "Caribbean"};

        //create linear array for regional code using integer datatype
        int[] regionalCode = new int[]{718, 591, 501, 599};

        //create while loop of regions and regional code using while loop
        int i = 0;
        while (i < regions.length) {
            System.out.println("My region is " + regions[i] + " and my regional code is " + regionalCode[i]);
            i++;
        }//end of while loop for regions and regional code

    }//end of main method
}//end of java class
