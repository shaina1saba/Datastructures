/**
 * 
 */
package com.practice.linkedlist;

/**
 * @author sabaa
 *
 */
public class SwapListNodesInPair {

	Node head;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwapListNodesInPair sp = new SwapListNodesInPair();
		System.out.println("Creating input linked list");
		sp.createInputLinkedList();
		System.out.println("Linked List before Swap");
		sp.printLinkedList();
		sp.pairWiseSwap();
		System.out.println("Linked List after Swap");
		sp.printLinkedList();

	}

	public  void pairWiseSwap() {
		Node p = head;
		while(p!=null && p.next!=null) {
			int temp = p.data;
			p.data = p.next.data;
			p.next.data = temp;			
			p = p.next.next;			
		}

	}
	
	public  void printLinkedList() {
		Node temp = head;
	      while(head!=null) {
	    	  System.out.println(head.data);
	    	  head = head.next;
	      }
	     head = temp;
	}
	
	public  void createInputLinkedList() {
		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
	}
/* Output printed
 * Creating input linked list
Linked List before Swap
1
2
3
4
5
6
Linked List after Swap
2
1
4
3
6
5
 */
}
