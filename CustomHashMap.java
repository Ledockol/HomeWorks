//Реализовать кастомную реализацию HashMap с методами put, get, remove.

public class CustomHashMap<K, V> {
    private static final double LOAD_FACTOR = 0.75;
    private int capacity = 16;
    private int size = 0;
    private Object[][] table;

    public CustomHashMap() {
        table = new Object[capacity][2];
    }

    private void resize() {
     capacity *= 2;
     Object[][] oldTable = table;
     table = new Object[capacity][2];
     size = 0;

     for (int i = 0; i < oldTable.length; i++) {
         if (oldTable[i][0] != null) {
             put((K) oldTable[i][0], (V) oldTable[i][1]);
         }
     }
    }

    public void put(K key, V value) {
        if ((double) size / capacity >= LOAD_FACTOR) {
            resize();
        }
        int index = Math.abs(key.hashCode()) % capacity;

        if (table[index][0] != null && table[index][0].equals(key)){
            table[index][1] = value;
            return;
        }
        table[index][0] = key;
        table[index][1] = value;
        size++;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (table[index][0] != null && table[index][0].equals(key)) {
            return (V) table[index][1];
        }
        return null;
    }

    public V remove(K key) {
        int index = Math.abs(key.hashCode()) % capacity;
        if (table[index][0] != null && table[index][0].equals(key)) {
            V value = (V) table[index][1];
            table[index][0] = null;
            table[index][1] = null;
            size--;
            return value;
        }
        return null;
    }

    public int size() {
        return size;
    }
}