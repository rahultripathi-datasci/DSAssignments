
public class EmployeeNode{
	int empId, attCount;
	EmployeeNode left, right;

	//Constructor
	public EmployeeNode(int item) 
    { 
		empId = item;
		attCount=1;
        left = right = null; 
    } 
		
	// include all basic functions for the node
	
	EmployeeNode get_right_Node(EmployeeNode E) {
	return E.right;
	}
	
	EmployeeNode get_left_Node(EmployeeNode E) {
		return E.left;	
		}
		
	// Return the data from employee Node
	
	int get_empid() {
		return this.empId;
	}
	
	int get_count() {
		return this.attCount;
	}
}
