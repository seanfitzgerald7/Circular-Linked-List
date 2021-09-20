package fitzgerald.sean;

import java.util.Arrays;

/**
* @version Starter Code
* @author Katie Timmerman
*/
public class SortingProject {

   //You should change this size as you are testing your program
   final static int LIST_SIZE = 5;

   /**
    * This is the method where your program begins running. Once this method is
    * done your program is done.
    */
   public static void main(String[] args) {
       testingMyCircularLL();
       // testSorts();
       return;

   }

   /**
    * This method tests the functionality of MyCircularLL
    */
   private static void testingMyCircularLL() {

       System.out.println("*** TESTING CONSTRUCTOR ***");
       MyCircularLL list = new MyCircularLL();
       System.out.println("List should be []: " + list);

       System.out.println("*** TESTING ADD ***");
       list.add(12);
       list.add(10);
       System.out.println("The list should be [10 12]: " + list);

       System.out.println("*** TESTING APPEND ***");
       list.append(14);
       System.out.println("The list should be [10 12 14]: " + list);

       System.out.println("*** TESTING REMOVE ***");
       list.remove();
       System.out.println("The list should be [12 14]: " + list);

       System.out.println("*** TESTING ADD AFTER REMOVE ***");
       list.add(8);
       System.out.println("The list should be [8 12 14]: " + list);

       System.out.println("*** TESTING INDEXOF ***");
       System.out.println("The index of 8 should be 0: " + list.indexOf(8));
       System.out.println("The index of 14 should be 2: " + list.indexOf(14));
       System.out.println("The index of 9 should be -1: " + list.indexOf(9));

       System.out.println("*** TESTING INDEXOF AFTER REMOVE ***");
       list.remove(12);
       System.out.println("The list should be [8 14]: " + list);
       System.out.println("The index of 12 should be -1: " + list.indexOf(12));

       System.out.println("*** TESTING EMPTY ***");
       list.empty();
       System.out.println("The list should be []: " + list);
       System.out.println("The index of 8 should be -1: " + list.indexOf(8));

       System.out.println("*** TESTING METHODS AFTER EMPTY ***");
       list.add(6); // failing to add 6
       list.append(9);
       list.add(4);
       list.add(3);
       list.add(2);
       list.append(10);

       System.out.println("The list should be [2 3 4 6 9 10]: " + list);
       list.remove(2);
       System.out.println("The list should be [3 4 6 9 10]: " + list);
       list.remove(10);
       System.out.println("The list should be [3 4 6 9]: " + list);

       System.out.println("The index of 2 should be -1: " + list.indexOf(2));
       System.out.println("The index of 10 should be -1: " + list.indexOf(10));
       System.out.println("The index of 3 should be 0: " + list.indexOf(3));
       System.out.println("The index of 9 should be 3: " + list.indexOf(9));

   }

   /**
    * Method tests all the sorting algorithms It creates lists using
    * createUnsorted<List>(). It then prints lists. It will sort the lists Then
    * it will re-print lists.
    */
   private static void testSorts() {
       //create lists
       // MyCircularLL list1 = createUnsortedListLL();
       int[] list2 = createUnsortedListArray();
       // int[] list3 = createUnsortedListArray();

       //print lists
       // System.out.println("Prior to Sorting:");
       // System.out.println("List 1: " + list1);
       System.out.println("List 2: " + getArrayString(list2));
       // System.out.println("List 3: " + getArrayString(list3));

       //Sort
       // list1 = sortListSortOne(list1);
       list2 = sortListSortTwo(list2);
       // list3 = sortListSortThree(list3);

       //re-print Lists
       // System.out.println("\nAfter Sorting:");
       // System.out.println("List 1: " + list1);
       System.out.println("List 2: " + getArrayString(list2));
       //System.out.println("List 3: " + getArrayString(list3));

   }

   /**
    * Sorts the list using insertion sort.
    *
    * @param listLL
    */
   private static MyCircularLL sortListSortOne(MyCircularLL listLL) {
       //uncomment this line if you wish to write the sort inside the LL class
       //listLL.sortOne();
       return listLL;
   }

   /**
    * Sorts the list using merge sort.
    *
    * @param listArray
 * @return 
    */
   private static int[] sortListSortTwo(int[] listArray) {
	   // O(n log n) runtime (best and worst case)
	   if (listArray.length <= 1) return listArray;
	   
	   int mid = listArray.length / 2;
	   
	   int[] left = new int[mid];
	   int[] right = null;
	   // finding middle of array, setting right array to mid or mid +1 if odd or even divide
	   if (listArray.length % 2 == 0) right = new int[mid];
	   if (listArray.length % 2 != 0) right = new int[mid + 1];
	   
	   // both loops assign respective elements to their array
	   for (int i = 0; i < mid; i++) {
		   left[i] = listArray[i];
	   }
	   
	   for (int j = 0; j < right.length; j++) {
		   right[j] = listArray[mid + j];
	   }
	   // calling function again on left and right arrays, the recursive part, which what makes merge sort O(n log n)
	   // Divide and conquer
	   int[] result = new int[listArray.length];
	   left = sortListSortTwo(left);
	   right = sortListSortTwo(right);
	   
	   // Calling merge_sort function to merge left and right arrays together
	   result = merge_sort(left, right);
	   return result;
   }
   
   private static int[] merge_sort(int[] left, int[] right) {
	   // merge method
	   int[] result = new int[left.length + right.length];
	   
	   // declaring pointers for left, right and result arrays
	   int l, r, rp;
	   l = r = rp = 0; // initializing
	   
	   // loop through left and right arrays while either of them have elements
	   while (l < left.length || r < right.length) {
		   
		   // check if both left and right arrays have elements
		   if (l < left.length && r < right.length) {
			   if (left[l] < right[r]) {
				   result[rp++] = left[l++];
			   } else {
				   result[rp++] = right[r++];
			   }
		   } 
		   
		   else if (l < left.length) { 
			   // checks whether left or right pointer is less than its given arrays length (Only if one of them has elements)
			   result[rp++] = left[l++];
		   } 
		   else if (r < right.length) {
			   result[rp++] = right[r++];
		   }
	   }
	   
	   return result;
   }
   
   

 
   /**
    * Create your own sorting algorithm.
    * 
    * Explain your improvement here.
    *
    * @param listArray
    */
   private static int[] sortListSortThree(int[] listArray) {
	   
	   if (listArray.length <= 1) return listArray;
	   
	   int[] newL = new int[listArray.length];
	   int comparison = listArray[listArray.length - 1] - listArray[0];
	   for (int i = 0; i < listArray.length - 1; i++ ) {
		   if (listArray[i] < comparison) {
			   newL = addToFront(newL, listArray[i]);
			   comparison = listArray[i];
		   }
		   else if (listArray[i] > comparison) {
			   newL = addToBack(newL, listArray[i]);
			   comparison = listArray[i];
		   }
		   else {
			   sortListSortThree(newL);
		   }
	   }
	   
	   
	   return newL;
	   
   }
   
   private static int[] addToFront(int[] newL, int num) {
	   if (newL.length == 0) {
		   newL[0] = num;
		   return newL;
	   }	   
	   int[] newArray = Arrays.copyOf(newL, newL.length + 1);
	   newArray[0] = num;
	   System.arraycopy(newL, 0, newArray, 1, newL.length);
	   return newArray;
   }
   
   private static int[] addToBack(int[] newL, int num) {
	   if (newL.length == 0) {
		   newL[0] = num;
		   return newL;
	   }
	   int[] newArray = Arrays.copyOf(newL, newL.length + 1);
	   newArray[newArray.length - 1] = num;
	   return newArray;
   }
   

   /**
    * Creates an array of LIST_SIZE that is filled with random integers between
    * 0 and 999.
    *
    * @return
    */
   private static int[] createUnsortedListArray() {
       int[] ary = new int[LIST_SIZE];
       for (int i = 0; i < LIST_SIZE; i++) {
           ary[i] = (int) (Math.random() * 1000);
       }
       return ary;
   }

   /**
    * Creates a MyCircularLL of LIST_SIZE that is filled with random integers
    * between 0 and 999.
    *
    * @return
 * @throws Exception 
    */
   private static MyCircularLL createUnsortedListLL() {
       MyCircularLL linkedList = new MyCircularLL();
       for (int i = 0; i < LIST_SIZE; i++) {
           int value = (int) (Math.random() * 1000);
           linkedList.add(value);
       }
       return linkedList;
   }

   /**
    * Returns a string representation of array ary as "[n1 n2 n3 ]"
    * @param ary
    * @return 
    */
   private static String getArrayString(int[] ary) {
       String s = "[";
       for (int i = 0; i < ary.length; i++) {
           s += ary[i] + " ";
       }
       s += "]";
       return s;
   }
}