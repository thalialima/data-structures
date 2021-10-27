package br.com.alura.datastructures;

import java.util.Objects;

public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
       Student other = (Student) o;
       return other.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student { " +
                "Name = '" + name + '\'' +
                '}';
    }
}
