package _07_hash;

public class MyHash<K, V> {

    private static final int DEFAULT_INITIAL_CAPACITY = 8;

    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;
    private int use;

    public MyHash() {
        table = new Entry[DEFAULT_INITIAL_CAPACITY];
    }

    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {
        int index = hashIndex(key);
        if (table[index] == null) {
            table[index] = new Entry<>(null, null, null);
        }

        Entry<K, V> tmp = table[index];
        if (tmp.next == null) {
            tmp.next = new Entry<>(key, value, null);
            size++;
            use++;
            if (use >= table.length * LOAD_FACTOR) {
                resize();
            }
        } else {
            while (tmp.next != null) {
                tmp = tmp.next;
                if (tmp.key == key) {
                    tmp.value = value;
                    return;
                }
            }

            Entry<K, V> temp = table[index].next;
            table[index].next = new Entry<>(key, value, temp);
            size++;
        }
    }

    public V get(K key) {
        int index = hashIndex(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null) {
            return null;
        }
        while (e.next != null) {
            e = e.next;
            if (key == e.key) {
                return e.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hashIndex(key);
        Entry<K, V> e = table[index];
        if (e == null || e.next == null) {
            return;
        }

        Entry<K, V> pre;
        while (e.next != null) {
            pre = e;
            e = e.next;
            if (key == e.key) {
                pre.next = e.next;
                size--;
                if(table[index].next==null) {
                    use--;
                }
                return;
            }
        }
    }

    private int hashIndex(K key) {
        if (key == null) {
            return 0;
        }
        int h;
        return ((h = key.hashCode()) ^ (h >>> 16)) & (table.length - 1);
    }

    private void resize() {
        Entry<K, V>[] oldTable = table;
        table = new Entry[table.length << 1];
        use = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if (oldTable[i] == null || oldTable[i].next == null) {
                continue;
            }

            Entry<K, V> e = oldTable[i];
            while (e.next != null) {
                e = e.next;
                int index = hashIndex(e.key);
                if (table[index] == null) {
                    use++;
                    table[index] = new Entry<>(null, null, null);
                }
                table[index].next = new Entry<>(e.key, e.value, table[index].next);
            }
        }
    }

    public void printAll() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null && table[i].next != null) {
                Entry<K, V> tmp = table[i].next;
                while (tmp != null) {
                    System.out.println("key=" + tmp.key + ",value=" + tmp.value);
                    tmp = tmp.next;
                }
            }
        }
        System.out.println("capacity=" + table.length + ",size=" + size + ",use=" + use);
    }

    public static void main(String[] args) {
        var map = new MyHash<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        map.put("c", "c");
        map.printAll();
        map.put("c", "d");
        map.printAll();
        map.remove("c");
        map.printAll();
        System.out.println(map.get("b"));
    }
}
