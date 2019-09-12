/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	MyLinkedList<String> list2;
	MyLinkedList<String> list3;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
	    
		shortList.add("A");
		shortList.add("B");
//		shortList.add("C");
		list3 = new MyLinkedList<String>();
		list3.add("a");
		list3.add("d");
		list3.add("c");
		
		
//		System.out.print(shortList.get(0));
//		System.out.print(shortList.get(1));		
//		System.out.print(shortList.get(2));
//		System.out.print(shortList);
//		LLNode<String> current = shortList.head;
//		while(current != null) {  
//            //Prints each node by incrementing the pointer.  
//  
//            System.out.print(current.data + " ");  
//            current = current.next;  
//        }
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
//		List Add at index setup
		list2 = new MyLinkedList<String>();
		list2.add("A");
		list2.add("C");
		list2.add("D");

//		list2.add(list2.size(), "E");
		
	
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
//		System.out.print(shortList);
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		try {
			list1.remove(-1);
			fail("Check remove at low");
		}catch(IndexOutOfBoundsException e){		
		}
		try {
			list1.remove(10);
			fail("Check remove at low");
		}catch(IndexOutOfBoundsException e){		
		}
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		// TODO: Add more tests here
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		assertEquals("Added at the end", (Integer)42,list1.get(2));
		
		try {
			list1.get(5);
			fail("Check out of bounds");
			
		}catch(IndexOutOfBoundsException e) {

		}
		try {
			list1.add(null);
			fail("Check adding null");
			
		}catch(NullPointerException e) {

		}
		
		
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
//		System.out.print("Size:" + list2.size());
		assertEquals("List2 size checks:", 3, list2.size());
		assertEquals("List2 size checks:", 2, shortList.size());
		assertEquals("List2 size checks:", 0, emptyList.size());
		// TODO: implement this test
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		try {
			list2.add(-1, "F");
			fail("Check if adding at index -1 fails.");
		} catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			list2.add(2, null);
			fail("Check adding null");
			
		}catch(NullPointerException e) {

		}
		try {
			list2.add(10, "F");
			fail("Check if adding at index -1 fails.");
		} catch(IndexOutOfBoundsException e) {
			
		}
		list2.add(1, "B");
	 assertEquals("check added B", "B", list2.get(1));
	 list2.add(0, "S");
	 assertEquals("check added S", "S", list2.get(0));
//	 System.out.print("List2 Size: "+list2.get(list2.size()));
//	 assertEquals("check added E", "E", list2.get(list2.size()-1));

		
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
		list3.set(1, "b");
		try {
			list3.set(4, "b");
			fail("Out of bounds error check");
		}catch(IndexOutOfBoundsException e) {
			
		}
		assertEquals("Check for b:","b",list3.get(1));
	    // TODO: implement this test
	    
	}
	
	
	// TODO: Optionally add more test methods.
	
}
