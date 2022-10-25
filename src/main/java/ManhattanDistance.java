public class ManhattanDistance implements DistanceFunction{
    @Override
    public float distance(Integer state) {
       Integer[][] goal = {{1,1,0},{2,2,0},{3,0,1},{4,1,1},{5,2,1},{6,0,2},{7,1,2},{8,2,2}};
        int result = 0;
        int element = 0;
        int manhattan = 0;
        Integer[][] resultMat = new Integer[3][3];
        resultMat = Help.toMatrix(state);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                element = resultMat[i][j];
                if(element>0){
                    manhattan = Math.abs(goal[element-1][1]-j) + Math.abs(goal[element-1][2]-i);
                    result = result + manhattan;
                }
            }
        }
        return result;
    }
}
