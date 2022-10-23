import java.util.*;
import java.util.LinkedList;

public class Searcher {



    public SearchResult DFS(Integer initialState , Integer goalState){
        long startTime = System.currentTimeMillis();

        SearchResult result = null;

        Stack<Integer> frontier=new Stack<>();
        HashSet<Integer> explored =new HashSet<>();
        HashMap<Integer,Integer> parentTree=new HashMap<>();
        int state;
        frontier.add(initialState);
        while (!frontier.isEmpty()){
            state=frontier.pop();
            explored.add(state);
            if(state==goalState) {
                result = new SearchResult(explored, parentTree, System.currentTimeMillis() - startTime);
                return result;
            }
            Help help=new Help(state);
            for (Integer neighbor:help.makeNeighbors()){
                if ((!frontier.contains(neighbor))&&(!explored.contains(neighbor))){
                    frontier.add(neighbor);
                    parentTree.put(neighbor,state);
                }
            }
        }
        return null;
    }

    public SearchResult BFS(Integer initialState , Integer goalState){
        long startTime = System.currentTimeMillis();
        SearchResult result = null;
        int maxDepth = 0;
        int currentDepth = 0;
        
        Queue<Integer> frontier=new LinkedList<>();
        HashSet<Integer> explored =new HashSet<>();
        HashMap<Integer,Integer> parentTree=new HashMap<>();
        int state;
        frontier.add(initialState);
        while (!frontier.isEmpty()){
            state=frontier.remove();
            explored.add(state);
            if(state==goalState) {
                result = new SearchResult(explored, parentTree, System.currentTimeMillis() - startTime );
                return result;
            }
            Help help=new Help(state);
            for (Integer neighbor:help.makeNeighbors()){
                if ((!frontier.contains(neighbor))&&(!explored.contains(neighbor))){
                    frontier.add(neighbor);
                    parentTree.put(neighbor,state);
                }
            }

        }


        return null;
    }

    public SearchResult AstarSearch(Integer initialState , Integer goalState , String distanceFunction){



        return null;
    }

}
