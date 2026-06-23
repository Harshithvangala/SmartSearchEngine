
import java.io.*;
import java.util.*;

public class SearchEngine {

    private HashMap<String, ArrayList<String>> index = new HashMap<>();

    public void indexFiles(String folderPath) {

        File folder = new File(folderPath);
        if (!folder.exists() || !folder.isDirectory()) {
            System.out.println("Index folder not found: " + folderPath);
            return;
        }

        File[] files = folder.listFiles();
        if (files == null || files.length == 0) {
            System.out.println("No files to index in: " + folderPath);
            return;
        }

        for (File file : files) {
            if (!file.isFile()) continue;
            try (Scanner sc = new Scanner(file)) {
                while (sc.hasNext()) {
                    String word = sc.next().toLowerCase();
                    index.putIfAbsent(word, new ArrayList<>());
                    if (!index.get(word).contains(file.getName())) {
                        index.get(word).add(file.getName());
                    }
                }
            } catch (Exception e) {
                System.out.println("Error indexing file " + file.getName() + ": " + e.getMessage());
            }
        }
    }

    public void search(String keyword) {

        keyword = keyword.toLowerCase();

        if(index.containsKey(keyword)) {

            System.out.println("Files Found:");

            for(String file : index.get(keyword)) {
                System.out.println(file);
            }

        } else {
            System.out.println("No files found.");
        }
    }
}
