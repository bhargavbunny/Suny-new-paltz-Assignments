public class DoubleArraySeq implements Cloneable
	{
		
		private double[] data;
		private int manyItems;
		private int currentIndex;
		
		
		public DoubleArraySeq() 
		{
			manyItems = 0;
			currentIndex = -1;
			data = new double[10];
		}
		
		public DoubleArraySeq(int initialCapacity)
		{
			if(initialCapacity > 0)
			{
				try
				{
					data = new double[initialCapacity];
					currentIndex = -1;
				}
				catch (OutOfMemoryError outofMemory)
				{
					throw outofMemory;
				}	 
			}
			else
			{
				throw new IllegalArgumentException("DoubleArraySeq: Can not have a zero or negative capacity");
			}
			
			
		}
		
		
		public void addAfter(double element)
		{
			if ((manyItems) == data.length)
				ensureCapacity(manyItems * 2);
			
			if (!isCurrent ())
				data[manyItems] = element;
			else
			{
				for (int i = manyItems; i > currentIndex; i--)
				{
					data[i] = data[i-1];
				}
				data[currentIndex+1] = element;
			}
			manyItems++;
			currentIndex++;
		}

		
		public void addBefore(double element)
		{
			int sequencePosition = 0;
			if ((manyItems) == data.length)
				ensureCapacity(manyItems * 2);
			
			if (isCurrent ())
				sequencePosition = currentIndex;
			
			for (int i = manyItems+1; i >= sequencePosition; i--)
		    {
				data[i] = data[i-1];
			}
			data[sequencePosition] = element;
			manyItems++;
			currentIndex = sequencePosition;
		}
		
		
		public void trimToSize()
		{
			double[] trimmedArray;
			if (data.length != manyItems)
			{
				trimmedArray = new double[manyItems];
				System.arraycopy(data, 0, trimmedArray, 0, manyItems);
				data = trimmedArray;
			}
		}
		
		
		public void addAll (DoubleArraySeq addend)
		{
			if (addend == null)
				throw new IllegalArgumentException("addAll : Array can not be null");
			else
			{
				ensureCapacity(manyItems + addend.manyItems);
		   		System.arraycopy(addend.data, 0, data, manyItems, addend.manyItems);
				manyItems = manyItems + addend.manyItems;
		   }
		}
		
				public void advance()
		{
			if (currentIndex < manyItems)
				currentIndex++;
		}
		
		
		public DoubleArraySeq clone()
		{
			DoubleArraySeq answer;
			try 
			{
				answer = (DoubleArraySeq) super.clone();
			}
			catch (CloneNotSupportedException e)
			{
				throw new RuntimeException("This class does not implement Cloneable");
			}
			answer.data = data.clone();
			return answer;
		} 
		 
		public static DoubleArraySeq concatenation(DoubleArraySeq s1, DoubleArraySeq s2)
		{
		    if ((s1 == null) || (s2 == null))
			     throw new IllegalArgumentException("catenation: parameters can not be null");
			DoubleArraySeq newSeq = new DoubleArraySeq(s1.manyItems + s2.manyItems);
			System.arraycopy(s1.data, 0, newSeq.data, 0, s1.manyItems);
			System.arraycopy(s2.data, 0, newSeq.data, s1.manyItems, s2.manyItems);
			newSeq.manyItems = s1.manyItems + s2.manyItems;
			return newSeq;
		}
		
			
		public void ensureCapacity(int minimumCapacity)
		{
			int	ensuredCapacity;
	        if(data.length < minimumCapacity) 
	            ensuredCapacity = minimumCapacity;
	        else 
	            ensuredCapacity = data.length;
	        double[] biggerArray = new double[ensuredCapacity];
	        System.arraycopy(data, 0, biggerArray, 0, manyItems);
	        data = biggerArray;
		}
		

		public int getCapacity()
		{
			return data.length;
		}
		

		public double getCurrent()
		{
			if (isCurrent()) 
				return data[currentIndex];
			else
		  		throw new IllegalStateException("there is no current element");
		}
		 

		public boolean isCurrent()
		{
			if (currentIndex == -1)
				return false;
			else
			    return true;
		}
		

		public void removeCurrent()
		{
			if (isCurrent())
			{
				for (int i = currentIndex; i<manyItems-1; i++)
				{
					data[i] = data[i+1];
				}
				manyItems--;
			}
			else 
				throw new IllegalStateException ("removeCurrent: There is no current Element");
		}
		

		public int size()
		{
			return manyItems;
		}
	  

		public void start()
		{
			if (manyItems > 0 ) 
				currentIndex = 0;
			else 
				currentIndex = -1;
		}	
	public void print()
		{
			double answer;
	        System.out.println("length is = " + data.length);
			System.out.println("capacity is = " + manyItems);
	        try {
	        System.out.println(" Current Element = " + getCurrent());
	        } catch(IllegalStateException e) {
	           System.out.println("there is no current element");
	        }
			System.out.print("Elements: ");
	        for(int i = 0; i < manyItems; i++) {
	            answer = data[i];
                System.out.print(answer + " ");
	        }
			System.out.println("\n");
		}	

	}

