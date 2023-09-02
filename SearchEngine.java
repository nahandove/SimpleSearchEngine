package search;

import search.strategy.SearchStrategy;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class SearchEngine {
    private SearchStrategy searchStrategy;

    public void setStrategy(SearchStrategy searchStrategy) {
        this.searchStrategy = searchStrategy;
    }

    public void performSearch(Map<String, List<Integer>> indicesMap, List<String> data) throws IOException {
        ConsoleHelper.writeMessage("Enter a name or email to search for all suitable people:");
        String query = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("");
        this.searchStrategy.performSearch(indicesMap, data, query);
    }
}
