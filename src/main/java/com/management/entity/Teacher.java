package com.management.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import java.util.HashSet;
import java.util.Set;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany
    @JoinTable(
        name = "classroom_teacher", 
        joinColumns = @JoinColumn(name = "teacher_id"), 
        inverseJoinColumns = @JoinColumn(name = "classroom_id")
    )
    private Set<ClassRoom> classRooms = new HashSet<>();

    public Teacher() {}

    public Teacher(String name) {
        this.name = name;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<ClassRoom> getClassRooms() {
		return classRooms;
	}

	public void setClassRooms(Set<ClassRoom> classRooms) {
		this.classRooms = classRooms;
	}

}
