
public class Stack {
int Max =100;
int top;
int a[]=new int[Max];

//function to check stack is empty
boolean isEmpty() {
	if(top<0) {
		System.out.println("Stack is emty");
		return true;
	}else
	{
		System.out.println("Stack is not empty");
		return false;
	}
	
}

//function to return top element

int peek() {
if(top<0) {
System.out.println("No element in stack");
return 0;
}else{
int x=a[top];
System.out.println("Top element is : "+x);
return 1;
}
}

//Push function 

boolean push(int x) {
	if(top>Max-1) {
		System.out.println("Stack Overflow");
		return false;
		}else{
		top=top+1;
		a[top]=x;
		System.out.println(x + "Element pushed in stack");
		return true;
		}
}

//Pop function

int pop() {
	if(top <0) {
		System.out.println("Stack Underflow");	
		return 0;
	}
	else
	{
		int x =a[top];	
		top=top-1;
		System.out.println(x + "elemet popped from stack");
		return x;
	}
}
}

//Driver Code
class Main {
public static void main(String[] args)	{
	Stack s= new Stack();
	s.push(10);
	s.push(20);
	s.peek();
	s.pop();
	s.isEmpty();
}
}