package zhong.JJS.A1612.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import zhong.JJS.A1612.ICourse;
import zhong.JJS.A1612.Student;
import zhong.JJS.A1612.entity.AllCollection;
import zhong.JJS.A1612.entity.Course;
import zhong.JJS.DAO.impl.StudentDaoImpl;
import zhong.JJS.service.IStudentService;
import zhong.JJS.service.StudentServiceImpl;

public class Test {
	public static void main(String[] args) {
		learnCourse();
		learnCourseWithIOC();
		// testDI();
		testContructionDI("course1");
		testContructionDI("course2");
		collectionDemo();
		testAop();
	}

	/**
	 * 主要使用springIOC
	 */
	public static void learnCourseWithIOC() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc中获取对象，里面是传的id值
		Student student = (Student) context.getBean("student");
		student.learn("htmlCourse");
	}

	public static void learnCourse() {
		/**
		 * 这是一般最基础的做法 Student student = new Student(); student.setAge(20);
		 * student.setStuName("钟世立"); student.setStuNo(1);
		 * System.out.println(student.toString());
		 */

		/**
		 * 用IOC创建对象
		 */
		// 加载配置文件,spring上下文对象：context
		// 配置文件就相当于容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Student student = (Student) context.getBean("student");
		System.out.println(student.toString());

	}

//	此处因为涉及到两个包之间的依赖，不能直接使用
//	public static void testDI() {
//		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		//	从ioc中获取对象，里面是传的id值
//		ICourse course = (ICourse)context.getBean("course");
//		course.learn();
//	}

	/**
	 * 类之间的依赖关系
	 * 
	 * @param couName
	 */
	public static void testContructionDI(String couName) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc中获取对象，里面是传的id值
		Course course = (Course) context.getBean(couName);
		course.showInfo();
	}

	/**
	 * 注入各种集合类
	 */
	public static void collectionDemo() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		AllCollection allCollection = (AllCollection) context.getBean("collectionDemo");
		System.out.println(allCollection.toString());
	}

	/**
	 * 测试Aop
	 */
	public static void testAop() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 从ioc中获取对象，里面是传的id值
		IStudentService studentService = (IStudentService) context.getBean("studentService");
		Student student  = new Student();
		student.setAge(20);
		student.setStuName("钟世立");
		student.setStuNo(2);
		studentService.addStudent(student);;
	}

}
