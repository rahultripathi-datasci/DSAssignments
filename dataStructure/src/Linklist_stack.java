import java.util.*;

///////////////////////////////////////////Defined the Node structure/////////////////////////////////////
//Creating class node
class Node{
	int data;
	Node link;
	
	//initialize the values using constructor
	
	public Node() {
		link = null;
		data =0;
	}
	
	public Node(int d,Node n) {
		data = d;
		link = n;
	}
	
	//Function to set link
	
	public void setlink(Node n) {
		link =n;
	}
	
	//function to set data to current node
	
	public void setdata(int d) {
		data = d;
	}
	
	//function to get a link
	
	public Node getlink() {
		return link;
	}
	
	
	//function to get data
	
	public int getdata() {
		return data;
	}
}

///////////////////////////////////Implementation of stack using link list//////////////////////////
public class Linklist_stack {
Node top;
int size;

//initialize the size using constructor

public Linklist_stack() {
	top=null;
	size=0;
}

//function check stack is empty

public boolean isEmpty() {
	if(top==null) {
		//System.out.println("Stack is empty");
		return true;
	}
	else {
		//System.out.println("Stack is not empty");
		return false;
	}
}

//Function to get size of stack

public int getsize() {
	return size;
}

//Function to push element into stack
public void push(int data) {
	Node n1 = new Node (data, null);
	if (top==null)
		top=n1;
	else {
		n1.setlink(top);//here we assign the address of top most element to the address part of newly created node
		top=n1;//Not Newly created node will become top most element and hence assigning it as a top
	}
	size=size+1;
}

//Function to pop element from stack

public void pop() {
	if (isEmpty()) {
		System.out.println("Stack is empty");
	}
	else {
		Node n2 =top;
		top = n2.getlink();
		size=size-1;
		System.out.println("Pop element is : " + n2.getdata());
	}
}

public void peek() {
	if (top==null)
		System.out.println("Stack is empty");
	else {
		
	}
	   
	
}
}
