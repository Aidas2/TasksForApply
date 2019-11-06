package lt.viliuszalys.wordssortingalgorithm;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class SortingAlgorithm {
    public static void main(String[] args) throws IOException {

        String separator = File.separator;
        File inputDirectory = new File("Input" + separator);
        HashMap<String, Integer> mapList = new HashMap<>();

        for (File file : inputDirectory.listFiles()) {
            Scanner fileScanner = new Scanner(file);

            fileScanner.useDelimiter("[^A-Za-z']+");

            while (fileScanner.hasNext()) {
                String word = fileScanner.next().toLowerCase();

                if (!mapList.containsKey(word)) {
                    mapList.put(word, 1);
                } else mapList.put(word, mapList.get(word) + 1);
            }
            fileScanner.close();
        }

        List<String> words = new ArrayList<>(mapList.keySet());
        Collections.sort(words);

        List<String> wordsAG = new ArrayList<>();
        List<String> wordsHN = new ArrayList<>();
        List<String> wordsOU = new ArrayList<>();
        List<String> wordsVZ = new ArrayList<>();

        for (String word : words) {
            if (Character.getNumericValue(word.charAt(0)) <= 16) {
                wordsAG.add(word);
            } else if (Character.getNumericValue(word.charAt(0)) <= 23) {
                wordsHN.add(word);
            } else if (Character.getNumericValue(word.charAt(0)) <= 30) {
                wordsOU.add(word);
            } else if (Character.getNumericValue(word.charAt(0)) <= 67) {
                wordsVZ.add(word);
            } continue;
        }

        PrintWriter outputAG = new PrintWriter(new FileWriter("Output" + separator + "wordsA-G.txt"));
        PrintWriter outputHN = new PrintWriter(new FileWriter("Output" + separator + "wordsH-N.txt"));
        PrintWriter outputOU = new PrintWriter(new FileWriter("Output" + separator + "wordsO-U.txt"));
        PrintWriter outputVZ = new PrintWriter(new FileWriter("Output" + separator + "wordsV-Z.txt"));

        for (String word : wordsAG)
            outputAG.println(word + " repeats " + mapList.get(word) + " time(s)");
        for (String word : wordsHN)
            outputHN.println(word + " repeats " + mapList.get(word) + " time(s)");
        for (String word : wordsOU)
            outputOU.println(word + " repeats " + mapList.get(word) + " time(s)");
        for (String word : wordsVZ)
            outputVZ.println(word + " repeats " + mapList.get(word) + " time(s)");

        outputAG.close();
        outputHN.close();
        outputOU.close();
        outputVZ.close();
    }
}
