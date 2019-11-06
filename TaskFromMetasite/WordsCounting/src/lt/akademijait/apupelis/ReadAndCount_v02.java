package lt.akademijait.apupelis;

import java.io.*;
import java.util.*;

/******
 * Solution:
 * 1. Read contents from all files.
 * 2. Join all contents into one.
 * 3. Split into separate words.
 * 4. Filter by first letter into 4 segments.
 * 5. Write into 4 corresponding output files.
 */

public class ReadAndCount_v02 {

    public static void main(String[] args) {

        //Option_01 (user specified path)
        //System.out.println("Please, enter directory path:");
        //Scanner scanner = new Scanner(System.in);
        //String fileLocation = scanner.nextLine().trim();

        //Option_02 ("hardcoded" path)
        String fileLocation = "/home/aidas/Documents/Metasite_Task_01/WordsCounting/TextFiles/";

        File directory = new File(fileLocation);
        File[] list = directory.listFiles();

        printNames(list);

        System.out.println();

        try {
            printAndComputeContent(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //=======================================================================
    //method to print all file names in directory (not necessary, just for clarity)
    public static void printNames(File[] list) {
        System.out.println("Files in directory: ");
        for (int i = 0; i < list.length; i++) {
            if (list[i].isFile()) {
                System.out.println(list[i].getName());
            }
        }
    }

    //=======================================================================
    //method to print and compute contents from all text files
    public static void printAndComputeContent(File[] list) throws IOException {

        ArrayList<String> wordsArrayList = new ArrayList<String>();

        for (int i = 0; i < list.length; i++) {
            String fileName = list[i].getPath();
            BufferedReader br = new BufferedReader(new FileReader(fileName));

            //getting file contents
            String line = null;
            while ((line = br.readLine()) != null) {
                //this out is not necessary, just for clarity
                System.out.println("Content from file " + list[i].getName() + ":  " + line);

                //adding file contents to one general ArrayList (as its size expands dynamically)
                wordsArrayList.add(line);
            }
            System.out.println("------------------------------------------------------------");
        }

        System.out.println("Joined content from all files (to ArrayList): " + wordsArrayList);

        //converting ArrayList list to one general String (otherwise counts occurrences of whole text)
        StringBuilder sb = new StringBuilder();
        for (String s : wordsArrayList) {
            sb.append(s);
            sb.append("\t");
        }
        String veryLongString = sb.toString();
        System.out.println("Converted to one general String: " + veryLongString);

        //splitting String into separated words (as task asks namely for words counting))
        String delimeterChars = "[-.,:()\t ]+";
        String[] wordsSeparated = veryLongString.split(delimeterChars);
        System.out.println("Splitted to String Array: " + Arrays.toString(wordsSeparated));

        //filtering/sorting words by first char and adding to corresponding ArrayList

//        String [] A_TO_G = {"a","b","c","d","e","f","g"};
//        String [] H_TO_N = {"h","i","j","k","l","m","n"};
//        String [] O_TO_U = {"o","p","q","r","s","t","u"};
//        String [] V_TO_Z = {"v","w","x","y","z"};

        char[] A_TO_G = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};
        char[] H_TO_N = {'h', 'i', 'j', 'k', 'l', 'm', 'n'};
        char[] O_TO_U = {'o', 'p', 'q', 'r', 's', 't', 'u'};
        char[] V_TO_Z = {'v', 'w', 'x', 'y', 'z'};

        ArrayList<String> words_a_to_g = new ArrayList<String>();
        ArrayList<String> words_h_to_n = new ArrayList<String>();
        ArrayList<String> words_o_to_u = new ArrayList<String>();
        ArrayList<String> words_v_to_z = new ArrayList<String>();

//        String segmentName = null;  // for naming output files

        //version_01
//        filterByFirstChar1(wordsSeparated, words_a_to_g, "a","b","c","d","e","f","g");
//        filterByFirstChar1(wordsSeparated, words_h_to_n, "h","i","j","k","l","m","n");
//        filterByFirstChar1(wordsSeparated, words_o_to_u, "o","p","q","r","s","t","u" );
//        filterByFirstChar1(wordsSeparated, words_v_to_z, "v","w","x","y","z", "z", "z");

        //version_02, doesn't works (neither with  'String [] A_TO_G' neither with 'char [] A_TO_G')
//        filterByFirstChar2(wordsSeparated, words_a_to_g, A_TO_G);
//        filterByFirstChar2(wordsSeparated, words_h_to_n, H_TO_N);
//        filterByFirstChar2(wordsSeparated, words_o_to_u, O_TO_U);
//        filterByFirstChar2(wordsSeparated, words_v_to_z, V_TO_Z);

        //version_03
        filterByFirstChar3(wordsSeparated, words_a_to_g, A_TO_G);
        filterByFirstChar3(wordsSeparated, words_h_to_n, H_TO_N);
        filterByFirstChar3(wordsSeparated, words_o_to_u, O_TO_U);
        filterByFirstChar3(wordsSeparated, words_v_to_z, V_TO_Z);

        //version_01, doesn't works
//        countOccurrences(words_a_to_g, segmentName);
//        countOccurrences(words_h_to_n, segmentName);
//        countOccurrences(words_o_to_u, segmentName);
//        countOccurrences(words_v_to_z, segmentName);

        //version_02
        countOccurrences(words_a_to_g, "from_a_to_g");
        countOccurrences(words_h_to_n, "from_h_to_n");
        countOccurrences(words_o_to_u, "from_o_to_u");
        countOccurrences(words_v_to_z, "from_v_to_z");
    }

    //=======================================================================
    //method to filter array by first char, version_01
    public static void filterByFirstChar1(String[] stringsFromArray, ArrayList<String> segmentedStringArrayList, String string1, String string2, String string3, String string4, String string5, String string6, String string7) {
        for (int i = 0; i < stringsFromArray.length; i++) {
            if (stringsFromArray[i].toLowerCase().startsWith(string1)
                    || stringsFromArray[i].toLowerCase().startsWith(string2)
                    || stringsFromArray[i].toLowerCase().startsWith(string3)
                    || stringsFromArray[i].toLowerCase().startsWith(string4)
                    || stringsFromArray[i].toLowerCase().startsWith(string5)
                    || stringsFromArray[i].toLowerCase().startsWith(string6)
                    || stringsFromArray[i].toLowerCase().startsWith(string7)) {
                segmentedStringArrayList.add(stringsFromArray[i]);
                //printContentToFile();
                //System.out.println("Strings with char a_to_g: " + wordsSeparated[i]);
            }
        }
    }

    //=======================================================================
    //method to filter array by first char, version_02
    //Method doesn't works (startsWith() doesn't accepts multi chars (or accepts chars array, but nothing happens).
    public static void filterByFirstChar2(String[] stringsFromArray, ArrayList<String> segmentedStringArrayList, char[] stringsFromSegment) {
        for (int i = 0; i < stringsFromArray.length; i++) {
            if (stringsFromArray[i].toLowerCase().startsWith(String.valueOf(stringsFromSegment))) {
                segmentedStringArrayList.add(stringsFromArray[i]);
                System.out.println("Strings with corresponding segment of chars: " + stringsFromArray[i]);
            }
        }
    }

    //=======================================================================
    //method to filter array by first char, version_03
    public static void filterByFirstChar3(String[] stringsFromArray, ArrayList<String> segmentedStringArrayList, char[] charsFromSegment) {
        for (int i = 0; i < stringsFromArray.length; i++) {
            for (int j = 0; j < charsFromSegment.length; j++) {
                char firstChar = stringsFromArray[i].toLowerCase().charAt(0);

                if (firstChar == charsFromSegment[j]) {
                    segmentedStringArrayList.add(stringsFromArray[i]);
                }
            }
        }
    }

    //=======================================================================
    //method to count occurrences
    public static void countOccurrences(ArrayList<String> arrayList, String string) throws FileNotFoundException {
        Set<String> unique = new HashSet<String>(arrayList);
        for (String key : unique) {
            printContentToFile(string);
            System.out.println(key + ": " + Collections.frequency(arrayList, key));
        }
    }

    //=======================================================================
    //method to print console content to file
    public static void printContentToFile(String string) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream(string + ".txt", true), false);
        System.setOut(out);
    }
}
