public class Entry implements Comparable<Entry> {
    private Integer key;
    private int value;

    public Entry(Integer key, int value) {
        this.key = key;
        this.value = value;
    }
    Integer getKey (){//i
        return this.key;
    }
    int getValue(){
        return this.value;
    }
    @Override
    public int compareTo(Entry other) {
        return this.getKey().compareTo(other.getKey());
    }


}