public class DoubleNode
{
    private double data;
    private DoubleNode link;   
	public DoubleNode(double initialData, DoubleNode initialLink)
	{
		data = initialData;
		link = initialLink;
	}
	
	public void addNodeAfter(double item)   
	{
		link = new DoubleNode(item, link);
	}          
	
	public double getData( )   
	{
		return data;
	}  
	
	public DoubleNode getLink( )
	{
	  return link;                                               
	} 
	
	public static int listLength(DoubleNode head)
	{
		DoubleNode cursor;
		int answer;
		answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link)
			answer++;
			return answer;
	}
	
	public static DoubleNode[ ] listCopyWithTail(DoubleNode source)
	{
		DoubleNode copyHead;
		DoubleNode copyTail;
		DoubleNode[ ] answer = new DoubleNode[2];
		if (source == null)
			 return answer;
		copyHead = new DoubleNode(source.data, null);
		copyTail = copyHead;
		while (source.link != null)
		{
			source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}
	
	public static DoubleNode listCopy(DoubleNode source)
	{
		DoubleNode copyHead;
		DoubleNode copyTail;
		if (source == null)
			return null;
		copyHead = new DoubleNode(source.data, null);
		copyTail = copyHead;
		while (source.link != null)
		{
		    source = source.link;
			copyTail.addNodeAfter(source.data);
			copyTail = copyTail.link;
		}
		return copyHead;
	}
	
	public static DoubleNode[ ] listPart(DoubleNode start, DoubleNode end)
	{
		DoubleNode copyHead;
		DoubleNode copyTail;
		DoubleNode cursor;
		DoubleNode[ ] answer = new DoubleNode[2];
		copyHead = new DoubleNode(start.data, null);
		copyTail = copyHead;
		cursor = start;
		while (cursor != end)
		{
			cursor = cursor.link;
			if (cursor == null)
				throw new IllegalArgumentException ("end node was not found on the list");
			copyTail.addNodeAfter(cursor.data);
			copyTail = copyTail.link;
		}
		answer[0] = copyHead;
		answer[1] = copyTail;
		return answer;
	}
	
	public static DoubleNode listPosition(DoubleNode head, int position)
    {
    	DoubleNode cursor;
		int i;
		if (position <= 0)
		   throw new IllegalArgumentException("position is not positive");
		 cursor = head;
		 for (i = 1; (i < position) && (cursor != null); i++)
		 cursor = cursor.link;
		return cursor;
	}
	
	public static DoubleNode listSearch(DoubleNode head, double target)
	{
		DoubleNode cursor;
		for (cursor = head; cursor != null; cursor = cursor.link)
			if (target == cursor.data)
				return cursor; 
		return null;
	}
	
	public void removeNodeAfter( )   
	{
		link = link.link;
	}   
	
	public void setData(double newData)   
	{
	  data = newData;
	}
	
	public void setLink(DoubleNode newLink)
    {                    
		  link = newLink;
	}
}

