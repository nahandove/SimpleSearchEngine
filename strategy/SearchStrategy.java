package search.strategy;

import java.util.List;
import java.util.Map;

public interface SearchStrategy {
    void performSearch(Map<String, List<Integer>> indicesMap, List<String> data, String query);
}
