package in.student.test;

import java.util.List;
import java.util.Scanner;

import in.student.dao.StudentDao;
import in.student.dao.StudentDaoIMPL;
import in.student.pojo.Student;

public class StudentControl {

	public static void main(String[] args) {

		int studentId;
		String studentName;
		int studentStandard;
		char studentGrade;
		int studentRoll;
		long studentContact;
		String studentFee;
		Student student;
		StudentDao studentDao = new StudentDaoIMPL();
		boolean result;

		System.out.println("=========================================================");
		System.out.println("====================== WELCOME TO =======================");
		System.out.println("=============== STUDENT MANAGEMENT SYSTEM ===============");
		System.out.println("=========================================================");
		while (true) {
			System.out.println("    1) Show All Student                                  ");
			System.out.println("    2) Search Student                                    ");
			System.out.println("    3) Add Student                                       ");
			System.out.println("    4) Update Student                                    ");
			System.out.println("    5) Delete Student                                    ");
			System.out.println("    6) Exit                                              ");
			System.out.print("    Please Enter Your Choice : ");
			Scanner scan = new Scanner(System.in);
			int choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("=========================================================");
				System.out.println("==================== STUDENTS LIST ======================");
				System.out.println("=========================================================");
				List<Student> listStudent = studentDao.ShowStudents();
				if (!listStudent.isEmpty()) {
					for (Student stud : listStudent) {
						System.out.println(stud);
					}
				} else {
					System.out.println("   Student Not Added !!!! ");
				}
				System.out.println("=========================================================");
				System.out.println("=========================================================");
				break;

			case 2:
				System.out.println("=========================================================");
				System.out.println("================= STUDENT INFORMATION ===================");
				System.out.println("=========================================================");
				System.out.print("   Enter Student id : ");
				studentId = scan.nextInt();
				student = new Student(studentId);
				Student stu = studentDao.GetOneStudent(student);
				System.out.println(stu);
				System.out.println("=========================================================");
				System.out.println("=========================================================");
				break;

			case 3:
				System.out.println("=========================================================");
				System.out.println("===================== ADD STUDENT =======================");
				System.out.println("=========================================================");
				System.out.print("   Enter Student Name        : ");
				scan.nextLine(); // Consume the newline character left by previous nextInt().
				studentName = scan.nextLine();
				System.out.print("   Enter Student Standard    : ");
				studentStandard = scan.nextInt();
				System.out.print("   Enter Student Grade       : ");
				studentGrade = scan.next().toUpperCase().charAt(0);
				System.out.print("   Enter Student Roll Number : ");
				studentRoll = scan.nextInt();
				System.out.print("   Enter Student Contact     : ");
				studentContact = scan.nextLong();
				while (true) {
					System.out.print("   Enter Student Fee Clear (YES OR NO) : ");
					String feeString = scan.next().toUpperCase();
					if (feeString.equals("YES")) {
						studentFee = "YES";
						break;
					} else if (feeString.equals("NO")) {
						studentFee = "NO";
						break;
					} else {
						System.out.println("   ERROR : Please Answer in YES or NO !!!!");
					}
				}

				student = new Student(studentName, studentStandard, studentGrade, studentRoll, studentContact,
						studentFee);
				result = studentDao.AddStudent(student);
				if (result) {
					System.out.println("  -----------------------------------------------------  ");
					System.out.println("              Student added successfully.");
					
				} else {
					System.out.println("  -----------------------------------------------------  ");
					System.out.println("        Failed to add student. Please try again.");
					
				}
				System.out.println("=========================================================");
				System.out.println("=========================================================");
				break;
			case 4 :
				System.out.println("=========================================================");
				System.out.println("==================== STUDENT UPDATE =====================");
				System.out.println("=========================================================");
				System.out.print("   Enter Student id : ");
				studentId = scan.nextInt();
				student = new Student(studentId);
				Student std = studentDao.GetOneStudent(student);
				System.out.println(std);
				System.out.println("  -----------------------------------------------------  ");
				System.out.print("   Enter Student Name        : ");
				scan.nextLine();
				studentName = scan.nextLine();
				System.out.print("   Enter Student Standard    : ");
				studentStandard = scan.nextInt();
				System.out.print("   Enter Student Grade       : ");
				studentGrade = scan.next().toUpperCase().charAt(0);
				System.out.print("   Enter Student Roll Number : ");
				studentRoll = scan.nextInt();
				System.out.print("   Enter Student Contact     : ");
				studentContact = scan.nextLong();
				while (true) {
					System.out.print("   Enter Student Fee Clear (YES OR NO) : ");
					String feeString = scan.next().toUpperCase();
					if (feeString.equals("YES")) {
						studentFee = "YES";
						break;
					} else if (feeString.equals("NO")) {
						studentFee = "NO";
						break;
					} else {
						System.out.println("   ERROR : Please Answer in YES or NO !!!!");
					}
				}
				student = new Student(studentId, studentName, studentStandard, studentGrade, studentRoll, studentContact,
						studentFee);
				result = studentDao.UpdateStudent(student);
				if (result) {
					System.out.println("  -----------------------------------------------------  ");
					System.out.println("              Student Updated Successfully.");
					
				} else {
					System.out.println("  -----------------------------------------------------  ");
					System.out.println("        Failed to Update student. Please try again.");
					
				}
				System.out.println("=========================================================");
				System.out.println("=========================================================");
				break;
			case 5:
				System.out.println("=========================================================");
				System.out.println("==================== STUDENT DELETE =====================");
				System.out.println("=========================================================");
				System.out.print("   Enter Student id : ");
				studentId = scan.nextInt();
				student = new Student(studentId);
				Student stud = studentDao.GetOneStudent(student);
				System.out.println(stud);
				System.out.println("  -----------------------------------------------------  ");
				System.out.println("   Are You Sure Delete This Record ? YES OR NO ");
				while (true) {
					String ansString = scan.next().toUpperCase();

					if (ansString.equals("YES")) {
						/* student = new Student(studentId); */
						result = studentDao.DeleteStudent(student);
						if (result) {
							System.out.println("  -----------------------------------------------------  ");
							System.out.println("              Student Delete successfully.");
							break;
						} else {
							System.out.println("  -----------------------------------------------------  ");
							System.out.println("        Failed to Delete student. Please try again.");
							break;
						}
					} else if (ansString.equals("NO")) {
						System.out.println("              Student will not be deleted.");
						break;
					} else {
						System.out.println("        Invalid input. Please enter YES or NO.");
					}
				}
				System.out.println("=========================================================");
				System.out.println("=========================================================");
				break;

			case 6:
				System.out.println(" Exiting the Student Management System !");
				System.out.println("=========================================================");
				scan.close(); // Closing the scanner before exiting the program.
				System.exit(0); // Exit the program with status 0 (successful).
			default:
				System.out.println("Invalid choice!");
				System.out.println("=========================================================");
				break;
			}
		}

	}

}
