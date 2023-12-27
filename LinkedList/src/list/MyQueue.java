package list;

import java.util.NoSuchElementException;

public class MyQueue<T> extends MyLinkedList<T> {
	private MyLinkedList<T> list;
	
	public MyQueue() {
		list = new MyLinkedList<>();
	}
	
	public void enqueue(T data) {
		list.add(data);
	}
	
	public T dequeue() {
		if (isEmpty()) {
		throw new NoSuchElementException();
		}
	
		T data = list.get(0);
		list.delete(0);
		
		return data;
	}
	
	public boolean isEmpty() {
		return list.size == 0;
	}
	
	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);

		System.out.print(queue.dequeue() + " ");
		System.out.print(queue.dequeue() + " ");
		System.out.println(queue.dequeue());
	}
}

