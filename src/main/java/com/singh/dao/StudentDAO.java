package com.singh.dao;

import java.util.List;

import com.singh.model.Student;

public interface StudentDAO {
	public int save(Student s);
	public List<Student> list();
	public void delete(int studentid);
	public Student getbyid(int studentid);
	public List<Student> getbyname(String name);

}
