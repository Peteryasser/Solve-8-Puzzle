import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Searcher searcher=new Searcher();
        SearchResult searchResult=searcher.DFS(125340678,12345678);

        searchResult.print();

    }
}