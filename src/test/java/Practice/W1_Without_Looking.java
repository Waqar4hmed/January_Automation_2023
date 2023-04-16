package Practice;

import java.util.ArrayList;

public class W1_Without_Looking {
    public static void main(String[] args) {

        //create string array list of cities
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Queens");
        cities.add("Manhattan");
        cities.add("Brooklyn");
        cities.add("Bronx");
        cities.add("Staten Island");

        //create integer array list of ranks
        ArrayList<Integer> rank = new ArrayList<>();
        rank.add(1);
        rank.add(2);
        rank.add(3);
        rank.add(4);
        rank.add(5);

        //create for loop of cities and their rank
        for (int i = 0; i < cities.size(); i++) {
            System.out.println(rank.get(i) + " " + cities.get(i));
        }//end of for loop

        //create String linear array of continents
        String[] continents = new String[]{"North America", "South America", "Asia", "Europe", "Russia"};

        //create integer linear array of the continent's rank
        int[] rank2 = new int[]{1, 2, 3, 4, 5};

        //create while loop of continents and their rank
        int i = 0;
        while (i < continents.length) {
            System.out.println(rank2[i] + " " + continents[i]);
            i++;
        }//end of while loop

    }//end of main
}//end of class
