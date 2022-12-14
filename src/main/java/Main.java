import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {// "algorithm" , "state" , "distance func"*
        String algorithm = args[0];
        int state = Integer.parseInt(args[1]);
//        String algorithm="BFS";
//        int state= 812043765;
        Searcher searcher=new Searcher();
        SearchResult searchResult = null;

        if(algorithm.startsWith("A*")){
            String[] input = algorithm.split("\s");
            algorithm = input[0];
            String distanceFunction = input[1];

            if (distanceFunction.equals("M")){
                searchResult=searcher.AstarSearch(state,12345678,new ManhattanDistance());
            }
            else if (distanceFunction.equals("E")){
                searchResult=searcher.AstarSearch(state,12345678,new EuclideanDistance());
            }
            else{
                System.out.println("!!!!!!!Unknown distance function!!!!!!");
                System.exit(0);
            }


        }
        else if(algorithm.equals("BFS")){
            searchResult=searcher.BFS(state,12345678);

        }
        else if(algorithm.equals("DFS")){
            searchResult=searcher.DFS(state,12345678);
        }
        else{
            System.out.println("unknown algorithm");
            return;
        }

        if (searchResult==null) {
//            System.out.println("Can't Solve");
            System.out.println("searchResult is null");
        }
        else {
            if (searchResult.getGoalPath().size() == 0){
                System.out.println("Can't be solved!");
                searchResult.toTxtFile();
            }
        }
//        searchResult.print();


    }
}
