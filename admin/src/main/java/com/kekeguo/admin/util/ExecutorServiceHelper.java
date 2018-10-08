package com.kekeguo.admin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 自定义线程池
 *
 * @author zhouyu
 * @email zhouyu01@sunlands.com
 * @date_2018年09月01日09:52:28
 */
public class ExecutorServiceHelper {

    /**
     * logger
     */
    private static Logger logger = LoggerFactory.getLogger(ExecutorServiceHelper.class);

    /**
     * 获取活跃的 cpu数量
     */
    private static int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
    private final static BlockingQueue<Runnable> mWorkQueue;
    private final static long KEEP_ALIVE_TIME = 3L;
    private final static TimeUnit KEEP_ALIVE_TIME_UNIT = TimeUnit.SECONDS;
    private static ThreadFactory mThreadFactory;

    static {
        mWorkQueue = new LinkedBlockingQueue<Runnable>();
        /**
         * mThreadFactory= Executors.defaultThreadFactory();
         * 默认的工厂方法将新创建的线程命名为：pool-[虚拟机中线程池编号]-thread-[线程编号]
         */
        /**
         * 自定义线程信息
         */
        mThreadFactory = new NamedThreadFactory();
        logger.info("活跃CPU====》》》 NUMBER_OF_CORES = " + NUMBER_OF_CORES);
    }

    /**
     * 构造线程信息
     */
    private static class NamedThreadFactory implements ThreadFactory {
        private final AtomicInteger threadNumberAtomicInteger = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r, String.format(Locale.CHINA, "%s%d", "NamedThreadFactory", threadNumberAtomicInteger.getAndIncrement()));
            /* thread.setDaemon(true);//是否是守护线程
            thread.setPriority(Thread.NORM_PRIORITY);//设置优先级 1~10 有3个常量 默认 Thread.MIN_PRIORITY*/
            return thread;
        }
    }


    /**
     * 1.当线程池小于 corePoolSize 时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程。
     * 2.当线程池达到 corePoolSize 时，新提交任务将被放入 workQueue 中，等待线程池中任务调度执行
     * 3.当 workQueue 已满，且 maximumPoolSize > corePoolSize时，新提交任务会创建新线程执行任务
     * 4.当提交任务数超过 maximumPoolSize 时，新提交任务由 RejectedExecutionHandler 处理
     * 5.当线程池中超过 corePoolSize 线程，空闲时间达到 keepAliveTime 时，关闭空闲线程
     * 6.当设置 allowCoreThreadTimeOut(true) 时，线程池中 corePoolSize 线程空闲时间达到 keepAliveTime 也将关闭
     * <p>
     * maximumPoolSize 推荐取值
     * 如果是 CPU 密集型任务，就需要尽量压榨CPU，参考值可以设为 NUMBER_OF_CORES + 1 或 NUMBER_OF_CORES + 2
     * 如果是 IO 密集型任务，参考值可以设置为 NUMBER_OF_CORES * 2
     **/
    private static ExecutorService executorServiceInit() {
        return new ThreadPoolExecutor(NUMBER_OF_CORES,
                NUMBER_OF_CORES * 2, KEEP_ALIVE_TIME, KEEP_ALIVE_TIME_UNIT,
                mWorkQueue, mThreadFactory);
    }


    /**
     * 执行无返回值任务
     *
     * @param runnable
     */
    public static void doSubmit(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        ExecutorService executorService = executorServiceInit();
        executorService.execute(runnable);
    }


    /**
     * 执行有返回值任务
     *
     * @param callable
     * @return
     */
    public static Future getSubmit(Callable callable) {
        if (callable == null) {
            return null;
        }
        ExecutorService executorService = executorServiceInit();
        Future submit = executorService.submit(callable);
        return submit;
    }


}
