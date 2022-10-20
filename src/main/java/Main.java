import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Searcher searcher=new Searcher();
        SearchResult searchResult=searcher.DFS(125349678,912345678);
        System.out.println(searchResult.explored.size());
        int r=912345678;
        while (searchResult.parentTree.containsKey(r)){
            r=searchResult.parentTree.get(r);
            System.out.println(r);
        }

    }
}
