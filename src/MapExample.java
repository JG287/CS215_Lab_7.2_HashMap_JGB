/**
 * This class shows an example of a HashMap that reads from a text file and stores the list of words into it.
 */
import java.io.*;
import java.util.*;
  
public class MapExample {
    
	final static String filePath = "wordFile2.txt";
	/**
	 * The main class that is used to print the unsorted list of words, as well as 5 words from the text file, alongside
	 * their definition and hashCode.
	 * @param args
	 */
    public static void main(String[] args)
    {
        Map<String, String> mapTextFile = HashMapFromTextFile();
 
        for (Map.Entry<String, String> entry : mapTextFile.entrySet()) {
        
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        String word1 = "purfle";
        String word2 = "meat";
        String word3 = "corse";
        String word4 = "asunder";
        String word5 = "twelvemonth";
        System.out.println(word1 + ": " + mapTextFile.get("purfle") + "\n" + word1.hashCode());
        System.out.println(word2 + ": " + mapTextFile.get("meat") + "\n" + word2.hashCode());
        System.out.println(word3 + ": " + mapTextFile.get("corse") + "\n" + word3.hashCode());
        System.out.println(word4 + ": " + mapTextFile.get("asunder") + "\n" + word4.hashCode());
        System.out.println(word5 + ": " + mapTextFile.get("twelvemonth") + "\n" + word5.hashCode());
    }
  
    /**
     * Map class that is used to generate a HashMap that contains all of the words from a text file, and stores them
     * as key/value pairs.
     * @return
     */
    public static Map<String, String> HashMapFromTextFile()
    {
  
        Map<String, String> Map = new HashMap<String, String>();
        BufferedReader BR = null;
  
        try {
  
            File archaicWords = new File(filePath);
            BR = new BufferedReader(new FileReader(archaicWords));
            String line = null;
  
            while ((line = BR.readLine()) != null) {
            	
                String[] part = line.split("	");
                String word = part[0].trim();
                String definition = part[1].trim();
                if (!word.equals("") && !definition.equals(""))
                    Map.put(word, definition);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        } 
        return Map;
    }
}