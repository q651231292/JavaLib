package java基础;

import java.util.Scanner;

public class StringBuilderDemo {

	public static void main(String[] args) {
		System.out.println("Please Input ForNum:");
		int forNum = new Scanner(System.in).nextInt();
		String str=new String();
		long starTime = System.currentTimeMillis();//开始时间
		for(int i=0;i<forNum;i++){//执行10000次操作
			str+=i;
		}
		long endTime = System.currentTimeMillis();//结束时间
		long strTime = endTime-starTime;//运行时间
		System.out.println("String Time="+strTime);//输出0
		
		StringBuilder sb = new StringBuilder();
		starTime = System.currentTimeMillis();
		for(int i=0;i<forNum;i++){
			sb.append(i);
		}
		endTime = System.currentTimeMillis();
		long sbTime = endTime-starTime;
		System.out.println("StringBuilder Time="+sbTime);
	}
}
