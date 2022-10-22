import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Searcher searcher=new Searcher();
        SearchResult searchResult=searcher.BFS(125349678,912345678);
        try {
            System.out.println(searchResult.explored.size());
            int goal=912345678;
            int c=0;
            while (searchResult.parentTree.containsKey(goal)){
                goal=searchResult.parentTree.get(goal);
                Integer[][] r=Searcher.expand(goal);
                for(int i=0;i<3;i++){
                    for(int j=0;j<3;j++){
                        System.out.print(r[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                System.out.println("******************");
                c++;
            }
            System.out.println(c);
        }catch (NullPointerException e){
            System.out.println("No solution");
        }
    }
}
