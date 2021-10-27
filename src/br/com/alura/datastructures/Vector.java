package br.com.alura.datastructures;

import java.util.Arrays;

public class Vector {
    private Student[] students = new Student[100];
    private int totalStudents = 0;

    private void moreSpace(){
        if(totalStudents == students.length){
            Student[] newStudents = new Student[students.length*2];
            for (int i = 0; i < students.length; i++){
                newStudents[i] = students[i];
            }
            this.students = newStudents;
        }
    }

    public void add(Student student){
        moreSpace();
        this.students[totalStudents] = student;
        totalStudents++;
    }

    private boolean validPosition(int position){
        return position >= 0 && position <= totalStudents;
    }

    public void add(Student student, int position){
        moreSpace();
        if (!validPosition(position)){
            throw new IllegalArgumentException("Invalid position!");
        }
       for (int i = totalStudents -1; i >= position; i-=1){
           students[i+1] = students[i];
       }
       students[position] = student;
       totalStudents++;
    }

    private boolean filledPosition(int position){
        return position >= 0 && position < totalStudents;
    }

    public Student getStudent(int position){
        if(!filledPosition(position)){
            throw new IllegalArgumentException("Invalid position!");
        }
        return students[position];
    }

    public void remove(int position){

        if (!filledPosition(position)){
            throw new IllegalArgumentException("Invalid position");
        }
        for (int i = position; i < this.totalStudents; i++){
            students[i] = students[i+1];
        }
        this.totalStudents--;
    }

    public boolean contain(Student student){
        for (int i = 0; i < this.totalStudents; i++){
            if(student.equals(students[i]))
                return true;
        }
        return false;
    }

    public int size(){
        return totalStudents;
    }

    public String toString(){
        return Arrays.toString(students);
    }


}
