package br.com.alura.datastructures.linkedList;

import br.com.alura.datastructures.Student;

public class LinkedListTest {

    public static void main(String[] args) {

        Student s1 = new Student("Thalia");
        Student s2 = new Student("Maria");
        Student s3 = new Student("Carla");

        Student s4 = new Student("Ana");
        Student s5 = new Student("Júlia");
        Student s6 = new Student("Andrea");

        LinkedList list = new LinkedList();

        System.out.println(list);

        list.addBegin(s1);
        list.addBegin(s2);
        list.addBegin(s3);

        System.out.println(list);

        list.addEnd(s4);
        list.addEnd(s5);


        list.add(2, s6);
        System.out.println(list);

        System.out.println(list.getElement(1));
        System.out.println(list.size());

        list.removeBegin();
        System.out.println(list);

        System.out.println(list.size());
    }

}
