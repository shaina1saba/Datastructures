/**
 * 
 */
package com.practice.linkedlist;

/**
 * @author sabaa
 * Remove all duplicates from a sorted linked list
 * 23->28->28->35->49->49->53-.53
 */
public class RemoveDuplicates2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicates2 rm = new RemoveDuplicates2();
		Node head = new Node(0);
		head = rm.createInputLinkedList(head);
		System.out.println("Printing before , linked list :");
		head = rm.printLinkedList(head);
		head = rm.removeDuplicates(head);
		System.out.println("Printing after , linked list :");
		rm.printLinkedList(head);
	}
	
	public Node removeDuplicates(Node head) {
		Node L1 = head;
		Node current = head;
		Node temp = current;
		
		while(current!=null) {
			
			while(temp!=null && temp.data == current.data) {
				temp = temp.next;
			}
			current.next = temp;
			current = current.next;
		}
		return L1;	
	}
	public  Node createInputLinkedList(Node head) {
		head = new Node(23);
		head.next = new Node(28);
		head.next.next = new Node(28);
		head.next.next.next = new Node(35);
		head.next.next.next.next = new Node(49);
		head.next.next.next.next.next = new Node(49);
		head.next.next.next.next.next.next = new Node(53);
		head.next.next.next.next.next.next.next = new Node(53);
		return head;
	}
	public  Node printLinkedList(Node head) {
		Node temp = head;
	      while(head!=null) {
	    	  System.out.println(head.data);
	    	  head = head.next;
	      }
	     return temp;
	}

}
/*OUTPUT
 * Printing before , linked list :
23
28
28
35
49
49
53
53
Printing after , linked list :
23
28
35
49
53

 */