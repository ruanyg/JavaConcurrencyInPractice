package fundamental;

/**
 * Created by ruanyg on 16/8/31.
 */
public class EscapeThis {
    public EscapeThis() {
        new Thread(new Runnable() {
            @Override
            public void run() {
               for(int i = 0; i < 5; i++) {
                   System.out.println("this溢出");
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        }).start();
    }

    public static void main(String[] args) {
        EscapeThis et = new EscapeThis();
    }
}
