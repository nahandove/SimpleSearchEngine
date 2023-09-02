package search;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Database {
    private Map<String, List<Integer>> invertedIndices = new LinkedHashMap<>();

    public List<String> load(String fileName) throws IOException {
        List<String> loadedList = new ArrayList<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            while (fileReader.ready()) {
                loadedList.add(fileReader.readLine());
            }
        }
        putAll(loadedList);
        return loadedList;
    }

    public void displayAll(List<String> data) {
        ConsoleHelper.writeMessage("=== List of people ===");
        for (int i = 0; i < data.size(); i++) {
            ConsoleHelper.writeMessage(data.get(i));
        }
        ConsoleHelper.writeMessage("");
    }

    private void putAll (List<String> data) {
        for (int i = 0; i < data.size(); i++) {
            String[] details = data.get(i).split(" ");
            for (String detail: details) {
                if (!invertedIndices.containsKey(detail)) {
                    List<Integer> indices = new ArrayList<>();
                    invertedIndices.put(detail, indices);
                    invertedIndices.get(detail).add(i);
                } else {
                    invertedIndices.get(detail).add(i);
                }
            }
        }
    }

    public Map<String, List<Integer>> getInvertedIndices() {
        return invertedIndices;
    }
}
