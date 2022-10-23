import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Searcher searcher=new Searcher();
        SearchResult searchResult=searcher.AstarSearch(125340678,12345678,"Manhattan");

        searchResult.print();

    }
}