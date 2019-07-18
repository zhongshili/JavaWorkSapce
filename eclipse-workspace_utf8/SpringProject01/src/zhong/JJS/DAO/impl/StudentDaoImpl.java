package zhong.JJS.DAO.impl;

import org.springframework.stereotype.Component;

import zhong.JJS.A1612.Student;
import zhong.JJS.DAO.IStudentDao;

//	使用注解定义bean,这一步是准备将该类加入配置文件
@Component("studentDao")
public class StudentDaoImpl implements IStudentDao{
	public void addStudent(Student student) {
		System.out.println("增加学生....");
	}
}
