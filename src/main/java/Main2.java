public class Main2 {
    public static void main(String[] args) {
        String algorithm="BFS";
        int state= 125348076;
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

            searchResult.toTxtFile();
        }
        else if(algorithm.equals("BFS")){
            searchResult=searcher.BFS(state,12345678);
            if(searchResult!=null){
                searchResult.toTxtFile();
            }
        }
        else if(algorithm.equals("DFS")){
            searchResult=searcher.DFS(state,12345678);
            if (searchResult != null){
                searchResult.toTxtFile();
            }
        }
        else{
            System.out.println("unknown algorithm");
            return;
        }
        if (searchResult==null) {
            System.out.println("Can't Solve");
        }
        searchResult.print();


    }
}
