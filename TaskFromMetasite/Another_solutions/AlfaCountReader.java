package lt.akademijait.apupelis;;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class AlfaCountReader {

  public static List<String> A_TO_G = Arrays.asList("a","b","c","d","e","f","g");
  public static List<String> H_TO_N = Arrays.asList("h","i","j","k","l","m","n");
  public static List<String> O_TO_U = Arrays.asList("o","p","q","r","s","t","u");
  public static List<String> V_TO_Z = Arrays.asList("v","w","x","y","z");

  public static void main(String...args) throws IOException {

//    Option 1 (user specified path)
//    System.out.println("Please, enter directory path:");
//    Scanner scanner = new Scanner(System.in);
//    String fileLocation = scanner.nextLine().trim();

//    Options 2 ("hardcoded" path)
    String fileLocation = "/home/aidas/Documents/WordsCounting/TextFiles/";


    System.out.println(String.format("reading files from directory", fileLocation));

    Files.walk(Paths.get(fileLocation))
        .filter(Files::isRegularFile).filter(Files::isReadable)
        .forEach(System.out::println);

    Map<String, Map<String,Integer>> readerFilter = new HashMap<>();

    Files.walk(Paths.get(fileLocation))
        .filter(Files::isRegularFile)
        .forEach(path-> computeFileContent(path, readerFilter));
  }

  private static void computeFileContent(Path path,Map<String, Map<String,Integer>> readerFilter) {

    try (Stream<String> stream = Files.lines(path)) {

      stream.forEach(s -> {
        String[] line = s.split(" ");
        for (String word : line){
          String firstChar = String.valueOf(word.toLowerCase().charAt(0));
          if (A_TO_G.contains(firstChar)) {
            updateMap(readerFilter,word, "a-g");
          }else if(H_TO_N.contains(firstChar)){
            updateMap(readerFilter,word, "h-n");
          } else if(O_TO_U.contains(firstChar)){
            updateMap(readerFilter,word, "o-u");
          } else if(V_TO_Z.contains(firstChar)){
            updateMap(readerFilter,word, "v-z");
          } else{
            System.out.println("invalid char found: " + firstChar);
          }
        }
      });

    } catch (IOException e) {
      e.printStackTrace();
    }

    //write map to files.
    try {
      writeOutPut(readerFilter);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void updateMap(Map<String, Map<String, Integer>> readerFilter, String word, String mapKey) {
      if (readerFilter.containsKey(mapKey)) {
        if (readerFilter.get(mapKey).containsKey(word.toLowerCase())) {
          int cnt = readerFilter.get(mapKey).get(word.toLowerCase()) + 1;
          readerFilter.get(mapKey).put(word.toLowerCase(), cnt);
        } else {
          readerFilter.get(mapKey).put(word.toLowerCase(), 1);
        }
      } else {
        Map<String, Integer> innerMap = new HashMap<>();
        innerMap.put(word.toLowerCase(), 1);
        readerFilter.put(mapKey, innerMap);
      }
  }

  private static void writeOutPut(Map<String, Map<String, Integer>> readerFilter) throws IOException{
    Path path = Paths.get("/home/aidas/Documents/WordsCounting/TextFiles/textfile_a-g.txt");
    try (BufferedWriter writer = Files.newBufferedWriter(path)){
      Map<String, Integer> agMap = readerFilter.get("a-g");
      for(Map.Entry<String, Integer> entry : agMap.entrySet()){
        writer.write(entry.getKey() + " " + entry.getValue());
        writer.newLine();
      }
    }
  }

}
