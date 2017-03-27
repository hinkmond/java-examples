public class JavaLambdaExpr {

  public static void main(String args[]) {

    // new Thread with anonymous inner class
    Thread t1 = new Thread() {
      public void run() {
        System.out.println("Thread 1 started.");
      }
    };
    t1.start();

    // new Thread with anonymous class as a parameter
    Thread t2 = new Thread(new Runnable() {
      @Override
      public void run() {
        System.out.println("Thread 2 started.");
      }
    });
    t2.start();

    // Declare a Lambda Runnable
    Runnable t3Runnable = () -> { System.out.println("Thread 3 started."); };
    // new Thread with Lambda Expression
    new Thread(t3Runnable).start();

  }

}
