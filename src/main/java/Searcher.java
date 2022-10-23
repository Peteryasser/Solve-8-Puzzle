import java.util.*;
import java.util.LinkedList;

public class Searcher {



    public SearchResult DFS(Integer initialState , Integer goalState){
        long startTime = System.currentTimeMillis();
        SearchResult result = null;
        int maxDepth = 0;

        Stack<Integer> frontier=new Stack<>();
        HashMap<Integer , Integer> explored =new HashMap<>();
        HashMap<Integer,Integer> parentTree=new HashMap<>();
        int state;
        frontier.add(initialState);
        while (!frontier.isEmpty()){
            state=frontier.pop();
            if(parentTree.isEmpty()){
                explored.put(state,0);
            }
            else{
                int parent = parentTree.get(state);
                int currentCost = explored.get(parent) +1;
                explored.put(state , currentCost );
                if (currentCost>maxDepth){
                    maxDepth = currentCost;
                }
            }

//            int parent = parentTree.get(state);
//            int currentCost = explored.get(parent) +1;
//
//            explored.put(state , currentCost );

            if(state==goalState) {
                result = new SearchResult(explored, parentTree, System.currentTimeMillis() - startTime , maxDepth);
                return result;
            }
            Help help=new Help(state);
            for (Integer neighbor:help.makeNeighbors()){
                if ((!frontier.contains(neighbor))&&(!explored.containsKey(neighbor))){
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

        Queue<Integer> frontier=new LinkedList<>();
        HashMap<Integer, Integer> explored =new HashMap<>();
        HashMap<Integer,Integer> parentTree=new HashMap<>();
        int state;
        frontier.add(initialState);
        while (!frontier.isEmpty()){
            state=frontier.remove();

            if(parentTree.isEmpty()){
                explored.put(state,0);
            }
            else{
                int parent = parentTree.get(state);
                int currentCost = explored.get(parent) +1;
                explored.put(state , currentCost );
                if (currentCost>maxDepth){
                    maxDepth = currentCost;
                }
            }


//            explored.put(state);
            if(state==goalState) {
                result = new SearchResult(explored, parentTree, System.currentTimeMillis() - startTime , maxDepth );
                return result;
            }
            Help help=new Help(state);
            for (Integer neighbor:help.makeNeighbors()){
                if ((!frontier.contains(neighbor))&&(!explored.containsKey(neighbor))){
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
