package br.com.alura.datastructures.doublyLinkedList;


public class DoublyLinkedList {

	private DoubleCell first;
	private DoubleCell last;
	private int totalElements = 0;

	public DoublyLinkedList() {
		this.first = new DoubleCell(null, null);
	}

	public void addBegin(Object element) {
		if (this.totalElements == 0) {
			DoubleCell newDoubleCell = new DoubleCell(element);
			this.first = newDoubleCell;
			this.last = newDoubleCell;
			this.totalElements++;
			} else {
			DoubleCell newDoubleCell = new DoubleCell(element, this.first);
			this.first.setPrevious(newDoubleCell);
			this.first = newDoubleCell;
			this.totalElements++;
		}
	}

	public void addEnd(Object element) {
		if (this.totalElements == 0) {
			addBegin(element);
		} else {
			DoubleCell newDoubleCell = new DoubleCell(element);
			this.last.setNext(newDoubleCell);
			newDoubleCell.setPrevious(this.last);
			this.last = newDoubleCell;
			totalElements++;
		}
	}

	public void add(int position, Object element) {
		if (position == 0) {
			addBegin(element);
		} else if (position == this.totalElements) {
			addEnd(element);
		} else {
			DoubleCell previous = getCell(position - 1);
			DoubleCell newCell = new DoubleCell(element, previous.getNext());
			DoubleCell pNext = previous.getNext();

			newCell.setPrevious(previous);
			previous.setNext(newCell);
			pNext.setPrevious(newCell);
			totalElements++;
		}
	}

	private boolean filledPosition(int position) {
		return position >= 0 && position < this.totalElements;
	}

	public DoubleCell getCell(int position) {
		if (!filledPosition(position))
			throw new IllegalArgumentException("There is not element at this position");
		DoubleCell current = this.first;
		for (int i = 0; i < position; i++) {
			current = current.getNext();
		}
		return current;
	}

	public Object getElement(int position) {
		return getCell(position).getElement();
	}

	public void removeBegin() {
		if (totalElements == 0) {
			throw new IllegalArgumentException("The list is empty!");
		}

		this.first = first.getNext();
		this.totalElements--;

		if (this.totalElements == 0) {
			this.last = null;
		}
	}

	public void remove(int position) {

		if (!filledPosition(position)) {
			throw new IllegalArgumentException("The position is already empty");
		}
		if (position == 0) {
			removeBegin();
			return;
		}else if(position == totalElements - 1) {
			removeEnd();
		}
		DoubleCell previousCell = getCell(position - 1);
		DoubleCell current = previousCell.getNext();
		DoubleCell next = current.getNext();
		
		previousCell.setNext(next);
		next.setPrevious(previousCell);
		this.totalElements--;
	}
	
	public void removeEnd() {
		if(this.totalElements == 0) {
			removeBegin();
		}else {
			DoubleCell lastButOne = this.last.getPrevious();
			lastButOne.setNext(null);
			this.last = lastButOne;
			totalElements--;
		}
	}

	public int size() {
		return this.totalElements;
	}

	public boolean contains(Object o) {
		DoubleCell current = this.first;
		while (current != null) {
			if (o.equals(current.getElement())) {
				return true;
			}
			current = current.getNext();
		}
		return false;
	}

	@Override
	public String toString() {
		if (this.totalElements == 0)
			return "[]";

		DoubleCell current = this.first;
		StringBuilder builder = new StringBuilder("[");

		for (int i = 0; i < totalElements; i++) {
			builder.append(current.getElement());
			builder.append(',');
			current = current.getNext();
		}
		builder.append("]");

		return builder.toString();

	}
}
