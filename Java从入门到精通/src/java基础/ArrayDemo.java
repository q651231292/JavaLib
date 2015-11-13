package java基础;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayDemo {


	public static void fun1(){//对数组排序
		int [] arrys = new int[]{5,3,9,1,2,0};
		Arrays.sort(arrys);
		System.out.println(Arrays.toString(arrys));
	}
	public static void fun2(){//遍历二维数组
		int [] [] arrys = new  int [][]{{1},{2,3},{4,5,6}};
		for(int i=0;i<arrys.length;i++){
			for(int j=0;j<arrys[i].length;j++){//列指针小于当前一维数组的长度
				System.out.print(arrys[i][j]);
			}
			System.out.println();
		}
	}
	public static void fun3(){//填充数组
		int [] arry = new int[5];
		Arrays.fill(arry, 0);//数组内容全部填充成0
		System.out.println(Arrays.toString(arry));//全局填充
		Arrays.fill(arry,0,2,1);//填充值1,填充位置0-2
		System.out.println(Arrays.toString(arry));//局部填充
	}
	public static void fun4(){//修改数组
		int [] arr = new int[]{45,12,2,10};
		Arrays.fill(arr,1,3,8);//指定范围内做修改
		System.out.println(Arrays.toString(arr));
	}
	public static void fun5(){//复制一维数组
		int [] arr = new int[]{45,12,2,10};
		int [] newArr = Arrays.copyOf(arr, arr.length);
		System.out.println(Arrays.toString(newArr));
	}
	public static void fun6(){//复制二维数组
		System.out.print("Star Copy Int Arrays-->");
		int [][] arrs = new int[][]{{45,12,2,10},{45,12,2,10,100}};
		int [][] newArrs = (int [] [])arrs.clone();//开始复制
		for(int [] newArr:newArrs){
			System.out.print(Arrays.toString(newArr));//输出
		}
		System.out.println();//换行
		System.out.print("Star Copy String Arrays-->");
		String [][] strArrs = new String[][]{{"a","b","c"},{"A","B","C","D"},{"1","2"}};
		String [][] newStrArrs = (String [] [])strArrs.clone();//开始复制
		for(String [] newStrArr:newStrArrs){
			System.out.print(Arrays.toString(newStrArr));//输出
		}
	}
	public static void fun7(){//局部复制一维数组
		System.out.print("Star CopyOfRang Arrays-->");
		int [] arr = new int[]{45,12,2,10};
		int [] newArr = Arrays.copyOfRange(arr, 0, 2);
		System.out.println(Arrays.toString(newArr));
	}
	public static void fun8(){//数组查询
		System.out.println("Please input Search Targ:");
		int targ = new Scanner(System.in).nextInt();//输入
		int [] arr = new int[]{1,8,9,4,5};
		Arrays.sort(arr);//排序
		int index = Arrays.binarySearch(arr, targ);//搜索
		System.out.println(targ+"'s index = "+index);//输出
	}
	public static void fun9(){//局部数组查询
		System.out.println("Please input Search Targ:");
		int targ = new Scanner(System.in).nextInt();//输入
		System.out.println("Please input Search FromIndex:");
		int fromIndex = new Scanner(System.in).nextInt();//输入
		System.out.println("Please input Search ToIndex:");
		int toIndex = new Scanner(System.in).nextInt();//输入
		int [] arr = new int[]{1,8,9,4,5};
		Arrays.sort(arr);//排序
		int index = Arrays.binarySearch(arr,fromIndex,toIndex, targ);//搜索
		System.out.println(targ+"'s index = "+index);//输出
	}
	public static void fun10(){
		int [] arr = new int[]{45,12,2,10};
		int index;
		for(int i=1;i<arr.length;i++){
			index=0;
			for(int j=1;j<=arr.length-i;j++){
				if(arr[j]>arr[index]){
					index=j;
				}
			}
			int temp = arr[arr.length-1];
			arr[arr.length-1]=arr[index];
			arr[index]=temp;
		}
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		//fun1();
		//fun2();
		//fun3();
		//fun4();
		//fun5();
		//fun6();
		//fun7();
		//fun8();
		//fun9();
		fun10();
	}
	
}
