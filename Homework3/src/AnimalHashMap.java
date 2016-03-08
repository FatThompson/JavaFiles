/**
 * Class: AnimalHashMap.java
 * @author Matthew Thompson
 * @version 1.0
 * Course : ITEC 3150 Spring 2016
 * Written: Feb 27, 2016
 *
 *
 * This class – 
 *
 * Purpose: – Describe the purpose of this class 
 */





import java.util.Set;

public class AnimalHashMap implements MyMap<Animal, Double>
{
	Node[] buckets;
	int temp = 300;
	int size = 30;

	/**
	 * default constructor
	 */
	public AnimalHashMap()
	{
		buckets = new Node[temp]; 
	}

	/**
	 * resets the buckets
	 */
	@Override
	public void clear()
	{
		buckets = null;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public boolean containsKey(Animal key)
	{
		// TODO Auto-generated method stub

		//grab the index in buckets
		int bucketIndex = hash(key.hashCode());

		//search for the bucket's node
		if (buckets[bucketIndex] != null) 
		{
			Node bucket = buckets[bucketIndex]; 

			//search nodes for key (animal)
			while (bucket != null)
			{
				if (bucket.data.equals(key)) 
				{
					return true;
				}

				bucket = bucket.next;
			}
		}
		return false;
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	@Override
	public boolean containsValue(Double value)
	{
		//grab the index in buckets
		int bucketIndex = hash(value.hashCode());

		//search for the bucket's node
		if (buckets[bucketIndex] != null) 
		{
			Node bucket = buckets[bucketIndex]; 

			//search nodes for key (animal)
			while (bucket != null)
			{
				if (bucket.data.equals(value)) 
				{
					return true;
				}

				bucket = bucket.next;
			}
		}
		return false;

	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Set<MyMap.Entry<Animal, Double>> entrySet()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	@Override
	public Double get(Animal key)
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public boolean isEmpty()
	{
		// TODO Auto-generated method stub
		return size == 0;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Set<Animal> keySet()
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	@Override
	public Double put(Animal key, Double value)
	{
		// TODO Auto-generated method stub
		if (key != null)
		{
			int bucketIndex = hash(key.hashCode());

			Node n = buckets[bucketIndex];

			while (n != null)
			{
				if (n.data.getKey().equals(key))
				{
					n.data.value = value;
					return value;
				}

				n = n.next;
			}

			Entry<Animal, Double> entry = new Entry<Animal, Double>(key, value);

			Node nextNode = new Node();

			nextNode.data = entry;

			nextNode.next = buckets[bucketIndex];

			buckets[bucketIndex] = nextNode;
		}

		return value;

	}
	
	/**
	 * 
	 * @param key
	 */
	@Override
	public void remove(Animal key)
	{
		// TODO Auto-generated method stub

		//could run contains key, but redundant action. 

		//grab the index in buckets
		int bucketIndex = hash(key.hashCode());

		//search for the bucket's node
		if (buckets[bucketIndex] != null) 
		{
			Node bucket = buckets[bucketIndex]; 

			//search nodes for key (animal)
			while (bucket != null)
			{
				if (key.equals(bucket.data)) 
				{
					bucket = null;
					break;
				}

				bucket = bucket.next;
			}
		}
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public int size()
	{
		// TODO Auto-generated method stub
		return size;
	}
	
	/**
	 * 
	 * @return
	 */
	@Override
	public Set<Double> values()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/** Hash function */
	private int hash(int hashCode) 
	{
		return supplementalHash(hashCode) & (temp - 1);
	}

	/** Ensure the hashing is evenly distributed */
	private static int supplementalHash(int h) 
	{
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);

	}

	/**
	 * 
	 * @author User
	 *
	 */
	class Node
	{
		public Entry<Animal, Double> data;

		public Node next;
	}
}

