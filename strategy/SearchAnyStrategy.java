package search.strategy;

import search.ConsoleHelper;

import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SearchAnyStrategy implements SearchStrategy {
    @Override
    public void performSearch(Map<String, List<Integer>> indicesMap, List<String> data, String query) {
        String result = "";
        int count = 0;
        String[] items = query.split(" ");

        Set<Integer> indicesSet = new LinkedHashSet<>();
        for (Map.Entry<String, List<Integer>> pair: indicesMap.entrySet()) {
            for (String item: items) {
                if (item.equalsIgnoreCase(pair.getKey())) {
                    indicesSet.addAll(pair.getValue());
                }
            }
        }
        count = indicesSet.size();

        for (Integer index: indicesSet) {
            result += data.get(index);
            result += "\n";
        }

        if (count == 0) {
            ConsoleHelper.writeMessage("No matching people found.\n");
        } else {
            ConsoleHelper.writeMessage(String.format("%d persons found:", count));
            ConsoleHelper.writeMessage(result);
        }
    }
}
