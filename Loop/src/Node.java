/*
Loop Detection: Given a circular linked list, implement an algorithm that returns the node at the beginning of the loop.

DEFINITION:
Circular linked list: A (corrupt) linked list in which a node's next pointer points to an earlier node, 
so as to make a loop in the linked list.

EXAMPLE
Input: A -> B -> C -> D -> E -> C [the same C as earlier]
Output: C
 */
public class Node {

	int key;
	Node next;
	Node(int key)
	{
	    this.key = key;
	    this.next = null;
	}
	static Node findLoopingKey(Node head)
	{
	    Node temp = new Node(1);
	    while (head != null)
	    {
	        if (head.next == null)
	        {
	            return null;
	        }
	        if (head.next == temp)
	        {
	            break;
	        }
	        Node next = head.next;
	 
	        head.next = temp;
	 
	        head = next;
	    }
	 
	    return head;
	}
	 
	public static void main(String[] args)
	{
	    Node head = new Node(43);
	    head.next = new Node(25);
	    head.next.next = new Node(65);
	    head.next.next.next = new Node(42);
	    head.next.next.next.next = new Node(61);
	    head.next.next.next.next.next = new Node(2);
	    head.next.next.next.next.next.next = head.next.next;
	    Node res = findLoopingKey(head);
	    if(res != null)
	        System.out.print("Loop starting node is " + res.key);
	 
	}
}
	 

