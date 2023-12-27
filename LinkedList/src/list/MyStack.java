package list;

import java.util.NoSuchElementException;

public class MyStack<T> extends MyLinkedList<T> {
	private MyLinkedList<T> list;
	
	public MyStack() {
		list = new MyLinkedList<>();
	}
	
	public void push(T data) {
		list.add(data);
	}
	
	public T pop() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T data = list.get(list.size - 1);
		list.delete(list.size - 1);
		
		return data;
	}
	
	public boolean isEmpty() {
		return list.size == 0;
	}
	
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<>();
		stack.push("A");
		stack.push("B");
		stack.push("C");

		System.out.print(stack.pop() + " ");
		System.out.print(stack.pop() + " ");
		System.out.println(stack.pop());
	}
}
