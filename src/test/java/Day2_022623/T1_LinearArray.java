package Day2_022623;

public class T1_LinearArray {
    public static void main(String[] args) {

        //create a list of cities in linear array
        //array count starts from 0 index
        String[] cities = new String[]{"Brooklyn", "Queens", "Manhattan", "Bronx", "Staten Island"};
        //get the count of the list of cities
        System.out.println("Cities count is " + cities.length);
        //print out Brooklyn and Bronx from the list
        //you can use the abbreviation sout to write the command for print statement
        System.out.println("my cities are " + cities[0] + ", " + cities[3]);

        //create a list of zipcode
        int[] zipCode = new int[]{11218, 22222, 33333, 55555};
        //get the count of the list of zipcode
        System.out.println("Zipcode count is " + zipCode.length);
        //print out 11218 and 33333
        System.out.println("My cities are " + zipCode[0] + ", " + zipCode[2]);

    }//end of main
}//end of java class
