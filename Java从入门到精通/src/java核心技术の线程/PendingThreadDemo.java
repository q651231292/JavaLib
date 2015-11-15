package java核心技术の线程;

public class PendingThreadDemo {
	public Console console = new Console();

	private void writeToConsole1() throws Exception{
		synchronized (console) {
			Thread.sleep(1 * 1000); // NOTE:sleep时并未释放console别的线程是不能锁定console的
		}
	}

	private void writeToConsole2() throws Exception {
		synchronized (console) {
			console.wait(1 * 1000); // NOTE:wait时别的线程是可以锁定console的
		}
	}
}

// 控制台类
class Console {
	
}
