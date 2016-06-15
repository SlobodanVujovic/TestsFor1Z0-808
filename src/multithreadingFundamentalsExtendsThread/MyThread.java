package multithreadingFundamentalsExtendsThread;

public class MyThread extends Thread {

	public MyThread(String name) {
		super(name);
		start();
	}

	@Override
	public void run() {
		System.out.println(getName() + " starting.");
		try {
			for (int count = 0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + getName() + ", count is " + count);
			}
		} catch (InterruptedException exp) {
			System.out.println(getName() + " is interrupted.");
		}
		System.out.println(getName() + "is terminated.");
	}
}
