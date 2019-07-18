package com.JJS;

public class 计算时间 {
	public static void main(String[] args) {
		//获取开始时间
		long start = System.currentTimeMillis();//获取当前时间的毫秒值
		for(int i = 0;i<10000;i++) {
			System.out.println("hello world");
		}
		//获取结束时间
		long end=System.currentTimeMillis();
		//输出运行的毫秒值
		System.out.println(end-start);
	}
}
