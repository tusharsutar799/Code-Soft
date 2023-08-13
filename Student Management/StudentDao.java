package in.student.dao;

import java.util.List;

import in.student.pojo.Student;

public interface StudentDao {
	
	public boolean AddStudent(Student student);
	public boolean UpdateStudent(Student student);
	public boolean DeleteStudent(Student student);
	public Student GetOneStudent(Student student);
	public List<Student> ShowStudents();
	
	}
