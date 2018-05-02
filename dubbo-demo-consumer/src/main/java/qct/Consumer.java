package qct;

import java.util.concurrent.ExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class Consumer {

    private static final Logger logger = LoggerFactory.getLogger(Consumer.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/consumer.xml");
        context.start();

        // consumer async
/*        DemoService demoService = context.getBean(DemoService.class);
        System.out.println(demoService.sayHello("Jack"));
        System.out.println("-----------called-------------");
        Future<String> future = RpcContext.getContext().getFuture();
        String result = future.get();
        System.out.println("result:" + result);
        System.out.println("-----------finished-------------");*/

        // provider async
//        Thread.sleep(50000L);
        DemoService demoService = context.getBean(DemoService.class);

        for (int i = 0; i < 10; i++) {
            System.out.println(demoService.sayHello("Jack"));
            Thread.sleep(10000L);
        }


        System.exit(0);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }

        /*
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable myRunnable = () -> {
            for (int i = 0; i < 5; i++) {
                String hello = consumer.demoService.sayHello("world"); // 执行远程方法
                logger.debug("consumer: {}", hello);
            }
        };
        for(int i=0;i<5;i++) {
            executor.submit(myRunnable);
        }

        try {
            logger.debug("attempt to shutdown executor");
            executor.shutdown();     executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            logger.warn("tasks interrupted");
        } finally {
            if (!executor.isTerminated()) {
                logger.warn("cancel non-finished tasks");
            }
            executor.shutdownNow();
            logger.debug("shutdown finished");
        }

        System.exit(0);*/
    }
}
