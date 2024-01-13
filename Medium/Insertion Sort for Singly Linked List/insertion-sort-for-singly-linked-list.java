//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
class insertion
{
    Node head;  
    Node tail;
	public void addToTheLast(Node node) 
	{
	  if (head == null) 
	  {
	   head = node;
	   tail = node;
	  } 
	  else 
	  {
	   tail.next = node;
	   tail = node;
	  }
	}
      void printList(Node head)
    {
        Node temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	/* Drier program to test above functions */
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();
		 while(t>0)
         {
			int n = sc.nextInt();
			insertion llist = new insertion(); 
			int a1=sc.nextInt();
			Node head= new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new Node(a));
			}
			
        Solution ob = new Solution();
		head = ob.insertionSort(llist.head);
		llist.printList(head);
		
        t--;		
        }
    }}
// } Driver Code Ends


//User function Template for Java

/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }
    */
class Solution
{
    public static Node insertionSort(Node head_ref)
    {
        //code here
        Node sorted = null;

    // Traverse the original list
    Node current = head_ref;
    while (current != null) {
        // Extract the current node's data
        Node nextNode = current.next;  // Store next node for later traversal
        int data = current.data;

        // Find the insertion position in the sorted list
        Node sortedPrev = null;
        Node sortedCurrent = sorted;
        while (sortedCurrent != null && data > sortedCurrent.data) {
            sortedPrev = sortedCurrent;
            sortedCurrent = sortedCurrent.next;
        }

        // Insert the current node at the found position
        current.next = sortedCurrent;  // Link current to its new position
        if (sortedPrev == null) {
            // Insert at the beginning of the sorted list
            sorted = current;
        } else {
            // Insert in the middle or end of the sorted list
            sortedPrev.next = current;
        }

        // Move to the next node in the original list
        current = nextNode;
    }

    return sorted; 
    }
}