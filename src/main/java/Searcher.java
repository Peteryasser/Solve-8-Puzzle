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
        long startTime = System.currentTimeMillis();
        SearchResult result = null;
        int maxDepth = 0;
        PriorityQueue<Entry> frontier=new PriorityQueue<>();
        HashMap<Integer, Integer> explored =new HashMap<>();
        HashMap<Integer,Integer> parentTree=new HashMap<>();
        int state;
        float initialCost;
        if(distanceFunction.equals("M")){
            initialCost = Help.ManhattanDistance(initialState);
        }
        else{
            initialCost = Help.EuclideanDistance(initialState);
        }
        Entry entry0 = new Entry(initialState,initialCost);
        frontier.add(entry0);
        while (!frontier.isEmpty()){
            state=frontier.remove().getKey();
            if(parentTree.isEmpty()){
                explored.put(state,  0);
            }
            else{
                int parent = parentTree.get(state);
                int currentBackCost = explored.get(parent) +1;
                explored.put(state , currentBackCost );
                if (currentBackCost>maxDepth){
                    maxDepth = currentBackCost;
                }
            }
            if(state==goalState) {
                result = new SearchResult(explored, parentTree, System.currentTimeMillis() - startTime , maxDepth );
                return result;
            }
            Help help=new Help(state);
            for (Integer neighbor:help.makeNeighbors()){
                if (!explored.containsKey(neighbor)){
                    int CostBack = explored.get(state)+1;
                    float CostForward;
                    if(distanceFunction.equals("M")) {
                        CostForward = Help.ManhattanDistance(neighbor);
                    }
                    else {
                        CostForward = Help.EuclideanDistance(neighbor);
                    }
                    float totalCost = CostBack + CostForward;
                    Entry entry = new Entry(neighbor,totalCost);
                    frontier.add(entry);
                    parentTree.put(neighbor,state);
                }
            }

        }

        return null;
    }

}
//i