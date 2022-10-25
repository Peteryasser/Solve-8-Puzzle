public class EuclideanDistance implements DistanceFunction{
    @Override
    public float distance(Integer state) {
        Integer[][] goal = {{1,1,0},{2,2,0},{3,0,1},{4,1,1},{5,2,1},{6,0,2},{7,1,2},{8,2,2}};
        float result = 0;
        int element = 0;
        float euclidean = 0;
        Integer[][] resultMat = new Integer[3][3];
        resultMat = Help.toMatrix(state);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                element = resultMat[i][j];
                if (element>0){
                    euclidean = (float) Math.sqrt(Math.pow(goal[element-1][1]-j,2) + Math.pow(goal[element-1][2]-i,2));
                    result = result + euclidean;
                }
            }
        }
        return result;
    }
}
