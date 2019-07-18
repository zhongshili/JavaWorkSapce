package zhong.JJS.A1612.entity;

public class Course {
	private int courseHour;
	private String courseName;
	private Teacher teacher;//授课老师，依赖于Teacher。
	
	public Course() {
		
	}
	public Course(int courseHour, String courseName, Teacher teacher) {
		this.courseHour = courseHour;
		this.courseName = courseName;
		this.teacher = teacher;
	}
	public int getCourseHour() {
		return courseHour;
	}
	public void setCourseHour(int courseHour) {
		this.courseHour = courseHour;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public void showInfo() {
		System.out.println(this.courseName+","+this.courseHour+","+this.teacher.getName());
	}
}
