public class DoubleLinkedSeq implements Cloneable
{

        	private DoubleNode head;
        	private DoubleNode tail;          
        	private DoubleNode cursor;
  	        private DoubleNode precursor;
        	private int manyNodes;
     
public DoubleLinkedSeq( )			
{
        	head = null;
        	tail = null;
        	cursor = head;
  	        precursor = head;
  	        manyNodes = 0;
}
    
public void addAfter(double element) 
{
   	if(head == null)
{
   		head = new DoubleNode(element, null);
       		tail = head;
       		cursor = head;
   	    	precursor = head;   
}	
   	
   	else  if(cursor.getLink() == null) 
{
         		  tail.addNodeAfter(element);
         		  precursor = tail;
         		  tail = tail.getLink();
         		  cursor = tail;
}       
    	else
{
         	cursor.addNodeAfter(element);
         	precursor = cursor;
         	cursor= cursor.getLink();
}
   	  manyNodes ++;
}
   	
public void addBefore(double element)
 {
      if(isCurrent())
          {
         	  if(cursor==head)
          		 {
              		 cursor = new DoubleNode(element, cursor);
              		 head =cursor;
          		  }
            		else
            		 {
              			  precursor.addNodeAfter(element);
                			  cursor = precursor.getLink();
            		}
            }
        else
        {
                          if(head == null)
          		{
                		head = new DoubleNode(element, null);
                		cursor = head;
                		precursor = head;
                		tail = head;
           		 }
            	      else
          	          {
               	                    precursor.addNodeAfter(element);
            	           }
        }
        manyNodes++;

 }
   
public void addAll(DoubleLinkedSeq addend) 
{
		DoubleNode[] copy;
        	 if(addend == null)
                   throw new NullPointerException("addAll:  addend is null");
        	if(addend.size()>0)
        	    {
       	     copy = DoubleNode.listCopyWithTail(addend.head);
      	      tail.setLink(copy[0]);
      	      copy[1].setLink(null);
      	      tail.setLink(copy[0]);
      	      manyNodes += addend.size();
      	      }    
}   
   
public void advance( )
{	
      if(!isCurrent())
        return;
        precursor = cursor;
        cursor = cursor.getLink();
}
   
public DoubleLinkedSeq clone( )
{
	DoubleLinkedSeq answer;
       DoubleNode[] ans = new DoubleNode[2];
        try{
            answer = (DoubleLinkedSeq) super.clone();
        }
        catch(CloneNotSupportedException e)
        {
            throw new RuntimeException("This class does not implement Cloneable.");
        }
        ans = DoubleNode.listCopyWithTail(head);
        answer.head=ans[0];
        answer.tail=ans[1];
        answer.precursor=precursor;
        answer.cursor=precursor.getLink();
        return answer;
}
   
public static DoubleLinkedSeq catenation(DoubleLinkedSeq s1, DoubleLinkedSeq s2)
{
          if((s1 == null) || (s1 == null))
            throw new NullPointerException("concatenation:   argument is null");
        DoubleLinkedSeq answer = new DoubleLinkedSeq();
        DoubleNode [] copy;
        copy = DoubleNode.listCopyWithTail(s1.head);
        answer.head=copy[0];
        answer.tail=copy[1];
        answer.manyNodes=s1.manyNodes;   
        answer.addAll(s2);
        return answer;
}

public double getCurrent( )
{
      if(!isCurrent())
        throw new NullPointerException("There is no Current element.");
        return cursor.getData();
}

public boolean isCurrent( )
{
       if(cursor == null)
            return false;
        return true;
}
              
public void removeCurrent( )
{		
	if(!isCurrent())
     throw new IllegalStateException("removeCurrent: isCurrent() is null");
        if(tail == head)
        {
            head = null;
            tail = null;
            cursor = head;
            precursor = head;
            manyNodes--;
            return;
        }
        
        if(cursor == tail)
        {
            tail = precursor;
            tail.setLink(null);
            cursor = tail;
            precursor = head;
            while(precursor.getLink() != cursor)
            {
                if(precursor.getLink() == null)
                    break;
                precursor = precursor.getLink();
            }
            manyNodes--;
            return;
        }
        
        if(cursor == head)
        {
            head = head.getLink();
            cursor = head;
            precursor = head;
            manyNodes--;
            return;
        }
        
        cursor = cursor.getLink();
        precursor.setLink(cursor);
        manyNodes--;

}
                 
public int size( )
{		
      return manyNodes;
}
   
public void start( )
{	
      if(head == null)
            cursor = null;
        cursor = head;
        precursor = head;
}

public void print()
{		
    
    System.out.println("   length  "+ size());       
    if(isCurrent())
    System.out.println("   current element = " + getCurrent());
    else
    System.out.println("   there is no current element  ");
    System.out.print(" elements = ");
    for(DoubleNode cur =head; cur != null ; cur =cur.getLink())
    System.out.print(" " +cur.getData()+" ");
    System.out.println("  ");
    }  
}
