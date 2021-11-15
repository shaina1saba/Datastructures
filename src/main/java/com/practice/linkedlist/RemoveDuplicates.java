/**
 * 
 */
package com.practice.linkedlist;

/**
 * @author sabaa
 * Remove all occurences of duplicates from a sorted linked list
 * 23->28->28->35->49->49->53-.53
 */
public class RemoveDuplicates {

	static Node head;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RemoveDuplicates rd = new RemoveDuplicates();
		rd.createInputLinkedList();
		System.out.println("Printing before , linked list :");
		rd.printLinkedList(head);
	}
	
	public void removeDuplicates() {
		Node dummy = new Node(0);
		dummy.next = head;
		Node prev = dummy;
		Node current = head;
        Node printNode = current;
		while(current!=null) {
			while(current.next!=null && prev.next.data == current.next.data) {
				current = current.next;
			}
			if(prev.next == current) {
				prev = prev.next;
			}else {
				prev.next = current.next;
			}
			current = current.next;
		}
		System.out.println("Printing after , linked list :");
		printLinkedList(printNode);
		
	}
	public  void printLinkedList(Node node) {
		Node temp = node;
	      while(node!=null) {
	    	  System.out.println(node.data);
	    	  node = node.next;
	      }
	      node = temp;
	}
	public  void createInputLinkedList() {
		head = new Node(23);
		head.next = new Node(28);
		head.next.next = new Node(28);
		head.next.next.next = new Node(35);
		head.next.next.next.next = new Node(49);
		head.next.next.next.next.next = new Node(49);
		head.next.next.next.next.next.next = new Node(53);
		head.next.next.next.next.next.next.next = new Node(53);
	}
}
