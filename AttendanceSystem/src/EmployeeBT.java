import java.lang.*;
import java.util.ArrayList;
import java.io.*;

public class EmployeeBT {
EmployeeNode root;
int count =0, max =0;

public EmployeeNode getRoot() {
return this.root;	
}

//Add element in BT
public EmployeeNode addRecursive(EmployeeNode N, int value) {
    if (N == null) {
        return new EmployeeNode(value);
    }
 
    if (value < N.get_empid()) {
        N.left = addRecursive(N.left, value);
    } else if (value > N.get_empid()) {
        N.right = addRecursive(N.right, value);
    } else {
        // value already exists
    N.attCount=N.attCount+1;
    }
//    System.out.println("N==");
//    System.out.println(N.get_empid());
    return N;
    
}

public void add(int value) {
    root = addRecursive(root, value);
//    System.out.println("root==");
//    System.out.println(root.empId);
//    System.out.println("Left==");
//    System.out.println(root.left);
//    System.out.println("Right==");
//    System.out.println(root.right);
}

//Find employee in records (BT)
public boolean containsNodeRecursive(EmployeeNode N, int value) {
    if (N == null) {
        return false;
    } 
    if (value == N.get_empid()) {
        return true;
    } 
    //ternary operator
    return value < N.get_empid()
      ? containsNodeRecursive(N.left, value)
      : containsNodeRecursive(N.right, value);
}

//Search employee ID
public boolean searchID(int value) {
    return containsNodeRecursive(root, value);
}


//get the headcount

public int getHeadCount(EmployeeNode root) {
if	(root==null) {
	return count;
}
count = count +1;
count = getHeadCount(root.left);
count = getHeadCount(root.right);
//System.out.println("count==");
//System.out.println(count);
return count;
}


//How often

//EmployeeNode get_employee_data(EmployeeNode N, int value) {	
//	EmployeeNode P = N ;
//	  if (P == null) {
//	      return P;
//	  } 
//	  
//	  if (value == P.get_empid()) {
//	      return P;
//	  } 
//	  
//	  
//	  //ternary operator
//	 System.out.println("n.getemp id======="+P.get_empid()); 
//	  if (value < P.get_empid()) {
//		  System.out.println("value is lesser");
//		  get_employee_data(P.left, value);  
//		  
//	  } else if(value > P.get_empid()) {
//		  System.out.println("value gretaer");
//		  System.out.println("n.right"+P.right);
//		  System.out.println("vALUE"+value);
//		get_employee_data(P.right, value);
//	  } else {
//		  System.out.println("p1");
//		  return P;
//	  }
//	  
//	  System.out.println("p"+P);
//
//	return P;
//	  
//	}



public int isPresent(EmployeeNode N, int value) {
//	System.out.println("N node=="+N.empId);	
	int returnVal=0;
	if (N == null) {
		System.out.println("N is null");
		return returnVal;
		
	} else if (N.empId == value){
		
		//				System.out.println("N node=="+N.empId);	
//						System.out.println("value is equal");	
//						System.out.println("N node=="+N);
						returnVal = N.attCount;
//						System.out.println("value matched");
//						System.out.println("count is=="+returnVal);
					    return returnVal;
	}else {
	
		
						if(N.empId > value){
							// check if the sub trees
				//			System.out.println("N node=="+N.empId);	
//							System.out.println("value is lesser");	
							returnVal=isPresent(N.left, value);
							return returnVal;
						} else if(N.empId < value) {
							
				//			System.out.println("N node=="+N.empId);	
//							System.out.println("value is greater");	
							returnVal=isPresent(N.right, value);
							return returnVal;
						}
	}
						
//		System.out.println("N emp=="+N.empId);	
//	    System.out.println("returnVal=="+returnVal);	
	   return returnVal;
}

int howOften(EmployeeNode N, int value) {
	//System.out.println("root=="+root.empId);
	int x = isPresent(N, value);
	System.out.println("x value=="+x);	
	if (x % 2==0) {
			return (x/2);
	}else {
		return(x/2 + 1);
	}
	
}
	





//Frequent Visitor

int get_max_vist(EmployeeNode N) {	
if (N != null) {
		max = N.get_count();
//		System.out.println("max1 value is "+max);
		max = Math.max(max,get_max_vist(N.left));
//		System.out.println("max2 value is "+max);
		max = Math.max(max,get_max_vist(N.right));
//		System.out.println("max3 value is "+max);
		return max;
		  } 
//System.out.println("max value is "+max);
return max;
}



int frequentVisitor(EmployeeNode N) {	
int emp_val=0;
if (N != null) {
		if(N.attCount==max) {
			emp_val =N.get_empid();
			return emp_val;
		}else {
			emp_val=frequentVisitor(N.left);
			emp_val=frequentVisitor(N.right);
			return emp_val;
		}
}
//System.out.println("Employee ID is "+emp_val);
return emp_val;
	}


public void printRangePresent(EmployeeNode N, int id1, int id2) throws IOException{
	// Creating a File object that represents the disk file. 
    PrintStream o = new PrintStream(new File("output.txt")); 

    // Store current System.out before assigning a new value 
    PrintStream console = System.out; 

    // Assign o to output stream 
    System.setOut(o); 
    condition_match(N,id1,id2); 

    // Use stored value for output stream 
    System.setOut(console); 
//    System.out.println("This will be written on the console!"); 
}

public void condition_match(EmployeeNode N, int id1, int id2) {
	if (N != null) {
//		System.out.println(N.get_empid());
//		System.out.println(id1);
//		System.out.println(id2);
		
		if(N.get_empid()>=id1 && N.get_empid()<=id2) {
		System.out.println(N.get_empid()+","+N.get_count());
		condition_match(N.left, id1, id2);
		condition_match(N.right, id1, id2);
}
}
}

}

	