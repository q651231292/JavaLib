package java基础;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import bean.Student;

public class SetDemo {

	public static void main(String[] args) {
		Student stu1 = new Student(1,"刘备");
		Student stu2 = new Student(2,"关羽");
		Student stu3 = new Student(3,"张飞");
		Student stu4 = new Student(4,"马超");
		TreeSet treeSet = new TreeSet();
		treeSet.add(stu1);
		treeSet.add(stu2);
		treeSet.add(stu3);
		treeSet.add(stu4);
		/*************************************/
		treeSet.forEach(lang->System.out.println(lang));
		Iterator beforeIt = treeSet.headSet(stu3).iterator();//截取 stu2之前的对象
		beforeIt.forEachRemaining(lang->System.out.println("Before Stu2's obj->"+lang));
		Iterator subIt = treeSet.subSet(stu3, stu4).iterator();//截取stu1-stu4中间的对象
		subIt.forEachRemaining(lang->System.out.println("Sub obj->"+lang));
		/*************************************/
	}
}
