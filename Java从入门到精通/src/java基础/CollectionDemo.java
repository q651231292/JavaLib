package java基础;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CollectionDemo {
	//Java8新特性 函数式编程
	//Lambda表达式格式:(参数)->{语句}
	public static void main(String[] args) {
		Map map =  new HashMap();
		map.put("1", "lb");
		map.put("2", "gy");
		map.put("3", "zf");
		map.forEach((name,val)->{
			System.out.println("名字->"+name+" 值"+val);
		});
	}
	
	public static void f1(){
		Collection list= new ArrayList();
		list.add("a");
		list.add("b");
		list.add("c");
		list.iterator().forEachRemaining(lang->System.out.println(lang));
	}
}
