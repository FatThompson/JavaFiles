import java.util.Set;

/**
 * Class: AnimalHashMap.java
 * 
 * @author Arthur Wong
 * @version 1.0
 *          <p>
 * Course : ITEC 3150 Spring 2016 
 * Written: Feb 25, 2016
 * 
 * 
 *  This class – ******
 * 
 *  Purpose: – ******
 */

/**
 * @author arthurwong
 *
 */
public class AnimalHashMap implements MyMap<Animal, Double>
{
	Node[] buckets;
	int temp = 30;
	int size = 0;

	public AnimalHashMap()
	{
		buckets = new Node[temp]; 
	}

	/* (non-Javadoc)
	 * @see MyMap#clear()
	 */
	@Override
	public void clear()
	{
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see MyMap#containsKey(java.lang.Object)
	 */
	@Override
	public boolean containsKey(Animal key)
	{
		int bucketIndex = hash(key.hashCode());

		if (buckets[bucketIndex] != null) 
		{
			Node bucket = buckets[bucketIndex]; 
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

	/* (non-Javadoc)
	 * @see MyMap#containsValue(java.lang.Object)
	 */
	@Override
	public boolean containsValue(Double value)
	{
		for (int i = 0; i < buckets.length; i++)
		{
			if (buckets[i] != null) 
			{
				Node bucket = buckets[i]; 
				while (bucket != null)
				{
					if (bucket.data.equals(value)) 
					{
						return true;
					}

					bucket = bucket.next;
				}
			}
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see MyMap#entrySet()
	 */
	@Override
	public Set<MyMap.Entry<Animal, Double>> entrySet()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see MyMap#get(java.lang.Object)
	 */
	@Override
	public Double get(Animal key)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see MyMap#isEmpty()
	 */
	@Override
	public boolean isEmpty()
	{
		return size == 0;
	}

	/* (non-Javadoc)
	 * @see MyMap#keySet()
	 */
	@Override
	public Set<Animal> keySet()
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see MyMap#put(java.lang.Object, java.lang.Object)
	 */
	@Override
	public Double put(Animal key, Double value)
	{
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

	/* (non-Javadoc)
	 * @see MyMap#remove(java.lang.Object)
	 */
	@Override
	public void remove(Animal key)
	{
		if (!containsKey(key))
		{
			return;
		}

		int bucketIndex = hash(key.hashCode());

		// Create a linked list for the bucket if it is not created
		if (buckets[bucketIndex] != null) 
		{
			Node bucket = buckets[bucketIndex]; 

			while (bucket != null)
			{
				if (key.equals(bucket.data)) 
				{
					bucket = null;
					break;
				}
			}

		}

		// Decrease size
		size--; 
	}

	/* (non-Javadoc)
	 * @see MyMap#size()
	 */
	@Override
	public int size()
	{
		return size;
	}

	/* (non-Javadoc)
	 * @see MyMap#values()
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

	class Node
	{
		public Entry<Animal, Double> data;

		public Node next;
	}

}
