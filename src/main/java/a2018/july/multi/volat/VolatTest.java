package a2018.july.multi.volat;

import a2018.july.multi.Factory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author GiraffeTree
 * @date 2018/7/15
 */
public class VolatTest {

    private static volatile int x = 1;

    public static void main(String[] args) {
        test1();
        if (Thread.activeCount() > 1) {
            System.out.println("activeCount:" + Thread.activeCount());
            Thread.yield();
        }
        System.out.println(x);

    }

    public static void test1() {
        ThreadPoolExecutor threadPoolExecutor = Factory.getThreadPoolExecutor();
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    x++;
                }
            });
        }

    }

}
