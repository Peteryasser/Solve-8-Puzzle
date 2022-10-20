import java.util.HashMap;
import java.util.HashSet;

public class SearchResult {

    HashSet<Integer> explored;
    HashMap<Integer, Integer> parentTree;

    SearchResult(HashSet<Integer> explored , HashMap<Integer,Integer> parentTree){
        this.explored = explored;
        this.parentTree = parentTree;
    }
}
