/**
 * 
 */
package com.practice.linkedlist;

/**
 * @author sabaa
 *
 */
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MergeTwoSortedLists merge = new MergeTwoSortedLists();
		Node L1 = new Node(0);
		L1 = merge.createInputLinkedList(L1);
		Node L2 = new Node(0);
		L2 = merge.createInputLinkedList2(L1);
		System.out.println("LIST 1");
		merge.printLinkedList(L1);
		System.out.println("LIST 2");
		merge.printLinkedList(L2);
		System.out.println("MERGED LIST");
		Node mergedList = merge.mergeTwoSortedLists(L1, L2);
		merge.printLinkedList(mergedList);
	}
	
	public Node mergeTwoSortedLists(Node L1, Node L2) {
		if(L2 == null)
			return L1;
		if(L1 == null)
			return L2;
		if(L1.data < L2.data) {
			 L1.next = mergeTwoSortedLists(L1.next,L2);
			 return L1;
		}else {
			 L2.next = mergeTwoSortedLists(L1,L2.next);
			 return L2;
		}
		
		
	}
	public  Node createInputLinkedList(Node head) {
		head = new Node(2);
		head.next = new Node(4);
		head.next.next = new Node(9);		
		return head;
	}	
	public  Node createInputLinkedList2(Node head) {
		head = new Node(5);
		head.next = new Node(6);
		head.next.next = new Node(8);
		return head;
	}
	public  void printLinkedList(Node head) {
		Node temp = head;
	      while(head!=null) {
	    	  System.out.println(head.data);
	    	  head = head.next;
	      }
	     head = temp;
	}

}
/*OUTPUT
 * LIST 1
2
4
9
LIST 2
5
6
8
MERGED LIST
2
4
5
6
8
9
*/
