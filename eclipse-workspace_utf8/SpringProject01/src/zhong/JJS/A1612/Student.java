package zhong.JJS.A1612;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhong.JJS.A1612.entity.Course;

public class Student {

	private int stuNo;
	private String stuName;
	private int age;

	public int getStuNo() {
		return stuNo;
	}

	public void setStuNo(int stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		String str = "姓名:" + this.stuName + ",学号: " + this.stuNo + ", 年龄：" + this.age;
		return str;
	}
	
	public void learn(String name) {
		//	通过自己编写的容器类里拿
//		Course course = CourseFactory.getCourse(name);
		
		//	直接从springioc工厂直接中获取，前提是已经在文件中注入了
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICourse course = (ICourse)context.getBean(name);
		course.learn();
	}
}
