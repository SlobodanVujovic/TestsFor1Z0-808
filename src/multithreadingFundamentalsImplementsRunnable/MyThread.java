package multithreadingFundamentalsImplementsRunnable;

public class MyThread implements Runnable {
	private Thread thrd;

	public MyThread(String name) {
		thrd = new Thread(this, name);
		thrd.start();
	}

	public Thread getThrd() {
		return thrd;
	}

	@Override
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			for (int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + thrd.getName() + ", count is " + count);
			}
		} catch (InterruptedException exp) {
			System.out.println(thrd.getName() + " is interrupted.");
		}
		System.out.println(thrd.getName() + " is terminated.");
	}
}
