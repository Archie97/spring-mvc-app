package com.examples.studentapp.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.examples.studentapp.model.Student;

@Service("studentService")
public class StudentService {

	Map<Integer, Student> studentsList = new HashMap<Integer,Student>();

	public StudentService() {
		Student student1 = new Student();
		student1.setAddress("Hyd");
		student1.setEmail("student1@mail.com");
		student1.setId(1);
		student1.setSection(1);
		student1.setFatherName("xyz");
		student1.setName("Student 1");
		studentsList.put(1, student1);

		Student student2 = new Student();
		student2.setAddress("Hyd");
		student2.setEmail("student2@mail.com");
		student2.setId(2);
		student2.setSection(2);
		student2.setFatherName("def");
		student2.setName("Student 2");
		studentsList.put(2, student2);
	}

	public Student findById(Integer id) {
		return studentsList.get(id);
	}

	public List<Student> findAll() {
		return new ArrayList<Student>(studentsList.values());
	}

	public void save(Student student) {
		studentsList.put(student.getId(), student);
	}

	public void update(Student student) throws Exception {
		if (studentsList.containsKey(student.getId())) {
			studentsList.put(student.getId(), student);
		} else {
			throw new Exception("Student doesn't exist");
		}
	}

	public void delete(int id) {
		for (Iterator<Integer> iterator = studentsList.keySet().iterator(); iterator.hasNext();) {
			Integer key = iterator.next();
			if (key == id) {
				iterator.remove();
			}
		}
	}

	public void saveOrUpdate(Student student) throws Exception {
		if (student.isNew()) {
			student.setId(studentsList.size()+1);
			save(student);
		} else {
			update(student);
		}
		
	}

}