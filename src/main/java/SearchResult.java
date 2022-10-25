import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import org.json.*;


public class SearchResult {

    HashMap<Integer, Integer> explored;
    HashMap<Integer, Integer> parentTree;
    int maxDepth;
    long time;
    int goal = 12345678;

    SearchResult(HashMap<Integer, Integer> explored , HashMap<Integer,Integer> parentTree , long time ){
        this.explored = explored;
        this.parentTree = parentTree;
        this.time = time;
    }
    SearchResult(HashMap<Integer, Integer> explored , HashMap<Integer,Integer> parentTree , long time  , int maxDepth){
        this.explored = explored;
        this.parentTree = parentTree;
        this.time = time;
        this.maxDepth = maxDepth;
    }


    LinkedList<Integer> getGoalPath(){
        int state=this.goal;
        LinkedList<Integer> path = new LinkedList<>();

        if (!this.parentTree.containsKey(state)){
            return path;
        }

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
        System.out.println("time = " + this.time + "ms");
        System.out.println("cost of path = " + (path.size()-1) );
        System.out.println("max depth = " + this.maxDepth );
        System.out.println("num of nodes expaded = " + this.explored.size());
    }

    void toTxtFile(){
        try {
            FileWriter myWriter = new FileWriter("results.txt");
            myWriter.write(this.time+"\n"+this.maxDepth+'\n'+this.explored.size()+'\n'+getGoalPath());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
//i
