package fundamental;

public class NoVisibility {
	private static boolean ready;
	
	private static int number;
	
	public static void main(String[] args) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				long start = System.currentTimeMillis();
				while(!ready) {
					System.out.println("yield");
					Thread.yield();
				}
				System.out.println(number);
				System.out.println(System.currentTimeMillis() - start);
			}
		}).start();
		
		number = 42;
		ready = true;
	}
}
