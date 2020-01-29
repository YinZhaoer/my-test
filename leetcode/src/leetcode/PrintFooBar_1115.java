package leetcode;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;


public class PrintFooBar_1115 {
    public static void main(String[] args) {
        FooBar fooBar=new FooBar(3);
        System.out.println(System.currentTimeMillis() + "");
        ThreadPoolExecutor threadPoolExecutor = new ScheduledThreadPoolExecutor(8);
        threadPoolExecutor.submit(() -> {
            System.out.println("asda");
        }
    }
}

