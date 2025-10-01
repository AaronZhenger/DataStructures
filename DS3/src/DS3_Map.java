import java.util.ArrayList;

public class DS3_Map<K, V> implements MapInterface<K, V> {
    ArrayList<MapEnt<K, V>> map = new ArrayList<>();

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean containsKey(K key) {
        for (MapEnt<K, V> i : map)
            if (i.getKey().equals(key))
                return true;
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (MapEnt<K, V> i : map)
            if (i.getValue().equals(value))
                return true;
        return false;
    }

    @Override
    public DS3_Set<MapEnt<K, V>> entrySet() {
        DS3_Set<MapEnt<K, V>> set = new DS3_Set<>();
        for (MapEnt<K, V> i : map)
            set.add(i);
        return set;
    }//

    @Override
    public V get(K o) {
        for (MapEnt<K, V> i : map)
            if (i.getKey().equals(o))
                return i.getValue();
        return null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public V put(K key, V value) {
        for (int i = 0; i < map.size(); i++)
            if (map.get(i).getKey().equals(key)) {
                V originalValue = map.get(i).getValue();
                map.remove(i);
                map.add(i, new MapEnt<>(key, value));
                return originalValue;
            }
        map.add(new MapEnt<>(key, value));
        return null;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public DS3_Set<K> keySet() {
        DS3_Set<K> keySet = new DS3_Set<>();
        for (MapEnt<K, V> i : map)
            keySet.add(i.getKey());
        return keySet;
    }

    @Override
    public ArrayList<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (MapEnt<K, V> i : map)
            values.add(i.getValue());
        return values;
    }

    @Override
    public V remove(K key) {
        for (MapEnt<K, V> i : map)
            if (i.getKey().equals(key)) {
                V value = i.getValue();
                map.remove(i);
                return value;
            }
        return null;
    }
}
