package zhong.JJS.service;

import java.sql.SQLException;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import zhong.JJS.A1612.Student;
import zhong.JJS.DAO.IStudentDao;
import zhong.JJS.DAO.impl.StudentDaoImpl;

public class StudentServiceImpl implements IStudentService{
	IStudentDao studentDao = new StudentDaoImpl();
	public void setStudentDao(IStudentDao studentDao) {
		this.studentDao = studentDao;
	}
	//	这个语句就相当于是遇到这两个错误就回滚，rollbackFor= {SQLException.class,ArithmeticException.class}
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,
			rollbackFor= {SQLException.class,ArithmeticException.class})
	@Override
	public void addStudent(Student student) {
		// if(学生是否存在)
		// 增加其他
		// 这里就是实现要么都成功，要么都失败
		studentDao.addStudent(student);
		
	}
	
}
