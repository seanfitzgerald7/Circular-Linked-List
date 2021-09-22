package fitzgerald.sean;

/**
 * @version Starter Code
 * @author Katie Timmerman modified by Sean Fitzgerald
 */
class MyCircularLL {

    private Node tail;
    
    /**
     * creates an empty list
     */
    public MyCircularLL(){
        tail = null;
    }
    
    /**
     * Adds value to the start of the list
     * @param value 
     */
    public void add(int value) {
    	
    	// O(1) best and worst case complexity
    	
    	if (tail == null) {
    		Node new_node = new Node(value);
    		tail = new_node;
    		tail.next = new_node;
    		return;
    	}
    	
    	
    	if (tail != null && tail.next == null) {
    		Node new_node = new Node(value);
    		tail.next = new_node;
    		new_node.next = tail;
    		return;
    	}

    	Node new_node = new Node(value);
    	Node old_head = tail.next;
    	tail.next = new_node;
    	new_node.next = old_head;
    	
    }
    
      /**
     * Adds value to the end of the list
     * @param value 
     */
    public void append(int value) {
    	// O(1) Constant time
    	// If statements used for pre-requisites (list is empty or only has 1 node)
    	Node new_node = new Node(value);
    	if (tail == null) {
    		tail = new_node;
    		return;
    	}
    	
    	// Sets head to a temporary node
    	// sets new node to head
    	// sets tail to new node
    	// assigns pointer from new node to old head
    	Node temp = tail.next;
    	tail.next = new_node;
    	tail = new_node;
    	new_node.next = temp;

    }
    
    /**
     * removes the first occurrence of item from the list.
     * @param item 
     */
    public void remove(int item){
    	
    	// O(n) time complexity (best case O(1))
    	
    	if (this.tail == null || this.tail.next == null) {
    		if (this.tail.value == item) {
    			this.tail = null;
    			return;
    		}
    	}
    	
    	Node current = tail.next;
    	Node prev = tail;
    	while (current != tail) {
    		if (current.value == item) {
    			prev.next = current.next;
    			current = current.next;
    			prev = prev.next;
    			return;
    		} else {
    			current = current.next;
    			prev = prev.next;
    		}
    	}
    	if (this.tail.value == item) {
    		prev.next = tail.next;
    		tail = prev;
    	}
    	
    }

    /**
     * Removes the first value in the list
     */
    public void remove() {
    	// O(1) constant best and worst case
    	if (tail == null) return;
    	if (tail.next == null && tail != null) {
    		tail = null;
    		return;
    	}
    	tail.next = tail.next.next;
    	return;
    }
    
    
    /**
     * Empties the list
     */
    public void empty() {
    	// O(1) constant best and worst case
    	tail = null;
    }
    
    /**
     * Returns the location of the first occurrence of the value in the list.
     * Returns 0 if it is the first item. return -1 if it isn't in the list
     * @param value 
     */
    public int indexOf(int value){
    	// O(n) average time, best case O(1), worst case O(n)
    	if (this.tail == null) return -1;
    	int index = 0;
    	Node current = this.tail.next;
    	while (current != tail) {
    		if (current.value == value) return index;
    		else {
    			index++;
    			current = current.next;
    		}
    	}
    	if (this.tail.value == value) return index;
    	return -1;
    }
    
    /**
     * This is the method called when a MyLinkList is passed to System.out
     * It determines what is printed
     * @return 
     */
    @Override
    public String toString(){
        if(tail == null){
            return "[]";
        }
        String toPrint = "[ ";
        Node cur = tail.next;
        while(cur != tail){
            toPrint += cur.value + " ";
            cur = cur.next;
        }
        toPrint += cur.value + "]";
        return toPrint;
    }
    
    /**
     * This is a Node class to be used in your linked list.
     */
    private static class Node {
        public Node next;
        public int value;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
        public Node(int value, Node next){
            this.next = next;
            this.value = value;
        }
    }
    /**
     * Insertion sort on circular linked list.
     * Intead of swapping nodes, swap values of nodes to simulate an array-like insertion sort.
     * O(n^2) time complexity
     * @param list
     * @return sorted list
     * @throws Exception
     */
	public MyCircularLL sortOne(MyCircularLL list) throws Exception {
		if (list.tail == null) throw new Exception();
		
		Node current = list.tail.next; // head
		Node insertionPointer = current; // head reference for insertion point
		
		current = current.next; // now 2nd node
		while (current != list.tail.next) { // loop until back at head
			
			insertionPointer = list.tail.next; // set insert pointer to head, current pointer is one ahead
			while (insertionPointer != current) {
				if (insertionPointer.value > current.value) {
					int temp = current.value; 
					current.value = insertionPointer.value;
					insertionPointer.value = temp;
				} else {
					insertionPointer = insertionPointer.next;
				}
			}
			current = current.next;
			
		}
		return list;
	}
	
 
    
}
