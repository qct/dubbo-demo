package qct;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * <p>Created by Damon.Q on 2017/4/18.
 */
//@Component
public class TestConsumer implements InitializingBean {

//    @Reference(registry = "registry1", group = "myGroup", version = "1.0")
    private DemoService demoService;

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println(demoService.sayHello("Jack"));
    }
}
