package a2018.july.multi;

import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Factory {


    private static final BasicThreadFactory basicThreadFactory = new BasicThreadFactory.Builder()
            .namingPattern("thread-%d").daemon(true).build();

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 40, 1000L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
            basicThreadFactory, new ThreadPoolExecutor.AbortPolicy());

    public static ThreadPoolExecutor getThreadPoolExecutor() {
        return threadPoolExecutor;
    }




}
