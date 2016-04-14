package mapping;
/**
 * Class: MyHashMap
 * 
 * @author Dr. Johnson- revised from textbook example 
 * 
 * @version 1.0 Course : ITEC 3150, Spring, 2016
 *  Written: February, 2016
 * 
 * 
 *          This class : Contains an implementation of a HashMap that does not
 *          use the library linked list.
 * 
 *          Purpose: This class is created for use in Spring, 2016 Homework 3
 *
 */

public class MyHashMap<K, V> 
{

    // Define the default hash table size.
    private static int DEFAULT_INITIAL_CAPACITY = 30;

    private int capacity = DEFAULT_INITIAL_CAPACITY;

    // The number of entries in the map
    private int size = 0;

    // Hash table is an array with each cell that is a linked list
    private MapNode<K,V>[] table =  new MapNode[30];
   
    /*
     * Method: constructor
     * 
     * Constructs a Hashmap with the default capacity and load factor
     * 
     */
    public MyHashMap()
    {
        size = 0;
    }

   
    /** 
     * Name: clear()
     * 
     * Removes all of the entries from this map
     * 
     **/
     
    public void clear()
    {
        size = 0;
        removeEntries();
    }

   
    /** 
     * Name: containsKey
     * 
     * Return true if the specified key is in the map
     * 
     * @param K key to search for
     * @return boolean - true if key present
     **/ 
     
    public boolean containsKey(K key)
    {
        return get(key) != null;
    }

     
    /** 
     * Name: containsValue
     * 
     * Return true if the specified value is in the map
     * 
     * @param V value to search for
     * @return boolean - true if value present
     **/ 
    public boolean containsValue( V value)
    {
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                MapNode bucket = table[i];
                while (bucket != null)
                {
                    Entry<K, Double> entry = bucket.data;
                    if (entry.getValue() == value)
                        return true;
                    bucket = bucket.next;
                }
            }
        }

        return false;
    }

     
    /** 
     * Name: entrySet
     * 
     * Return a set of entries in the map
     * 
     * 
     * @return Set of entries
     **/ 
    public java.util.Set<Entry<K, V>> entrySet()
    {
        java.util.Set<Entry<K, V>> set = new java.util.HashSet<Entry<K, V>>();

        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                MapNode bucket = table[i];
                while (bucket != null)
                {
                    Entry<K, V> entry = bucket.data;
                    set.add(entry);
                    bucket = bucket.next;
                }

            }
        }

        return set;
    }

    /** 
     * Name: get
     * 
     * Return a value from the map associated with a key
     * 
     * @param K - the key 
     * @return V the value - null if not present
     **/ 
    public V get(K key)
    {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null)
        {
            MapNode bucket = table[bucketIndex];
            while (bucket != null)
            {
                Entry<K, Double> entry = bucket.data;
                if (entry.getKey().equals(key))
                    return (V) entry.getValue();
                bucket = bucket.next;
            }
        }

        return null;
    }

    /** 
     * Name: isEmpty
     * 
     * Return true if this map contains no entries
     * 
     * 
     * @return boolean - true if empty
     **/ 
    public boolean isEmpty()
    {
        return size == 0;
    }

     
    /** 
     * Name: keySet
     * 
     * Return a set consisting of the keys in this map
     * 
     * 
     * @return Set
     **/ 
    public java.util.Set<K> keySet()
    {
        java.util.Set<K> set = new java.util.HashSet<K>();

        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                MapNode bucket = table[i];
                while (bucket != null)
                {
                    Entry<K, Double> entry = bucket.data;
                    set.add(entry.getKey());
                    bucket = bucket.next;
                }
            }
        }

        return set;
    }

     
    /** 
     * Name: put
     * 
     *  Add an entry (key, value) into the ma
     * 
     * 
     * @param K - the key
     * @param V  - the value
     **/ 
    public V put(K key, V value)
    {
        if (get(key) != null)
        { // The key is already in the map
            int bucketIndex = hash(key.hashCode());
            MapNode bucket = table[bucketIndex];
            while (bucket != null)
            {
                Entry<K, V> entry = bucket.data;
                if (entry.getKey().equals(key))
                {
                    V oldValue = entry.getValue();
                    // Replace old value with new value
                    entry.value = value;
                    // Return the old value for the key
                    return oldValue;
                }
                bucket = bucket.next;
            }

        }
        int bucketIndex = hash(key.hashCode());
        
        

        // Add a new entry (key, value) to hashTable[index]
        MapNode newNode= new MapNode();
        newNode.data = (new Entry<K, V>(key, value));
        newNode.next = table[bucketIndex];
        table[bucketIndex] =newNode;

        size++; // Increase size

        return value;
    }

     
    /** 
     * Name: remove
     * 
     *  Remove the entry for the specified key
     * 
     * 
     * @param K - the key
     **/ 
    public void remove(K key)
    {
        int bucketIndex = hash(key.hashCode());

        // Remove the first entry that matches the key from a bucket
        if (table[bucketIndex] != null)
        {
           MapNode bucket = table[bucketIndex];
           MapNode previous = null;
            while (bucket != null)
            {
                Entry<K, Double> entry = bucket.data;
            
                if (entry.getKey().equals(key))
                {
                   // bucket.remove(entry);
                    if (previous == null)
                    {
                        // this is head of list
                        table[bucketIndex]= bucket.next;
                    }
                    else
                    {
                        previous.next = bucket.next;
                    }
                    size--; // Decrease size
                    break; // Remove just one entry that matches the key
                }
                previous = bucket;
                bucket = bucket.next;
                
            }
        }
    }

     
    /** 
     * Name: size
     * 
     *  Returns the number of entries
     * 
     * 
     * @return int
     **/  
    public int size()
    {
        return size;
    }

     
    /** 
     * Name: values
     * 
     *  Returns a set consisting of all the values in the map
     * 
     * 
     * @return Set
     **/  
    public java.util.Set<V> values()
    {
        java.util.Set<V> set = new java.util.HashSet<V>();

        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
               MapNode bucket = table[i];
                while (bucket != null)
                {
                    Entry<K, V> entry = bucket.data;
                    set.add(entry.getValue());
                    bucket = bucket.next;
                }
            }
        }

        return set;
    }

    /** Hash function */
    /** 
     * Name: hash
     * 
     *  Performs the hashCode compression necesary for this implementation
     * 
     * 
     * @return int
     **/  
    private int hash(int hashCode)
    {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    /** 
     * Name: hashSupplemental
     * 
     *  Helper function for hashing function
     * 
     * 
     * @return int
     **/  
    private static int supplementalHash(int h)
    {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

  

    /** 
     * Name: removeEntries
     * 
     *  Removes all the entries in the map
     * 
     * 
     **/  
    private void removeEntries()
    {
        for (int i = 0; i < capacity; i++)
        {
            if (table[i] != null)
            {
                table[i] = null;
            }
        }
    }

    /**
     * Class: MapNode
     * 
     * @author Dr. Johnson
     * 
     * @version 1.0 Course : ITEC 3150, Spring, 2016
     *  Written: February, 2016
     * 
     * 
     *          This class : Contains an implementation of a LinkedList node for
     *          use in a HashMap
     * 
     *          Purpose: This class is created for use in Spring, 2016 Homework 3
     *
     */  

    class MapNode<K,V>
    {
        public Entry<K,V> data;
        public MapNode next;
    }
    
    /**
     * Class: Entry
     * 
     * @author Dr. Johnson- revised from textbook example 
     * 
     * @version 1.0 Course : ITEC 3150, Spring, 2016
     *  Written: February, 2016
     * 
     * 
     *          This class : Contains an implementation of a HashMap Entry
     * 
     *          Purpose: This class is created for use in Spring, 2016 Homework 3
     *
     */

    public  class Entry<K, V>
    {
        K key;
        V value;

        /*
         * Method: constructor
         * 
         * Constructs an entry with specified values
         * 
         * @param K key
         * @param V value
         * 
         */
        public Entry(K key, V value)
        {
            this.key = key;
            this.value = value;
        }

        /*
         * Method: getKey
         * 
         *  Returns key
         * 
         * @return K
         */
        public K getKey()
        {
            return key;
        }

        /*
         * Method: getValue
         * 
         *  Returns value
         * 
         * @return V
         */
        public V getValue()
        {
            return value;
        }

        @Override
        /*
         * Method: toString
         * 
         *  Returns nicely formatted String of the entry
         * 
         * @return String
         */
        public String toString()
        {
            return "[" + key + ", " + value + "]";
        }
    }
}