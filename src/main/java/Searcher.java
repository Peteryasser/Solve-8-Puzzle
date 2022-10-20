import java.util.*;

public class Searcher {




    public static Integer store(Integer[][] stateMatrix){
        Integer resultInt = 0;
        for (int i = 0; i < 9; i++) {
            resultInt += stateMatrix[i/3][i%3] * (int) Math.pow(10 ,8-i );
        }
        return resultInt;
    }

    public static Integer[][] expand(Integer stateInt){
        Integer[][] resultMat = new Integer[3][3];
        for (int i = 0; i < 9; i++) {
            resultMat[2 - i/3][2- i%3] = stateInt%10;
            stateInt /= 10;
        }
        return resultMat;
    }




    public SearchResult DFS(Integer initialState , Integer goalState){
        Stack<Integer> frontier=new Stack<>();
        HashSet<Integer> explored =new HashSet<>();
        HashMap<Integer,Integer> parentTree=new HashMap<>();
        SearchResult result=new SearchResult(explored,parentTree);
        int state;
        frontier.add(initialState);
        while (!frontier.isEmpty()){
            state=frontier.pop();
            explored.add(state);
            if(state==goalState)
                return result;
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
        Queue<Integer> frontier=new LinkedList<>();
        HashSet<Integer> explored =new HashSet<>();
        HashMap<Integer,Integer> parentTree=new HashMap<>();
        SearchResult result=new SearchResult(explored,parentTree);
        int state;
        frontier.add(initialState);
        while (!frontier.isEmpty()){
            state=frontier.remove();
            explored.add(state);
            if(state==goalState)
                return result;
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


    public SearchResult AstarSearch(Integer initialState , Integer goalState){


        return null;
    }

}
