import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Searcher searcher=new Searcher();
        SearchResult searchResult=searcher.DFS(125349678,912345678);
        System.out.println(searchResult.explored.size());
        int goal=912345678;
        int c=0;
        while (searchResult.parentTree.containsKey(goal)){
            goal=searchResult.parentTree.get(goal);
            System.out.println(goal);
            c++;
        }
        System.out.println(c);
    }
}
