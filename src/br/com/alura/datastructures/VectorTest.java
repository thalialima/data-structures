package br.com.alura.datastructures;

import java.util.ArrayList;

public class VectorTest {
    //O vetor possui armazenamento sequencial

    public static void main(String[] args) {
        Student s1 = new Student("John");
        Student s2 = new Student("Joseph");

        Vector list = new Vector();

        System.out.println(list.size());
        list.add(s1);
        System.out.println(list.size());
        list.add(s2);
        System.out.println(list.size());

        System.out.println(list);

        System.out.println(list.contain(s2));

        Student s3 = new Student("Thalia");
        System.out.println(list.contain(s3));

        Student x = list.getStudent(1);
        System.out.println(x);

        Student s4 = new Student("Danilo");
        list.add(s4, 1);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);

        for(int i = 0; i < 300; i++){
            Student student = new Student("Daniel " + i);
            list.add(student);
        }
        System.out.println(list);

        //O Java já possui uma implementação de vetor
        //seu armazenamento é sequencial
        ArrayList<Student> students = new ArrayList<>();
    }
}
