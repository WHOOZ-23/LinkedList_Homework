package list;

import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
	private Node<T> head;
	protected int size;
	
	private static class Node<T> {
		
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public void add(T data) {
		Node<T> newNode = new Node<>(data);
		
		if (head == null) {
			head = newNode;
		} else {
			Node<T> current = head;
			
			while (current.next != null) {
				current = current.next;
			}
			current.next = newNode;
		}
		
		size++;
	}
	
	public T get(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
	
		Node<T> current = head;
		
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		
		return current.data;
	}
	
	public void delete(int index) {
		
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> previous = head;
			
			for (int i = 0; i < index - 1; i++) {
				previous = previous.next;
			}
			previous.next = previous.next.next;
		}
		
		size--;
	}
	
	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<T> {
		private Node<T> current;
		
		public LinkedListIterator() {
			current = head;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		@Override
		public T next() {
			T data = current.data;
			current = current.next;
			
			return data;
		}
	}
	
	public static void main(String[] args) {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<10; i++) {
			list.add((int)(Math.random()*100));
		}
		
		for (int l : list) {
			sb.append(" " + l + " ");		
		}
		System.out.println("list : [" + sb + "]");
		
		
		list.delete(3);
		sb.setLength(0);
		for (int l : list) {
			sb.append(" " + l + " ");		
		}
		System.out.println("delete(3) : [" + sb + "]");
		
		list.get(5);
		System.out.print("get(5) : " + list.get(5));
	}
}