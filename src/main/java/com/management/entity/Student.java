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
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@ManyToMany
	@JoinTable(
			name = "classroom_student", 
			joinColumns = @JoinColumn(name = "student_id"), 
			inverseJoinColumns = @JoinColumn(name = "classroom_id")
			)
	private Set<ClassRoom> classRooms = new HashSet<>();

	public Student() {}

	public Student(String name) {
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
