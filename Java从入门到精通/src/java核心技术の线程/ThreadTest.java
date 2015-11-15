package java核心技术の线程;

public class ThreadTest extends Thread {

	public static void main(String[] args) {
		new ThreadTest().start();
	}
	int count=10;
	
	@Override
	public void run() {
		while(true){
			System.out.println(count+" ");
			if(--count==0){
				return;
			}
		}
	}
}
