package t5;


import java.util.*;

/**
 * Created by X501A on 22.07.2017.
 */
public class MultiMapImpl<K,V> extends HashMap<K, V> implements MultiMap<K,V>{
    private HashMap<K,List<V>> multiMap = new HashMap<K, List<V>>();

    @Override
    public V put(K key, V value) {
        if (multiMap.containsKey(key)){
            List<V> values = multiMap.get(key);
            values.add(value);
            multiMap.put(key,values);
        }else{
            List<V> values = new ArrayList<V>();
            values.add(value);
            multiMap.put(key,values);
        }
        return value;
    }

    @Override
    public int countValues(K key) {
        return 0;
    }

    @Override
    public Iterator<V> valuesIterator(K key) {
        return null;
    }

//    @Override
//    public String toString() {
//        String string = "";
//
//
//        for ( K key : multiMap.keySet()){
//            string = string + key + " = [";
//
//            StringJoiner j = new StringJoiner(",");
//            for(V value : multiMap.get(key)) {
//                j.add(value.toString());
//            }
//
//            string = string + j.toString();
//            string = string + "]";
//        }
//        return string;
//    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        for ( K key : multiMap.keySet()){
            buf.append(key).append(" = [");
            StringJoiner j = new StringJoiner(",");
            for(V value : multiMap.get(key)) {
                j.add(value.toString());
            }
            buf.append(j.toString());
            buf.append("]").append("\n");
        }
        return buf.toString();
    }

    private String getLastSymbol(int i, int size) {
        if (i == size) {
            return "";
        } else {
            return ",";
        }
    }

//    public V getLast() {
//
//        Iterator mapIterator = multiMap.entrySet().iterator();
//        Entry<K, List<V>> element = null;
//        while (mapIterator.hasNext()) {
//            elemant = (Entry<K, List<V>>) mapIterator.next();
//        }
//
//        return (V) elemant.getValue();
//    }


    public V get(Object key){
        int lastIndex = multiMap.get(key).size() - 1;
        return multiMap.get(key).get(lastIndex);
    }

}
