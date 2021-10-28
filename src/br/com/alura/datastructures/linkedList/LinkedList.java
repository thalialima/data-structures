package br.com.alura.datastructures.linkedList;

public class LinkedList {

    private Cell first;
    private Cell last;
    private int totalElements = 0;

    public LinkedList() {
        this.first = new Cell(null, null);
    }

    public void addBegin(Object element) {
        Cell newCell = new Cell(element, this.first);
        this.first = newCell;

        if (this.totalElements == 0)
            this.last = this.first;

        totalElements++;
    }

    public void addEnd(Object element) {
        if (this.totalElements == 0) {
            addBegin(element);
        } else {
            Cell newCell = new Cell(element, null);
            this.last.setNext(newCell);
            this.last = newCell;

            this.totalElements++;
        }
    }

    public void add(int position, Object element) {
        if (position == 0) {
            addBegin(element);
        } else if (position == this.totalElements) {
            addEnd(element);
        } else {
            Cell previous = getCell(position - 1);
            Cell newCell = new Cell(element, previous.getNext());
            previous.setNext(newCell);
        }
    }

    private boolean filledPosition(int position) {
        return position >= 0 && position < this.totalElements;
    }

    public Cell getCell(int position) {
        if (!filledPosition(position))
            throw new IllegalArgumentException("There is not element at this position");
        Cell current = this.first;
        for (int i = 0; i < position; i++) {
            current = current.getNext();
        }
        return current;
    }

    public Object getElement(int position){
        return getCell(position).getElement();
    }

    public void removeBegin(){
        if(totalElements == 0){
            throw new IllegalArgumentException("The list is empty!");
        }

        this.first = first.getNext();
        this.totalElements--;

        if(this.totalElements == 0){
            this.last = null;
        }
    }

    public void remove(int position) {

    }


    public int size() {
        return this.totalElements;
    }

    public boolean contains(Object o) {
        return false;
    }

    @Override
    public String toString() {
        if (totalElements == 0)
            return "[]";

        return "LinkedList { " +
                "Cell = " + first +
                '}';
    }
}
