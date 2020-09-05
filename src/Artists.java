/* Class: CISC 3130
 * Section: MY9
 * Name: Anthony Tlatenchi
 */

import java.io.PrintStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Artists {

  /*
  The main program below instantiates a array of strings called names
  it then goes on to call the different methods throughout the program using
  the array of names.
  */

    public static void main(String[] args) throws Exception {

        String[] names = new String[50];

        createArray(names);

        sort(names);

        printArray(names);

    }

    /*
    The method "createArray" is used to read through the csv file and get the
    elements of the file we need which in this case are the names of the artist
    and enters those names into the array of names.
     */

    public static void createArray(String[] names) {
        int i = 0;

        try {
            Scanner sc = new Scanner(new File("Viral50 - Week of 08272020.txt"));
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] lineArray = line.split(",");
                names[i] = lineArray[2];
                i++;

            }

        } catch (FileNotFoundException e) {
            System.out.println("File Read Error");
        }

    }

      /*
      The method "sort" takes the array of names and alphabetically sorts them
      so theres a bit more organization.
      */

    public static void sort(String[] names) {
        Collections.sort(Arrays.asList(names), String.CASE_INSENSITIVE_ORDER);

    }

    /*
     The method "printArray" then takes the sorted array and counts the number
     of times the name of an artist appears in the array and also removes the
     duplicates of that name and it finally print it into a output file.
    */

    public static void printArray(String[] names) throws Exception {
        PrintStream ps = new PrintStream("Artist-WeekOf08272020.txt");
        for (int i = 0; i < names.length; i++) {
            int numOccurrences = Collections.frequency(Arrays.asList(names), names[i]);
            if (numOccurrences > 1) {
                names = Arrays.stream(names).distinct().toArray(String[]::new);
            }

            ps.println(names[i]);
            ps.println(numOccurrences);

        }
    }

}
