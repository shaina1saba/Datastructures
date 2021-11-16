/**
 * 
 */
package com.practice.linkedlist;

import java.util.HashSet;

/**
 * @author sabaa
 * Find the node at which intersection of two singly linked list begins
 * a1->a2-
 * 			\
 * 				c1->c2->c3
 *          /
 * b1->b2->b3
 *
 */
public class IntersectionOfLinkedList {

	/**
	 * @param args
	 */
	static Node l1;
	static Node l2;
	public static void main(String[] args) {
		IntersectionOfLinkedList intersection = new IntersectionOfLinkedList();
		intersection.createInputLinkedList();
		System.out.println("List 1: ");
		intersection.printLinkedList(l1);
		System.out.println("List 2: ");
		intersection.printLinkedList(l2);
		boolean isExist = intersection.doesIntersectionExist(l1, l2);
		System.out.println("Intersection node exist : "+isExist);
		Node L3 = intersection.findIntersectionUsingHashSet(l1,l2);
		System.out.println("Intersection node using hashset : "+L3.data);
		Node L4 = intersection.findIntersectionUsing2ptr(l1,l2);
		System.out.println("Intersection node using 2 ptr : "+L4.data);
	}
	private Node findIntersectionUsing2ptr(Node head1, Node head2) {
		Node ptr1 = head1;
		Node ptr2 = head2;
		
		if(ptr1== null || ptr2== null) {
			return null;
		}
		while(ptr1!=ptr2) {
			ptr1 = ptr1.next;
			ptr2 =ptr2.next;
			
			if(ptr1 == ptr2)
				return ptr1;
			
			if(ptr1==null) {
				ptr1 = head2;
			}
			if(ptr2==null) {
				ptr2 = head1;
			}
			
		}
		return null;
	}
	private Node findIntersectionUsingHashSet(Node l1, Node l2) {
		HashSet<Node> hs = new HashSet<Node>();
		while(l1.next!=null) {
			hs.add(l1);
			l1 = l1.next;
		}
		while(l2.next!=null) {
			if(hs.contains(l2)) {
				return l2;
			}
			l2 = l2.next;
		}
		return null;
	}
	public boolean doesIntersectionExist(Node L1, Node L2) {

		while(L1.next!=null) {
			L1 = L1.next;
		}
		while(L2.next!=null) {
			L2 = L2.next;
		}
		if(L1==L2) {
			return true;
		}
		return false;
	}
	public void createInputLinkedList() {
		l1 = new Node(3);
		l1.next = new Node(6);
		l1.next.next = new Node(9);
		l1.next.next.next = new Node(15);
		l2 = new Node(10);
		l2.next = l1.next.next.next;
		l1.next.next.next.next = new Node(30);
	}
	public  Node createInputLinkedList2(Node head) {
		head = new Node(10);
		head.next = new Node(15);
		head.next.next = new Node(30);
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
