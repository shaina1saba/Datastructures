/**
 * 
 */
package com.practice.linkedlist;

/**
 * @author sabaa
 *
 */
public class ReorderList {

	Node head;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ReorderList ro = new ReorderList();
		ro.createInputLinkedList();
		System.out.println("Printing before , linked list :");
		ro.printLinkedList();
		ro.reorderList();
		System.out.println("Printing after , linked list :");
		ro.printLinkedList();
	}
	
	public void reorderList() {
		Node node1 = head;
		Node midNode = getMidNode();
		Node node2 = midNode.next;
		midNode.next = null;
		
		node2 = reverseMidNodeToEnd(node2);
		//merge alternate nodes
		Node node = new Node(0); // dummy node
		Node current = node;
		
		while(node1!=null && node2!=null) {
			//first add element from first list
			if(node1!=null) {
				current.next = node1;
				current = current.next;
				node1 = node1.next;
			}
			//add element from second list 
			if(node2!=null) {
				current.next = node2;
				current = current.next;
				node2 = node2.next;
			}
		}
		node = node.next;
		head = node;
	}

	private Node reverseMidNodeToEnd(Node midNode) {
		Node prev = null;
		Node current = midNode;
		Node next;
		
		while(current!=null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		midNode = prev;
		return midNode;
	}

	private Node getMidNode() {
		Node slow = head;
		Node fast = slow.next;
		while(fast!=null && fast.next!=null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow; 
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
	}
	/*
	 * Output printed
	 * Printing before , linked list :
1
2
3
4
5
Printing after , linked list :
1
5
2
4

	 */

}
