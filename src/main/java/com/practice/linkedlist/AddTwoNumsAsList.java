/**
 * 
 */
package com.practice.linkedlist;

/**
 * @author sabaa
 * List 1: 5->6->3      365
 * List 2: 8->4->2      248
 * Output: 3->1->6      613
 *
 */
public class AddTwoNumsAsList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AddTwoNumsAsList addNum = new AddTwoNumsAsList();
		Node L1 = new Node(0);
		L1 = addNum.createInputLinkedList(L1);
		Node L2 = new Node(0);
		L2 = addNum.createInputLinkedList2(L1);
		System.out.println("LIST 1");
		addNum.printLinkedList(L1);
		System.out.println("LIST 2");
		addNum.printLinkedList(L2);
		System.out.println("LIST 3");
		Node L3 = new Node(0);
		Node sum = addNum.addTwoLists(L1, L2, L3);
		addNum.printLinkedList(sum);
	}
	
	public Node addTwoLists(Node L1, Node L2, Node L3) {
		Node sum = L3;
		int carry = 0;
		while(L1!=null || L2!=null) {
			int num1 = L1.data;
			int num2 = L2.data;
			int num3 = num1 + num2 + carry;
			int val = 0;
			 if(num3 >=10) {
				 val = num3 % 10;
				 carry = num3 / 10;
			 }else {
				 val = num3;
				 carry = 0;
			 }
			Node temp = new Node(val);
			L3.next = temp;
			L3 = L3.next;
			if(L1!=null)
			L1 = L1.next;
			if(L2!=null)
			L2 = L2.next;
			
		}
		return sum.next;
	}
	public  void printLinkedList(Node head) {
		Node temp = head;
	      while(head!=null) {
	    	  System.out.println(head.data);
	    	  head = head.next;
	      }
	     head = temp;
	}
	public  Node createInputLinkedList(Node head) {
		head = new Node(5);
		head.next = new Node(6);
		head.next.next = new Node(3);		
		return head;
	}	
	public  Node createInputLinkedList2(Node head) {
		head = new Node(8);
		head.next = new Node(4);
		head.next.next = new Node(2);
		return head;
	}

}
/*OUPUT
 * LIST 1
5
6
3
LIST 2
8
4
2
LIST 3
3
1
6
*/