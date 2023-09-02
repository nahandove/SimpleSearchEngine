package search;

import search.strategy.SearchAllStrategy;
import search.strategy.SearchAnyStrategy;
import search.strategy.SearchNoneStrategy;

import java.util.List;

public class Main {
    static Database database = new Database();
    static SearchEngine searchEngine = new SearchEngine();
    static List<String> people;

    public static void main(String[] args) throws Exception {
        try {
            String fileName = "";
            for (int i = 0; i < args.length; i++) {
                if ("--data".equals(args[i])) {
                    fileName = args[i + 1];
                }
            }
            people = database.load(fileName);
            mainMenu();
        } catch (Exception e) {
            ConsoleHelper.writeMessage(e.getMessage());
            mainMenu();
        }
    }

    public static void mainMenu() throws Exception {
        ConsoleHelper.writeMessage("=== Menu ===\n" +
                "1. Find a person\n" +
                "2. Print all people\n" +
                "0. Exit");

        int choice = Integer.parseInt(ConsoleHelper.readString());
        ConsoleHelper.writeMessage("");

        switch (choice) {
            case 1 -> defineSearchCriterion();
            case 2 -> database.displayAll(people);
            case 0 -> {
                ConsoleHelper.writeMessage("Bye!");
                System.exit(0);
            }
            default -> throw new IllegalArgumentException("Incorrect option! Try again.\n");
        }
        mainMenu();
    }

    public static void defineSearchCriterion() throws Exception {
        ConsoleHelper.writeMessage("Select a matching strategy: ALL, ANY, NONE");
        String response = ConsoleHelper.readString();
        ConsoleHelper.writeMessage("");

        switch(response) {
            case "ALL" -> {
                searchEngine.setStrategy(new SearchAllStrategy());
                searchEngine.performSearch(database.getInvertedIndices(), people);
            }
            case "ANY" -> {
                searchEngine.setStrategy(new SearchAnyStrategy());
                searchEngine.performSearch(database.getInvertedIndices(), people);
            }
            case "NONE" -> {
                searchEngine.setStrategy(new SearchNoneStrategy());
                searchEngine.performSearch(database.getInvertedIndices(), people);
            }
            default -> throw new IllegalArgumentException("No search strategy found.\n");
        }
    }
}
