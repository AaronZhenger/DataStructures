import java.util.ArrayList;
import java.util.Iterator;

public class DS4_HashTable<K, V> implements DS4_HashTable_Interface<K, V>, Iterator<K> {
    private ArrayList<ArrayList<DS4_Entry<K, V>>> table;
    private ArrayList<K> keys;
    private Iterator<K> iterator;
    private int bucketCapacity;
    private int loadFactor;
    private int tableSize;
    private int size;
    private int tombstones;

    public DS4_HashTable(int bucketCapacity, int loadFactor, int tableSize) {
        table = new ArrayList<>();
        this.bucketCapacity = bucketCapacity;
        this.loadFactor = loadFactor;
        this.tableSize = tableSize;
        for (int i = 0; i < tableSize; i++)
            table.add(new ArrayList<>());
        size = 0;
        tombstones = 0;
        keys = new ArrayList<>();
    }

    @Override
    public void clear() {
        for (ArrayList<DS4_Entry<K, V>> bucket : table)
            bucket.clear();
        size=0;
        tombstones=0;
        keys.clear();
    }

    @Override
    public int size() {
        System.out.println(keys);
        return size;
    }

    public int tableSize() {
        return tableSize;
    }

    @Override
    public int tombstones() {
        return tombstones;
    }

    @Override
    public boolean contains(K key) {
        return keys.contains(key);
//        int position = hash(key);
//        ArrayList<DS4_Entry<K, V>> bucket = hashTable.get(position);
//        do {
//            for (DS4_Entry<K, V> entry : bucket)
//                if (entry!=null && entry.key.equals(key))
//                    return true;
//            if (position==tableSize-1) position = 0;
//            else position++;
//        } while (bucket.size()==bucketCapacity);
//        return false;
    }

    @Override
    public V insert(K key, V value) {
        int position = hash(key);
        while (table.get(position).size()==bucketCapacity) {
            for (int i = 0; i < table.get(position).size(); i++)
                if (table.get(position).get(i)!=null && table.get(position).get(i).key.equals(key)) {
                    return table.get(position).set(i, new DS4_Entry<>(key, value)).value;
                }
            if (position==tableSize-1) position = 0;
            else position++;
        }
        for (int i = 0; i < table.get(position).size(); i++)
            if (table.get(position).get(i).key.equals(key)) {
                return table.get(position).set(i, new DS4_Entry<>(key, value)).value;
            }
        size++;
        table.get(position).add(new DS4_Entry<>(key, value));
        keys.add(key);
        if (tombstones+size>=loadFactor) {
            rebuild();
        }
        return null;
    }



    @Override
    public V remove(K key) {
        int position = hash(key);
        while (table.get(position).size()==bucketCapacity) {
            for (int i = 0; i < table.get(position).size(); i++)
                if (table.get(position).get(i).key.equals(key)) {
                    size--;
                    tombstones++;
                    keys.remove(key);
                    return table.get(position).set(i, null).value;
                }
            if (position==tableSize-1) position = 0;
            else position++;
        }
        for (int i = 0; i < table.get(position).size(); i++)
            if (table.get(position).get(i).key.equals(key)) {
                size--;
                tombstones++;
                keys.remove(key);
                return table.get(position).set(i, null).value;
            }
        return null;
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public K next() {
        return iterator.next();
    }

    private void rebuild() {
        ArrayList<DS4_Entry<K, V>> toAdd = new ArrayList<>();
        for (ArrayList<DS4_Entry<K, V>> bucket : table)
            for (DS4_Entry<K, V> entry : bucket)
                if (entry!=null)
                    toAdd.add(entry);
        tableSize*=2;
        loadFactor*=2;
        table = new ArrayList<>();
        for (int i = 0; i < tableSize; i++)
            table.add(new ArrayList<>());
        tombstones = 0;
        size = 0;
        keys = new ArrayList<>();
        for (DS4_Entry<K, V> entry : toAdd) {
            System.out.println("Adding "+entry.key);
            insert(entry.key, entry.value);
            System.out.println(keys.size());
        }
    }

    private int hash(K key) {
        return key.hashCode() % tableSize;
    }

    public Iterator<K> iterator() {
        ArrayList<K> copy = new ArrayList<>(keys);
        iterator = copy.iterator();
        return iterator;
    }
}
