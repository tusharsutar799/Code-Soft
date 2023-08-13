package in.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.css.RGBColor;

import in.student.pojo.Student;
import in.student.utility.Connect;

public class StudentDaoIMPL implements StudentDao {
	PreparedStatement ps;
	Connection conn = Connect.getConnectionn();
	Statement statement;
	int result;
	String query;

	@Override
	public boolean AddStudent(Student student) {
		query = "insert into student(name,standard,grade,roll,contact,fee)values(?,?,?,?,?,?)";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, student.getStudentName());
			ps.setInt(2, student.getStudentStandard());
			ps.setString(3, String.valueOf(student.getStudentGrade()));
			ps.setInt(4, student.getStudentRoll());
			ps.setLong(5, student.getStudentContact());
			ps.setString(6, student.getStudentFee());
			result = ps.executeUpdate();
			if (result > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean UpdateStudent(Student student) {
		query = "update student set name=?,standard=? ,grade=?,roll=?,contact=?,fee=? where id=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, student.getStudentName());
			ps.setInt(2, student.getStudentStandard());
			ps.setString(3, String.valueOf(student.getStudentGrade()));
			ps.setInt(4, student.getStudentRoll());
			ps.setLong(5, student.getStudentContact());
			ps.setString(6, student.getStudentFee());
			ps.setInt(7, student.getStudentId());
			result = ps.executeUpdate();
			if (result > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean DeleteStudent(Student student) {
		query = "delete from student where id=?";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, student.getStudentId());
			result = ps.executeUpdate();
			if (result > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Student GetOneStudent(Student student) {
		query = "select * from student where id=?;";
		try {
			ps = conn.prepareStatement(query);
			ps.setInt(1, student.getStudentId());
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student.setStudentId(rs.getInt(1));
				student.setStudentName(rs.getString(2));
				student.setStudentStandard(rs.getInt(3));
				student.setStudentGrade(rs.getString(4).charAt(0));
				student.setStudentRoll(rs.getInt(5));
				student.setStudentContact(rs.getLong(6));
				student.setStudentFee(rs.getString(7));
			}

			return student;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> ShowStudents() {
		List<Student> studList = new ArrayList<Student>();
		query = "select * from student;";
		try {
			ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getInt(1));
				student.setStudentName(rs.getString(2));
				student.setStudentStandard(rs.getInt(3));
				student.setStudentGrade(rs.getString(4).charAt(0));
				student.setStudentRoll(rs.getInt(5));
				student.setStudentContact(rs.getLong(6));
				student.setStudentFee(rs.getString(7));
				studList.add(student);
			}

			return studList;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
