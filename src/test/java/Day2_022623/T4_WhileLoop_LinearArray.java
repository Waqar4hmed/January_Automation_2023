package Day2_022623;

public class T4_WhileLoop_LinearArray {
    public static void main(String[] args) {
        //create a linear array of countries
        String[] countries = new String[]{"USA", "Canada", "Bangladesh", "Argentina"};
        //creat a linear array
        int[] areaCode = new int[]{111, 222, 333, 444};

        //create a while loop
        int i = 0;
        while (i < countries.length) {
            System.out.println("Country is " + countries[i] + " and area code is " + areaCode[i]);

            i = i + 1; //you can also write i++
        }//end of while loop

    }//end of main method
}//end of java class
