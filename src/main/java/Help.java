import java.util.LinkedList;

public class Help {
    LinkedList<Integer> state;
    int indexOfZero;

    public static LinkedList<Integer> toLinkedList(Integer stateInt){
        LinkedList<Integer> result=new LinkedList<>();
        for(int i=0;i<9;i++){
            result.addFirst(stateInt%10);
            stateInt/=10;
        }
        return result;
    }

    /*
        102
        453
        678
     */
    public static Integer toInteger(LinkedList<Integer> stateList){
        Integer result=0;
        for (int i = 0; i < 9; i++) {
            result += stateList.get(i) * (int) Math.pow(10 ,8-i );
        }
        return result;
    }

    public static Integer toInteger(Integer[][] stateMatrix){
        Integer resultInt = 0;
        for (int i = 0; i < 9; i++) {
            resultInt += stateMatrix[i/3][i%3] * (int) Math.pow(10 ,8-i );
        }
        return resultInt;
    }

    public static Integer[][] toMatrix(Integer stateInt){
        Integer[][] resultMat = new Integer[3][3];
        for (int i = 0; i < 9; i++) {
            resultMat[2 - i/3][2- i%3] = stateInt%10;
            stateInt /= 10;
        }
        return resultMat;
    }

    public Help(Integer state){
        this.state=toLinkedList(state);
        this.indexOfZero=this.state.indexOf(0);
    }

    private boolean canMoveUp(){
        return indexOfZero>2;
    }

    private LinkedList<Integer> upState(){
        LinkedList<Integer> newState= (LinkedList<Integer>) this.state.clone();
        return swapWith0(newState,indexOfZero-3);
    }


    private boolean canMoveDown(){
        return indexOfZero<6;
    }
    private LinkedList<Integer> downState(){
        LinkedList<Integer> newState=(LinkedList<Integer>) this.state.clone();
        return swapWith0(newState,indexOfZero+3);
    }


    private boolean canMoveRight(){
        return !(indexOfZero%3==2);
    }
    private LinkedList<Integer> rightState(){
        LinkedList<Integer> newState=(LinkedList<Integer>) this.state.clone();
        return swapWith0(newState,indexOfZero+1);
    }


    private boolean canMoveLift(){
        return !(indexOfZero%3==0);
    }
    private LinkedList<Integer> liftState(){
        LinkedList<Integer> newState=(LinkedList<Integer>) this.state.clone();
        return swapWith0(newState,indexOfZero-1);
    }


    public LinkedList<Integer> makeNeighbors(){
        LinkedList<Integer> neighbors=new LinkedList<>();
        if(canMoveUp())
            neighbors.add(toInteger(upState()));
        if(canMoveDown())
            neighbors.add(toInteger(downState()));
        if(canMoveRight())
            neighbors.add(toInteger(rightState()));
        if(canMoveLift())
            neighbors.add(toInteger(liftState()));

        return neighbors;
    }

    private LinkedList<Integer> swapWith0(LinkedList<Integer>newState,int index){
        newState.set(indexOfZero,this.state.get(index));
        newState.set(index,0);
        return newState;
    }

    public static void printState(Integer[][] state){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(state[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printState(Integer state){
        Integer[][] matrix = toMatrix(state);
        printState(matrix);
    }


}
