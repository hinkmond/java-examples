public class JavaLambdaExpr {

  public static void main(String args[]) {

    // new Thread with anonymous inner class
    Thread t0 = new Thread() {
      public void run() {
        System.out.println("Thread 0 started.");
      }
    };
    t0.start();

    // new Thread with anonymous class as a parameter
    Thread t1 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Thread 1 started.");
      }
    });
    t1.start();

    // Declare a Lambda Runnable
    Runnable t2Runnable = () -> { System.out.println("Thread 2 started."); };
    // new Thread using Lambda Expression
    new Thread(t2Runnable).start();

  }

}
