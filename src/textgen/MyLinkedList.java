package textgen;

import java.util.AbstractList;
import java.util.zip.CheckedOutputStream;

//import com.sun.java.util.jar.pack.ConstantPool.Index;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		LLNode<E> head = new LLNode<E>(null);
		LLNode<E> tail = new LLNode<E>(null);
//		tail = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		LLNode<E> last = head;
		if(element == null) {
			throw new NullPointerException();
		}
		LLNode<E> ll = new LLNode<E>(element);
//		tail.prev = ll;
		if(head == null) {
//			ll.prev = null;
			head = ll;
			tail = head.next;
			size++;
			return true;
		}
		 while (last.next != null)
		 {
		        last = last.next; 
		 }
		 ll.prev = last; 
		 ll.next = tail;
		 last.next = ll;
		 tail = ll.next;
		size++;
		return true;
	}

	public boolean isEmpty() {
		return size==0;
	}
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	
	public E get(int index) 
	{
		// TODO: ImplemeEEnt this method.
		int count = 0;
		LLNode<E> node = head;
		if(head == null || index == -1 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	
		while(node.next != null) {
			if(count==index) {
				return node.data;
			}
			node = node.next;
			count++;
		}
		return node.data;
	
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		LLNode last = head;
		if(element == null) {
			throw new NullPointerException();
		}
		if(index > size || index == -1) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> newNode = new LLNode<E>(element);
		int count=0;
		if(index==0) {
			newNode.prev = null;
			newNode.next = head.next;
			head = newNode;
			tail = head.next;
			size++;
			return;
		}
		while(last.next != null) {
			if(count == index) {
				newNode.next = last;
				newNode.prev = newNode.next.prev;
				last.prev.next = newNode;
				newNode.next.prev = newNode;
			}
			last = last.next;
			count++;
		}
		size++;
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		LLNode<E> last = head;
		int count=0;
		E data = last.data;
		if(index > size || index == -1) {
			throw new IndexOutOfBoundsException();
		}
		if(index == 0) {
			head = head.next;
			size--;
			return data;
		}
		while(last.next != null) {
			if(count == index) {
				last.prev.next  = last.next;
				last.next.prev = last.prev;
				size--;
				return last.data;
			}
			last = last.next;
			count++;
		}
		return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(element == null) {
			throw new NullPointerException();
		}if(index >=size) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> last= head;
		int count =0;
		while(last.next != null) {
			if(count==index) {
				E data = last.data;
				last.data = element;
				return data;
				
			}
			last = last.next;
			count++;
		}
		return null;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
