import java.util.*;
class Node{
	char data;	
	Node next;
}
class LinkedList{
	Node head;
	public static void main(String[] args){
		LinkedList obj = new LinkedList();
		Scanner in = new Scanner(System.in);
		System.out.println("Enter your name: ");
		String name = in.nextLine();
		obj.create(name);
		obj.swap();
		obj.display();
	}
	void swap(){
		Node temp = head.next;
		Node headTemp = head;
		while(headTemp.next != null && temp.data != '0'){
			char name = temp.data;
			temp.data = headTemp.data;
			headTemp.data = name;
			temp = temp.next.next;
			headTemp = headTemp.next.next;
		}
	}
	void create(String name){
		head = new Node();
		Node headTemp = head;
		int i  = 0;
		while(i < name.length()){
			headTemp.data = name.charAt(i);
			++i;
			headTemp.next = new Node();
			headTemp = headTemp.next;
		}	
		headTemp.data = '0';
		headTemp.next = null;
		
	}
	

	void display(){
		if(head == null){
			System.out.println("Create a LinkedList first!");
			return;
		}
		Node headCopy = head;
		while(headCopy.next.data != '0'){
			System.out.print(headCopy.data);
			headCopy = headCopy.next;
		}
		System.out.print(headCopy.data);
		System.out.println();
	}
	
}
