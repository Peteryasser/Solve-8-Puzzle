import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.json.*;


public class SearchResult {

    HashSet<Integer> explored;
    HashMap<Integer, Integer> parentTree;
    int maxDepth;
    long time;
    int goal = 12345678;

    SearchResult(HashSet<Integer> explored , HashMap<Integer,Integer> parentTree , long time ){
        this.explored = explored;
        this.parentTree = parentTree;
        this.time = time;
        this.maxDepth = maxDepth;
    }

    void writeJson(){

    }

    LinkedList<Integer> getGoalPath(){
        int state=this.goal;
        LinkedList<Integer> path = new LinkedList<>();

        path.addFirst(state);
        while (this.parentTree.containsKey(state)){
            state=this.parentTree.get(state);

            path.addFirst(state);
        }
        return path;
    }

    void print(){
            LinkedList<Integer> path = getGoalPath();
        for (Integer state : path) {
            Help.printState(state);
            System.out.println("*******************");
        }
            System.out.println("cost of path = " + (path.size()-1) );
            System.out.println("num of nodes expaded = " + this.explored.size());
    }

}
