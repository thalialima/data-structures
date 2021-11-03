package br.com.alura.datastructures.doublyLinkedList;

public class DoubleCell {
	private Object element;
	private DoubleCell next;
	private DoubleCell previous;

	public DoubleCell(Object element, DoubleCell next) {
		this.element = element;
		this.next = next;
	}
	
	public DoubleCell(Object element) {
		this(element, null);
	}

	public Object getElement() {
		return element;
	}

	public void setElement(Object element) {
		this.element = element;
	}

	public DoubleCell getNext() {
		return next;
	}

	public void setNext(DoubleCell next) {
		this.next = next;
	}

	public DoubleCell getPrevious() {
		return previous;
	}

	public void setPrevious(DoubleCell previous) {
		this.previous = previous;
	}

	@Override
	public String toString() {
		return "Cell { " + "Element = " + element + ", Next = " + next + '}';
	}
}
