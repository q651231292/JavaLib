import java.awt.Color;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Demo1 {

	public static void fun2() {
		JFrame window = new JFrame("国际象棋棋盘");// 窗口
		window.setSize(595, 595);// 大小
		window.setLocationRelativeTo(null);// 居中
		int grids = 30;// 网格数
		int gridSize = 20;// 网格大小
		for (int i = 0; i < grids; i++) {//外循环控制行
			for (int j = 0; j < grids; j++) {//内循环控制列
				JLabel grid = new JLabel();
				grid.setSize(gridSize, gridSize);
				grid.setLocation(i * gridSize, j * gridSize);
				if ((i + j) % 2 == 0) {
					grid.setBackground(Color.black);//设置网格为黑色
					grid.setOpaque(true);// 不透明
				} else {
					grid.setBackground(Color.white);//设置网格为白色
					grid.setOpaque(true);
				}
				grid.setBorder(BorderFactory.createLineBorder(Color.black));
				window.add(grid);
			}
		}
		window.setVisible(true);
	}

	// 杨辉三角
	public static void fun1() {
		System.out.println("请输入行数:");
		Scanner in = new Scanner(System.in);// 接收行数
		int num = in.nextInt();
		int[][] triangle = getTriangle(num);// 构造三角形
		for (int i = 1; i < triangle.length; i++) {// 打印三角形
			for (int j = 1; j <= i; j++) {
				System.out.print(triangle[i][j] + "\t");
			}
			System.out.println();
		}

	}

	private static int[][] getTriangle(int num) {
		int[][] triangle = new int[num][num];
		for (int i = 0; i < triangle.length; i++) {// 画出杨慧三角的边
			triangle[i][0] = 1;
			triangle[i][i] = 1;
		}
		for (int i = 1; i < triangle.length; i++) {// 计算杨慧三角内部的值
			for (int j = 1; j <= i; j++) {
				triangle[i][j] = triangle[i - 1][j] + triangle[i - 1][j - 1];
			}
		}
		return triangle;// 返回
	}

	public static void main(String[] args) {
		fun2();
	}
}
