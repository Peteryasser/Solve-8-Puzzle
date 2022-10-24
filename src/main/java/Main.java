import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Searcher searcher=new Searcher();
        SearchResult searchResult=searcher.AstarSearch(251468037,12345678,"e");

        searchResult.print();

    }
}//i