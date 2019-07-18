package zhong.JJS.A1612;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CourseFactory {
	public static ICourse getCourse(String name) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		if(name.equals("java")) {
			//	注意ioc中可以放任何的对象，因此从里面获取的所有对象都是object，因此需要强转。
			return (ICourse)context.getBean("javaCourse");
		}else {
			return (ICourse)context.getBean("htmlCourse");
			
		}
	}
}
