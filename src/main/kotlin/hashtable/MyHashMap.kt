package hashtable

class MyHashMap() {

    /** Initialize your data structure here. */
    private var store: Array<Int?> = Array(size = 1_000_000) { null }

    /** value will always be non-negative. */
    fun put(key: Int, value: Int) {
        store[key] = value
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    fun get(key: Int): Int {
        return store[key] ?: -1
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    fun remove(key: Int) {
        store[key] = null
    }

}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * var obj = MyHashMap()
 * obj.put(key,value)
 * var param_2 = obj.get(key)
 * obj.remove(key)
 */