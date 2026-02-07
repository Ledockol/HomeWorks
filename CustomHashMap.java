//Реализовать кастомную реализацию HashMap с методами put, get, remove.

public class CustomHashMap<K, V> {
    private static final int CAPACITY = 100;
    private Object[][] table = new Object[CAPACITY][2];

    public void put(K key, V value) {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        table[index][0] = key;
        table[index][1] = value;
    }

    public V get(K key) {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        if (table[index][0] != null && table[index][0].equals(key)) {
            return (V) table[index][1];
        }
        return null;
    }

    public V remove(K key) {
        int index = Math.abs(key.hashCode()) % CAPACITY;
        if (table[index][0] != null && table[index][0].equals(key)) {
            V value = (V) table[index][1];
            table[index][0] = null;
            table[index][1] = null;
            return value;
        }
        return null;
    }
}