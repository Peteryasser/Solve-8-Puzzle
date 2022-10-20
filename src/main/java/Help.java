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
    public static Integer toInteger(LinkedList<Integer> stateList){
        Integer result=0;
        for (int i = 0; i < 9; i++) {
            result += stateList.get(i) * (int) Math.pow(10 ,8-i );
        }
        return result;
    }
    public Help(Integer state){
        this.state=toLinkedList(state);
        this.indexOfZero=this.state.indexOf(9);
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
        newState.set(index,9);
        return newState;
    }
}
