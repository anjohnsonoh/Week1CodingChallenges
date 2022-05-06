/*
Intersection: Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list is the exact 
same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
public class Node {

	// Java program to return first node of loop
	int key;
	Node next;
	Node(int key)
	{
	    this.key = key;
	    this.next = null;
	}
	static Node findIntersection(Node head, Node head2)
	{
	    int headsize = 0;
	    int head2size = 0;
	    Node current = head;
	    int lastHeadValue= 0;
	    int lastHead2Value = 0;
	    while (current != null)
	    {
	    	headsize++;
	    	//System.out.println(current.key);
	        //System.out.println(headsize);
	       // System.out.println(current.next);
	        lastHeadValue = current.key;
	        current=current.next;

	    }
	    
	    current=head2;
	    while(current!= null)
	    {
	    	head2size++;
	    	lastHead2Value = current.key;
	    	current=current.next;

	    }

	    if(lastHeadValue == lastHead2Value)
	    {
		    if(head2size < headsize)
		    {
		    	current = head;
		    	for(int i = 0; i <(headsize-head2size); i++)
		    	{
		    		current = current.next;
		    	}
		    	Node current2 = head2;
		    	while(current2!= null && head2 !=null)
		    	{
		    		if(current2.key == current.key)
		    		{
		    			return current;
		    		}
		    		else
		    		{
		    			current2 = current2.next;
		    			current = current.next;
		    		}
		    	}
		    }
		    else
		    {
		    	current = head2;
		    	for(int i = 0; i < (head2size-headsize); i++)
		    	{
		    		current = current.next;
		    	
		    	}
		    	Node current2 = head;
		    	while(current2!= null && head2 !=null)
		    	{
		    		if(current2.key == current.key)
		    		{
		    			return current;
		    		}
		    		else
		    		{
		    			current2 = current2.next;
		    			current = current.next;
		    		}
		    	}
		    }
	    }
	    return null;
	}
	 
	public static void main(String[] args)
	{
	    Node head = new Node(43);
	    head.next = new Node(25);
	    head.next.next = new Node(65);
	    head.next.next.next = new Node(42);
	    head.next.next.next.next = new Node(61);
	    head.next.next.next.next.next = new Node(2);
	    Node head2 = new Node(50);
	    head2.next = new Node(71);
	    head2.next.next = new Node(4);
	    head2.next.next.next = head.next.next.next.next;

	    Node res = findIntersection(head,head2);
	    if(res != null)
	        System.out.print("Intersection node is " + res.key);
	    else
	    	System.out.println("No intersection found");
	 
	}
}
	 

