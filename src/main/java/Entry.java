public class Entry implements Comparable<Entry> {
    private Integer key;
    private float value;

    public Entry(Integer key, float value) {
        this.key = key;
        this.value = value;
    }
    Integer getKey (){//i
        return this.key;
    }
    float getValue(){
        return this.value;
    }
    @Override
    public int compareTo(Entry other) {
        return this.getKey().compareTo(other.getKey());
    }


}