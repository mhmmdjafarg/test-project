class Pair<K, V> {
    @Override
    public String toString() {
        return "Pair{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    // Getter methods for key and value (optional)
    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
