package java基础;

import java.util.Random;

public class RandomDemo {

	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("Random Int-->"+random.nextInt());
		System.out.println("Random Rang Int-->"+random.nextInt(100));
		System.out.println("Random Boolean-->"+random.nextBoolean());
		System.out.println("Random Float-->"+random.nextFloat());
		System.out.println("Random Double-->"+random.nextDouble());
		System.out.println("Random Double Gaussian-->"+random.nextGaussian());
	}
}
