package JJS;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSet01 {
	public static void main(String[] args) {
		/**
		 * Set:无序（存储不一致），唯一
		 * HashSet：
		 * TreeSet：还可以对元素进行排序
		 */
		
		TreeSet<Integer> ts = new TreeSet<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer i1, Integer i2) {//前减后：升序，后减前：降序
				return i2-i1;
			}
			
		});
		ts.add(10);
		ts.add(6);
		ts.add(5);
		ts.add(5);
		ts.add(8);
		ts.add(1);
		System.out.println(ts);
		
	}
}
