package in.student.pojo;

public class Student {
	
	private int studentId;
	private String studentName;
	private int studentStandard;
	private char studentGrade;
	private int studentRoll;
	private long studentContact;
	private String studentFee;
	public Student() {
		super();
	}
	public Student(int studentId) {
		super();
		this.studentId = studentId;
	}
	public Student(String studentName, int studentStandard, char studentGrade, int studentRoll, long studentContact,
			String studentFee) {
		super();
		this.studentName = studentName;
		this.studentStandard = studentStandard;
		this.studentGrade = studentGrade;
		this.studentRoll = studentRoll;
		this.studentContact = studentContact;
		this.studentFee = studentFee;
	}
	public Student(int studentId, String studentName, int studentStandard, char studentGrade, int studentRoll,
			long studentContact, String studentFee) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentStandard = studentStandard;
		this.studentGrade = studentGrade;
		this.studentRoll = studentRoll;
		this.studentContact = studentContact;
		this.studentFee = studentFee;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentStandard() {
		return studentStandard;
	}
	public void setStudentStandard(int studentStandard) {
		this.studentStandard = studentStandard;
	}
	public char getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(char studentGrade) {
		this.studentGrade = studentGrade;
	}
	public int getStudentRoll() {
		return studentRoll;
	}
	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}
	public long getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(long studentContact) {
		this.studentContact = studentContact;
	}
	public String getStudentFee() {
		return studentFee;
	}
	public void setStudentFee(String studentFee) {
		this.studentFee = studentFee;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentStandard="
				+ studentStandard + ", studentGrade=" + studentGrade + ", studentRoll=" + studentRoll
				+ ", studentContact=" + studentContact + ", studentFee=" + studentFee + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
